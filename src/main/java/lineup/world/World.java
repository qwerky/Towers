package lineup.world;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import lineup.model.Blast;
import lineup.model.Bunker;
import lineup.model.Creep;
import lineup.model.Level;
import lineup.model.Location;
import lineup.model.Projectile;
import lineup.model.Wave;

/**
 * Encapsulates the state of the world.
 * @author Neil
 */
public class World {

  private static final int WAVE_COOLDOWN = 6000;

  private static World instance;
  
  private List<Bunker> bunkers = new ArrayList<Bunker>();
  private List<Projectile> projectiles = new ArrayList<Projectile>();
  private List<Creep> creeps = new ArrayList<Creep>();
  private List<Blast> blasts = new ArrayList<Blast>();
  
  private Level level;
  private int waveCooldown = 7000;
  private boolean onCooldown = true;
  
  private Player player = new Player(100, 5000);
  
  private final int width;
  private final int height;
  
  /**
   * Private constructor.
   * @param width
   * @param height
   */
  private World(int width, int height) {
    this.width = width;
    this.height = height;
  }
  
  public static void init(int width, int height) {
    instance = new World(width, height);
  }
  
  public static World getInstance() {
    return instance;
  }
  
  public List<Bunker> getBunkers() {
    return bunkers;
  }
  
  public void setBunkers(List<Bunker> bunkers) {
    this.bunkers = bunkers;
  }
  
  public List<Projectile> getProjectiles() {
    return projectiles;
  }
  
  public void setProjectiles(List<Projectile> projectiles) {
    this.projectiles = projectiles;
  }
  
  public List<Creep> getCreeps() {
    return creeps;
  }
  
  public void setCreeps(List<Creep> creeps) {
    this.creeps = creeps;
  }
  
  public List<Blast> getBlasts() {
    return blasts;
  }

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public void update(int elapsed) {
    synchronized (bunkers) {
      for (Bunker b : bunkers) {
        b.update(elapsed);
      }
    }
    
    updateBlasts(elapsed);
    
    for (Projectile p : projectiles) {
      p.update(elapsed);
    }
    
    for (Creep c : creeps) {
      c.update(elapsed);
    }
    
    if (level.getWaves().peek() != null) {
      spawn(elapsed);
    }
    
    collisionDetection();
  }

  private void updateBlasts(int elapsed) {
    for (ListIterator<Blast> blit = blasts.listIterator(); blit.hasNext();) {
      Blast blast = blit.next();
      blast.update(elapsed);
      if (blast.hasExpired()) {
        blit.remove();
      }
    }
  }

  private void spawn(int elapsed) {
    if (onCooldown) {
      waveCooldown -= elapsed;
      if (waveCooldown <= 0) {
        waveCooldown = WAVE_COOLDOWN;
        onCooldown = false;
      }
    } else {
      Wave currentWave = level.getWaves().getFirst();
      
      if (currentWave.spawnRequired(elapsed)) {
        Creep creep = currentWave.spawn();
        creep.getRoute().add(level.getBase());
        creeps.add(creep);
        //System.out.println("Spawned " + creep + " now " + creeps.size() + " in world");
      }
      
      if (currentWave.getRemaining() == 0) {
        level.getWaves().removeFirst();
        onCooldown = true;
      }
    }
  }

  private void collisionDetection() {
    removeOffScreenProjectiles();
    detectProjectileCreepHits();
    detectCreepAtBase();
  }

  private void removeOffScreenProjectiles() {
    ListIterator<Projectile> prit = projectiles.listIterator();
    while (prit.hasNext()) {
      Projectile p = prit.next();
      Location l = new Location(p.getVector().getX(), p.getVector().getY());
      if (isOffScreen(l)) {
        prit.remove();
      }
    }
  }
  
  private void detectProjectileCreepHits() {
    ListIterator<Creep> crip = creeps.listIterator();
    while (crip.hasNext()) {
      Creep creep = crip.next();
      Rectangle creepRect = creep.getBoundingRect();
      
      ListIterator<Projectile> prit = projectiles.listIterator();
      while (prit.hasNext()) {
        Projectile projectile = prit.next();
        if (creepRect.intersects(projectile.getBoundingRect())) {
          if (projectile.getBlastSize() > 1) {
            blasts.add(projectile.getBlast());
          } else {
            creep.setHealth(creep.getHealth() - projectile.getDamage());
            if (creep.getHealth() <= 0) {
              player.giveMoney(creep.getValue());
              projectile.getOwner().incrementKills();
              crip.remove();
              break;
            }
          }
          prit.remove();
        }
        
      }
    }
  }
  
  private void detectCreepAtBase() {
    ListIterator<Creep> crip = creeps.listIterator();
    while (crip.hasNext()) {
      Creep creep = crip.next();
      Rectangle baseRect = new Rectangle((int)level.getBase().x, (int)level.getBase().y, 10, 10);
      if (baseRect.intersects(creep.getBoundingRect())) {
        player.removeLife(1);
        creep.setHealth(0);
        crip.remove();
      }
    }
  }

  private boolean isOffScreen(Location l) {
    return l.x < 0 || l.x > width || l.y < 0 || l.y > height;
  }

  public boolean hasWon() {
    return level.getWaves().isEmpty() && creeps.isEmpty();
  }

  public boolean hasLost() {
    return player.getLives() == 0;
  }

  public Bunker getBunkerAtLocation(Point point) {
    Bunker selectedBunker = null;
    for (Bunker bunker : bunkers) {
      if (bunker.getBoundingRect().contains(point)) {
        bunker.setSelected(true);
        selectedBunker = bunker;
      } else {
        bunker.setSelected(false);
      }
    }
    return selectedBunker;
  }
  
  public boolean isOnWaveCooldown() {
    return onCooldown;
  }
  
  public int getWaveCooldown() {
    return waveCooldown;
  }
  
  public Wave getCurrentWave() {
    return level.getWaves().getFirst(); 
  }

  public Player getPlayer() {
    return player;
  }

  public void addBunker(Bunker bunker) {
    synchronized (bunkers) {
      bunkers.add(bunker);
    }
  }

  public void removeBunker(Bunker bunker) {
    synchronized (bunkers) {
      bunkers.remove(bunker);
    }
  }

}

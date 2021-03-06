package lineup.model.implementations.arms.light;

import lineup.model.Bunker;
import lineup.model.Location;
import lineup.model.Projectile;
import lineup.model.Target;
import lineup.model.implementations.arms.BurstGun;
import lineup.model.implementations.projectiles.MediumBullet;
import lineup.util.math.Vector2D;

/**
 * Gatling gun that fires long bursts.
 * @author Neil
 */
public class GatlingGun extends BurstGun {

  /**
   * Constructor.
   */
  public GatlingGun(Bunker bunker) {
    super(bunker, 8000, 20, 80, 9, 10);
  }

  @Override
  public Projectile createProjectile(Location location, Target target) {
    
    Vector2D v = new Vector2D(location, target.getCreep().getCentreLocation());
    Vector2D cv = target.getCreep().getVector();
    
    Projectile p = new MediumBullet(getOwner(), (int)location.x, (int)location.y, v.getBearing());
    p.getVector().add(cv);

    return p;
  }

  public String getName() {
    return "Gatling Gun";
  }

  public int getCost() {
    return 150;
  }

  public String getDescription() {
    return "Gatling gun that fires long bursts. Is able to lead targets.";
  }

  @Override
  public double getDPS() {
    // dps = bullets/sec * damage/bullet
    double rate = (double)(20 * 1000)/(double)(8000 + (20*80));
    double d = new MediumBullet(null, 0, 0, 0).getDamage();
    return rate * d;
  }

}

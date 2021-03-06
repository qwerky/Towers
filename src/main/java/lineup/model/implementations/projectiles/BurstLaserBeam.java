package lineup.model.implementations.projectiles;

import java.awt.Color;
import java.awt.Graphics;

import lineup.model.Bunker;
import lineup.model.Creep;
import lineup.model.Projectile;
import lineup.util.math.Vector2D;

public class BurstLaserBeam extends Projectile {

  private int beamDuration = 50;
  private Creep creep;
  
  /**
   * Constructor
   * @param owner
   * @param creep
   */
  public BurstLaserBeam(Bunker owner, Creep creep) {
    super(owner, new Vector2D(owner.getCentreLocation(), creep.getCentreLocation()), 1);
    this.creep = creep;
  }

  public void render(Graphics g) {
    g.setColor(Color.WHITE);
    int x1 = (int)getOwner().getCentreLocation().x;
    int y1 = (int)getOwner().getCentreLocation().y;
    int x2 = (int)creep.getCentreLocation().x;
    int y2 = (int)creep.getCentreLocation().y;
    g.drawLine(x1, y1, x2, y2);
  }

  public void update(int elapsed) {
    beamDuration -= elapsed;
    
    if (beamDuration <= 0) {
      getVector().setX(creep.getCentreLocation().x);
      getVector().setY(creep.getCentreLocation().y);
    }
  }

  @Override
  public double getDamage() {
    return 3;
  }

}

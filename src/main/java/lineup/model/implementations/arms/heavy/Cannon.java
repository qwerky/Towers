package lineup.model.implementations.arms.heavy;

import lineup.model.Bunker;
import lineup.model.Location;
import lineup.model.Projectile;
import lineup.model.Target;
import lineup.model.implementations.projectiles.MediumShell;
import lineup.model.implementations.arms.SingleShotGun;
import lineup.util.math.Vector2D;

/**
 * Cannon with 3 sec reload that fires Shells directly
 * at the target with no leading.
 * @author Neil
 */
public class Cannon extends SingleShotGun {

  private static final int reload = 3000;
  
  /**
   * Constructor.
   */
  public Cannon(Bunker bunker) {
    super(bunker, reload, 6, 3);
  }

  @Override
  public Projectile createProjectile(Location location, Target target) {
    Vector2D v = new Vector2D(location, target.getCreep().getCentreLocation());
    return new MediumShell(getOwner(), (int)location.x, (int)location.y, v.getBearing());
  }

  public String getName() {
    return "Cannon";
  }

  public int getCost() {
    return 40;
  }

  public String getDescription() {
    return "Basic cannon that fires shells in a straight line";
  }

  @Override
  public double getDPS() {
    MediumShell s = new MediumShell(null, 0, 0, 0);
    double d = s.getDamage();
    return d * 1000/reload;
  }

}

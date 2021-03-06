package lineup.model.implementations.trackers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lineup.model.Creep;
import lineup.model.Location;
import lineup.model.Target;
import lineup.model.TrackingSystem;

/**
 * TrackingSystem implementation that targets a single creep,
 * the nearest one in range.
 * @author Neil
 */
public abstract class NearestSingleTargetTracker extends TrackingSystem {

  private final int range;
  
  public NearestSingleTargetTracker(int range, int size, int power) {
    super(size, power);
    this.range = range;
  }
  
  @Override
  public List<Target> getTargets(Location location, List<Creep> creeps) {
    if (creeps.isEmpty()) {
      return Collections.emptyList();
    }
    
    List<Target> targets = new ArrayList<Target>();

    Creep nearest = findNearest(location, creeps);
    if (inRange(location, nearest)) {
      targets.add(new Target(1, nearest));
    }

    return targets;
  }

  private boolean inRange(Location me, Creep nearest) {
    double d = me.asPoint().distance(nearest.getCentreLocation().asPoint());
    return d <= range;
  }

  private Creep findNearest(Location location, List<Creep> creeps) {
    Creep nearest = creeps.get(0);
    double nearestDistance = location.asPoint().distance(nearest.getCentreLocation().asPoint());
    
    for (int i=1; i<creeps.size(); i++) {
      Creep creep = creeps.get(i);
      double creepDistance = location.asPoint().distance(creep.getCentreLocation().asPoint());
      if (creepDistance < nearestDistance) {
        nearest = creep;
        nearestDistance = creepDistance;
      }
    }
    
    return nearest;
  }

  @Override
  public int getRange() {
    return range;
  }

}

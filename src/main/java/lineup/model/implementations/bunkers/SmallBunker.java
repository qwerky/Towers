package lineup.model.implementations.bunkers;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import lineup.model.Bunker;
import lineup.model.implementations.arms.Cannon;
import lineup.model.implementations.trackers.BasicTracker;

/**
 * Small bunker with 10 size.
 * Contains a Cannon and BasicTracker.
 * @author 38183Ne
 *
 */
public class SmallBunker extends Bunker {

  private Image sprite;
  
  /**
   * Constructor.
   */
  public SmallBunker() {
    super(10, 50);
    setArms(new Cannon(this));
    setTracking(new BasicTracker());
    sprite = loadSprite(BunkerType.S);
  }

  public void render(JPanel view) {
    Graphics g = view.getGraphics();
    g.drawImage(sprite, (int)getLocation().x, (int)getLocation().y, null);
  }

  @Override
  public String getName() {
    return "Small Bunker";
  }

}
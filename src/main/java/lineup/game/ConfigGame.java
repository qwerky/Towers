package lineup.game;

import lineup.model.Bunker;
import lineup.model.implementations.SmallBunker;
import lineup.ui.UI;
import lineup.util.LevelFactory;
import lineup.world.World;

public class ConfigGame {

  private UI ui;
  
  public static void main(String[] args) {
    ConfigGame game = new ConfigGame(200, 200);
    game.start();
  }

  public ConfigGame(int width, int height) {
    ui = new UI(width, height);
    World.init(width, height);
    
    LevelFactory factory = LevelFactory.getInstance();
    World.getInstance().setLevel(factory.getLevel(0));
    
    Bunker bunker = new SmallBunker();
    bunker.setLocation(60, 60);
    World.getInstance().getBunkers().add(bunker);
    
    ui.launch();
  }
  
  private void start() {
    
    long time = System.nanoTime();
    boolean won = false;
    boolean lost = false;
    while (!won && !lost) {
      ui.display(World.getInstance());
      long elapsed = System.nanoTime() - time;
      time = System.nanoTime();
      World.getInstance().update((int) (elapsed/1000000));
      
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      won = World.getInstance().hasWon();
      lost = World.getInstance().hasLost();
    }
    
    ui.end(won);
  }
}

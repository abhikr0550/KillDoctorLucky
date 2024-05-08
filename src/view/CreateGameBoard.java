package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Create the image of the world and saves in a file.
 * 
 * @author Abhishek & Valay
 *
 */
public class CreateGameBoard {

  private Graphics graphics;

  /**
   * Initialises the Graphics.
   * 
   * @param g graphics object
   */
  public CreateGameBoard(Graphics g) {
    if (g == null) {
      throw new IllegalArgumentException("Invalid graphics object");
    }
    graphics = g;
    graphics.translate(10, 10);
  }

  /**
   * Plot each room of the world.
   * 
   * @param x1       : First Row
   * @param x2       : Last Column
   * @param y1       : First Column
   * @param y2       : Last Column
   * @param roomName : Room Name
   */
  public void plotTheWorld(int x1, int x2, int y1, int y2, String roomName) {
    graphics.setColor(Color.BLACK);
    graphics.drawRect(y1 * 20, x1 * 20, (y2 - y1) * 20 + 20, (x2 - x1) * 20 + 20);
    graphics.setFont(new Font("default", Font.BOLD, 12));
    graphics.drawString(roomName, (y1 * 20) + ((y2 - y1) * 2), (x1 * 20) + ((x2 - x1) * 12));

  }

  /**
   * Plot players in the world.
   * 
   * @param x x coordinate to plot player
   * @param y y coordinate to plot player
   */
  public void plotThePlayers(double y, double x) {
    Rectangle2D.Double rect = new Rectangle2D.Double(x * 20, y * 20, 10, 10);
    graphics.setColor(Color.DARK_GRAY);
    Graphics2D g2d = (Graphics2D) graphics.create();
    g2d.fill(rect);
  }

  /**
   * Plot target character in the world.
   * 
   * @param x x coordinate to plot the target
   * @param y y coordinate to plot the target
   */
  public void plotTheTarget(int y, int x) {
    Rectangle2D.Double rect = new Rectangle2D.Double((x + 1) * 20, (y + 1) * 20, 10, 10);
    graphics.setColor(Color.RED);
    Graphics2D g2d = (Graphics2D) graphics.create();
    g2d.fill(rect);
  }

  /**
   * Plot current player in the world.
   * 
   * @param x x coordinate to plot current player
   * @param y y coordinate to plot current player
   */
  public void plotCurrentPlayer(double y, double x) {
    Rectangle2D.Double rect = new Rectangle2D.Double(x * 20, y * 20, 10, 10);
    graphics.setColor(Color.BLUE);
    Graphics2D g2d = (Graphics2D) graphics.create();
    g2d.fill(rect);
  }

}

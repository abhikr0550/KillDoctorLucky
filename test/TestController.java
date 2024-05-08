import static org.junit.Assert.assertEquals;

import com.milestone2.controller.ControllerImplementation;
import com.milestone2.controller.Features;
import driver.MyRandom;
import driver.MyRandomInterface;
import facade.IntermediateWorld;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import view.GameView;

/**
 * A class to test if the controller works as expected or not. All possible
 * aspects of the controller to be tested in order to make sure that it works
 * fine in all cases it always works.
 * 
 * @author Abhishek & Valay
 *
 */
public class TestController {

  private IntermediateWorld facadeObj;
  private GameView viewObj;
  private StringBuilder str;
  private int maxTurn;
  private MyRandomInterface randObj;
  private String filePath;
  private String key;
  private Features controller;

  /**
   * It initialises the Mock facade in order to do the Controller testing
   * IntermediateMockWorldImplemenation.
   * 
   * @throws IOException if file throws exception.
   */
  @Before
  public void setUp() throws IOException {

    key = "mysecretkey";
    str = new StringBuilder();
    maxTurn = 30;
    randObj = new MyRandom(0, 2, 1, 2, 1, 0, 2);
    filePath = "worldSpecificationFile.txt";
    facadeObj = new IntermediateMockWorldImplemenation(str, key);
    viewObj = new GameViewMock(str, key);
    controller = new ControllerImplementation(facadeObj, viewObj, maxTurn, randObj, filePath);
  }

  @Test
  public void testValidController() {
    assertEquals(
        "getCurrentPlayerInformation method in model called and unique key is mysecretkey\n"
            + "setUpFrame method in view called and unique key is mysecretkey\n"
            + "addActionListener method in view called and unique key is mysecretkey\n"
            + "addKeyListenerInController method in view called and unique key is mysecretkey\n"
            + "addMouseListener method in view called and unique key is mysecretkey\n",
        str.toString());
  }

  @Test
  public void testPlayGame() {
    controller.playGame();
    assertEquals(
        "getCurrentPlayerInformation method in model called and unique key is mysecretkey\n"
            + "setUpFrame method in view called and unique key is mysecretkey\n"
            + "addActionListener method in view called and unique key is mysecretkey\n"
            + "addKeyListenerInController method in view called and unique key is mysecretkey\n"
            + "addMouseListener method in view called and unique key is mysecretkey\n"
            + "makeVisible method in view called with values : "
            + "welcome and unique key is mysecretkey\n",
        str.toString());
  }

  @Test
  public void testMovePlayerOnClick() {
    controller.playGame();
    controller.movePlayerOnClick(1, 1);
    assertEquals(
        "getCurrentPlayerInformation method in model called and unique key is mysecretkey\n"
            + "setUpFrame method in view called and unique key is mysecretkey\n"
            + "addActionListener method in view called and unique key is mysecretkey\n"
            + "addKeyListenerInController method in view called and unique key is mysecretkey\n"
            + "addMouseListener method in view called and unique key is mysecretkey\n"
            + "makeVisible method in view called with values : welcome and unique key "
            + "is mysecretkey\n"
            + "getWorldMatrix method in model called and unique key is mysecretkey\n"
            + "getRoomNames method in model called and unique key is mysecretkey\n"
            + "addPlayerUp method in view called and unique key is mysecretkey\n"
            + "getCurrentPlayerInformation method in model called and unique key is mysecretkey\n"
            + "setCurrentPlayerLabel method in view called and unique key is mysecretkey\n"
            + "setStatsLabel method in view called and unique key is mysecretkey\n"
            + "resetFocus method in view called and unique key is mysecretkey\n"
            + "repaint method in view called and unique key is mysecretkey\n"
            + "computerPlayer method in model called and unique key is mysecretkey\n"
            + "gameOver method in model called and unique key is mysecretkey\n"
            + "computerPlayer method in model called and unique key is mysecretkey\n",
        str.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLoadOtherFileInvalid() {
    String filePath = "Desktop/mymap.txt";
    controller.loadOtherFile(filePath);

  }

  @Test
  public void testLoadOtherFile() {
    String filePath = "./res/mansion.txt";
    controller.loadOtherFile(filePath);

    assertEquals(
        "getCurrentPlayerInformation method in model called and unique key is mysecretkey\n"
            + "setUpFrame method in view called and unique key is mysecretkey\n"
            + "addActionListener method in view called and unique key is mysecretkey\n"
            + "addKeyListenerInController method in view called and unique key is mysecretkey\n"
            + "addMouseListener method in view called and unique key is mysecretkey\n"
            + "setUpFrame method in view called and unique key is mysecretkey\n"
            + "addActionListener method in view called and unique key is mysecretkey\n"
            + "addKeyListenerInController method in view called and unique key is mysecretkey\n"
            + "addMouseListener method in view called and unique key is mysecretkey\n" + "",
        str.toString());
  }

  @Test
  public void testCheckIfPlayerPlotted() {
    controller.checkIfPlayerPlotted(3, 4);

    assertEquals(
        "getCurrentPlayerInformation method in model called and unique key is mysecretkey\n"
            + "setUpFrame method in view called and unique key is mysecretkey\n"
            + "addActionListener method in view called and unique key is mysecretkey\n"
            + "addKeyListenerInController method in view called and unique key is mysecretkey\n"
            + "addMouseListener method in view called and unique key is mysecretkey\n"
            + "checkIfPlayerPloted method in model called and unique key is mysecretkey\n" + "",
        str.toString());
  }

  @Test
  public void testShowPlayerInformation() {

    controller.showPlayerInformation(3, 4);

    assertEquals(
        "getCurrentPlayerInformation method in model called and unique key is mysecretkey\n"
            + "setUpFrame method in view called and unique key is mysecretkey\n"
            + "addActionListener method in view called and unique key is mysecretkey\n"
            + "addKeyListenerInController method in view called and unique key is mysecretkey\n"
            + "addMouseListener method in view called and unique key is mysecretkey\n"
            + "checkIfPlayerPloted method in model called and unique key is mysecretkey\n"
            + "getPlayerInformation method in model called and unique key is mysecretkey\n"
            + "playerDetailsPopUp method in view called and unique key is mysecretkey\n"
            + "resetFocus method in view called and unique key is mysecretkey\n"
            + "repaint method in view called and unique key is mysecretkey\n" + "",
        str.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testShowPlayerInformationInvalid() {

    controller.showPlayerInformation(-3, 4);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testShowPlayerInformationInvalid3() {

    controller.showPlayerInformation(3, -4);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testShowPlayerInformationInvalid1() {

    controller.checkIfPlayerPlotted(-3, 4);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testShowPlayerInformationInvalid4() {

    controller.checkIfPlayerPlotted(3, -4);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testLoadOtherFileInavalid() {
    String filePath = null;
    controller.loadOtherFile(filePath);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testMovePlayerOnClickInvalid() {
    controller.playGame();
    controller.movePlayerOnClick(-1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMovePlayerOnClickInvalid2() {
    controller.playGame();
    controller.movePlayerOnClick(1, -1);
  }
}

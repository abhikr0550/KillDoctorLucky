import driver.MyRandomInterface;
import facade.IntermediateWorld;
import java.awt.Graphics;

/**
 * 
 * IntermediateWorld is the facade class which acts as an interface between the
 * controller and the model. It has all the functionalities which the controller
 * can perform.
 * 
 * @author abhishekkumar
 */
public class IntermediateMockExceptionWorldImplemenation implements IntermediateWorld {

  private String key;

  /**
   * It initialises the the model object and calls it respective function to
   * perform model operations.
   * 
   * @param key the secret key passed by controller.
   */
  public IntermediateMockExceptionWorldImplemenation(String key) {
    if (key == null || key.isBlank()) {
      throw new IllegalArgumentException("Invalid unique key in GameViewMock");
    }
    this.key = key;
  }

  @Override
  public String movePlayer(String nextSpace, MyRandomInterface randObj) {
    throw new IllegalArgumentException("Room Details Invalid. Key: " + key);

  }

  @Override
  public String addPlayerToGame(String playerName, String firstRoom, int maxItemPlayer,
      boolean isBot) {
    throw new IllegalArgumentException("Player Details cannot be null. Key: " + key);
  }

  @Override
  public String lookUp() {
    throw new IllegalArgumentException("Invalid Turn. Key: " + key);
  }

  @Override
  public String displayPlayerDetails() {
    throw new IllegalArgumentException("Turn invalid. Key: " + key);

  }

  @Override
  public String getSpaceDetails(String roomName) {
    throw new IllegalArgumentException("Space name invalid. Key: " + key);

  }

  @Override
  public String pickUpItem(String itemName, MyRandomInterface randObj) {
    throw new IllegalArgumentException("Item Details invalid. Key: " + key);
  }

  @Override
  public String relocatePet(String roomName, MyRandomInterface randObj) {
    throw new IllegalArgumentException("Room Details invalid. Key: " + key);
  }

  @Override
  public String killTarget(String itemName) {
    throw new IllegalArgumentException("Item Details invalid. Key: " + key);
  }

  @Override
  public boolean computerPlayer() {
    throw new IllegalArgumentException("Computer player check invalid. Key: " + key);
  }

  @Override
  public boolean isPlayerEmpty() {
    throw new IllegalArgumentException("Player list empty check invalid. Key: " + key);
  }

  @Override
  public boolean playerTargetTogether() {
    throw new IllegalArgumentException("Player Target Together check invalid. Key: " + key);
  }

  @Override
  public boolean gameOver() {
    throw new IllegalArgumentException("Game Over check invalid. Key: " + key);
  }

  @Override
  public int getTargetHealth() {
    throw new IllegalArgumentException("Acquiring target health invalid. Key: " + key);
  }

  @Override
  public String getTargetName() {
    throw new IllegalArgumentException("Acquiring target name invalid. Key: " + key);
  }

  @Override
  public String[] getItemNames() {
    throw new IllegalArgumentException("Acquiring item names invalid. Key: " + key);
  }

  @Override
  public String[] getRoomNames() {
    throw new IllegalArgumentException("Acquiring room names invalid. Key: " + key);
  }

  @Override
  public String[] getPlayerItemNames() {
    throw new IllegalArgumentException("Acquiring player's item names invalid. Key: " + key);
  }

  @Override
  public String drawMap(Graphics g) {
    throw new IllegalArgumentException("Map plot invalid. Key: " + key);
  }

  @Override
  public int[][] getWorldMatrix() {
    throw new IllegalArgumentException("Acquiring world matrix invalid. Key: " + key);
  }

  @Override
  public String getWinner() {
    throw new IllegalArgumentException("Acquiring winner invalid. Key: " + key);
  }

  @Override
  public String getPlayerInformation(String playerName) {
    throw new IllegalArgumentException("Acquiring player information invalid. Key: " + key);
  }

  @Override
  public String checkIfPlayerPloted(int row, int col) {
    throw new IllegalArgumentException("Acquiring player plotted invalid. Key: " + key);
  }

  @Override
  public String getCurrentPlayerInformation() {
    throw new IllegalArgumentException("Acquiring current player information invalid. Key: " + key);
  }

  @Override
  public void setMaxturn(int maxTurn) {
    throw new IllegalArgumentException("Set max turn invalid. Key: " + key);
  }

}

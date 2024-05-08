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
 *
 */
public class IntermediateMockWorldImplemenation implements IntermediateWorld {

  private StringBuilder out;
  private String key;

  /**
   * It initialises the the model object and calls it respective function to
   * perform model operations.
   * 
   * @param key the secret key passed by controller.
   * @param out StringBuilder object
   */
  public IntermediateMockWorldImplemenation(StringBuilder out, String key) {
    if (out == null || key == null || key.isBlank()) {
      throw new IllegalArgumentException(
          "Invalid StringBuilder object or unique key in GameViewMock");
    }
    this.out = out;
    this.key = key;
  }

  @Override
  public String movePlayer(String nextSpace, MyRandomInterface randObj) {
    if (nextSpace == null || "".equals(nextSpace)) {
      throw new IllegalArgumentException("Room Details Invalid. Key: " + key);
    }
    StringBuilder str = new StringBuilder();
    str.append("movePlayer method in model called with values : " + nextSpace);
    str.append(" " + this.key);

    return str.toString();
  }

  @Override
  public String addPlayerToGame(String playerName, String firstRoom, int maxItemPlayer,
      boolean isBot) {
    if (playerName == null || firstRoom == null) {
      throw new IllegalArgumentException("Player Details cannot be null. Key: " + key);
    }
    if ("".equals(firstRoom) || "".equals(playerName) || maxItemPlayer <= 0) {
      throw new IllegalArgumentException("Invalid Input for the player. Key: " + key);
    }

    StringBuilder str = new StringBuilder();
    str.append("addPlayerToGame method in model called with values : " + playerName + ", "
        + firstRoom + ", " + maxItemPlayer + ", " + isBot);
    str.append(" " + this.key);

    return str.toString();
  }

  @Override
  public String lookUp() {

    StringBuilder str = new StringBuilder();
    str.append("lookUp method in model called");
    str.append(" " + this.key);

    return str.toString();
  }

  @Override
  public String displayPlayerDetails() {

    StringBuilder str = new StringBuilder();
    str.append("displayPlayerDetails method in model called with values : ");
    str.append(" " + this.key);

    return str.toString();
  }

  @Override
  public String getSpaceDetails(String roomName) {
    if (roomName == null || "".equals(roomName)) {
      throw new IllegalArgumentException("Space name invalid. Key: " + key);
    }
    StringBuilder str = new StringBuilder();
    str.append("getSpaceDetails method in model called with values : " + roomName);
    str.append(" " + this.key);

    return str.toString();
  }

  @Override
  public String pickUpItem(String itemName, MyRandomInterface randObj) {
    if (itemName == null || "".equals(itemName)) {
      throw new IllegalArgumentException("Item Details invalid. Key: " + key);
    }
    StringBuilder str = new StringBuilder();
    str.append("pickUpItem method in model called with values : " + itemName);
    str.append(" " + this.key);

    return str.toString();
  }

  @Override
  public String relocatePet(String roomName, MyRandomInterface randObj) {
    if (roomName == null || "".equals(roomName)) {
      throw new IllegalArgumentException("Item Details invalid. Key: " + key);
    }
    StringBuilder str = new StringBuilder();
    str.append("relocatePet method in model called with values : " + roomName);
    str.append(" " + this.key);

    return str.toString();
  }

  @Override
  public String killTarget(String itemName) {
    if (itemName == null || "".equals(itemName)) {
      throw new IllegalArgumentException("Item Details invalid. Key: " + key);
    }
    StringBuilder str = new StringBuilder();
    str.append("killTarget method in model called with values : " + itemName);
    str.append(" " + this.key + "\n");

    return str.toString();
  }

  @Override
  public boolean computerPlayer() {
    out.append(String.format("computerPlayer method in model called and unique key is %s\n", key));
    return false;
  }

  @Override
  public boolean isPlayerEmpty() {
    out.append(String.format("isPlayerEmpty method in model called and unique key is %s\n", key));
    return true;
  }

  @Override
  public boolean playerTargetTogether() {
    out.append(
        String.format("playerTargetTogether method in model called and unique key is %s\n", key));
    return true;
  }

  @Override
  public boolean gameOver() {
    out.append(String.format("gameOver method in model called and unique key is %s\n", key));
    return false;
  }

  @Override
  public int getTargetHealth() {
    out.append(String.format("getTargetHealth method in model called and unique key is %s\n", key));
    return 3;
  }

  @Override
  public String getTargetName() {
    out.append(String.format("getTargetName method in model called and unique key is %s\n", key));
    return "target";
  }

  @Override
  public String[] getItemNames() {
    out.append(String.format("getItemNames method in model called and unique key is %s\n", key));
    String[] itemNames = { "item1", "item2", "item3" };
    return itemNames;
  }

  @Override
  public String[] getRoomNames() {
    out.append(String.format("getRoomNames method in model called and unique key is %s\n", key));
    String[] roomNames = { "room1", "room2", "room3", "room4", "room5" };
    return roomNames;
  }

  @Override
  public String[] getPlayerItemNames() {
    out.append(
        String.format("getPlayerItemNames method in model called and unique key is %s\n", key));
    String[] itemNames = { "item1", "item2", "item3" };
    return itemNames;
  }

  @Override
  public String drawMap(Graphics g) {
    if (g == null) {
      throw new IllegalArgumentException("Graphics object invalid. Key: " + key);
    }
    out.append(String.format("drawMap method in model called and unique key is %s\n", key));
    return "map plotted";
  }

  @Override
  public int[][] getWorldMatrix() {
    out.append(String.format("getWorldMatrix method in model called and unique key is %s\n", key));
    int[][] matrix = { { 1, 2 }, { 3, 4 } };
    return matrix;
  }

  @Override
  public String getWinner() {
    out.append(String.format("getWinner method in model called and unique key is %s\n", key));
    return "player1";
  }

  @Override
  public String getPlayerInformation(String playerName) {
    if (playerName == null || playerName.isEmpty()) {
      throw new IllegalArgumentException("Invalid player name. Key: " + key);
    }
    out.append(
        String.format("getPlayerInformation method in model called and unique key is %s\n", key));
    return String.format("Player name: %s\nNot carrying any items\n", playerName);
  }

  @Override
  public String checkIfPlayerPloted(int row, int col) {
    out.append(
        String.format("checkIfPlayerPloted method in model called and unique key is %s\n", key));
    return "player1";
  }

  @Override
  public String getCurrentPlayerInformation() {
    out.append(String
        .format("getCurrentPlayerInformation method in model called and unique key is %s\n", key));
    return "Player name: %s\nNot carrying any items\n";
  }

  @Override
  public void setMaxturn(int maxTurn) {
    out.append(String
        .format("getCurrentPlayerInformation method in model called and unique key is %s\n", key));
  }

}

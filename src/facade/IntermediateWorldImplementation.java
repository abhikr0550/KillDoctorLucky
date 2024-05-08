package facade;

import driver.MyRandomInterface;
import java.awt.Graphics;
import world.Player;
import world.PlayerImplementation;
import world.World;

/**
 * 
 * IntermediateWorld is the facade class which acts as an interface between the
 * controller and the model. It has all the functionalities which the controller
 * can perform.
 * 
 * @author Abhishek & Valay
 *
 */
public class IntermediateWorldImplementation implements IntermediateWorld {

  private World worldObj;

  /**
   * It initialises the the model object and calls it respective function to
   * perform model operations.
   * 
   * @param worldObj the object of the model.
   */
  public IntermediateWorldImplementation(World worldObj) {

    if (worldObj == null) {
      throw new IllegalArgumentException("World cannot be null");
    }
    this.worldObj = worldObj;
  }

  @Override
  public String movePlayer(String nextSpace, MyRandomInterface randObj) {

    if (nextSpace == null) {
      throw new IllegalArgumentException("Invalid room name");
    }
    return worldObj.movePlayer(nextSpace, randObj);

  }

  @Override
  public String addPlayerToGame(String playerName, String firstRoom, int maxItemPlayer,
      boolean isBot) {

    if (playerName == null || firstRoom == null) {
      throw new IllegalArgumentException("Player Details cannot be null");
    }
    if ("".equals(firstRoom) || "".equals(playerName) || maxItemPlayer <= 0) {
      throw new IllegalArgumentException("Invalid Input for the player");
    }
    Player player = new PlayerImplementation(playerName, firstRoom, maxItemPlayer, isBot);
    return worldObj.addPlayerToGame(player);
  }

  @Override
  public String lookUp() {

    return worldObj.lookUp();
  }

  @Override
  public String displayPlayerDetails() {

    return worldObj.displayPlayerDetails();
  }

  @Override
  public String getSpaceDetails(String roomName) {

    if (roomName == null) {
      throw new IllegalArgumentException("Invalid room name");
    }
    return worldObj.getSpaceDetails(roomName);
  }

  @Override
  public String pickUpItem(String itemName, MyRandomInterface randObj) {

    if (itemName == null || randObj == null) {
      throw new IllegalArgumentException("Item Name cannot be null");
    }
    return worldObj.pickUpItem(itemName, randObj);
  }

  @Override
  public String relocatePet(String roomName, MyRandomInterface randObj) {

    if (roomName == null || randObj == null) {
      throw new IllegalArgumentException("Invalid room name");
    }
    return worldObj.movePet(roomName, randObj);
  }

  @Override
  public String killTarget(String itemName) {

    if (itemName == null) {
      throw new IllegalArgumentException("Invalid item name");
    }
    return worldObj.killTarget(itemName);
  }

  @Override
  public boolean computerPlayer() {
    return worldObj.computerPlayer();
  }

  @Override
  public boolean isPlayerEmpty() {
    return worldObj.isPlayerEmpty();
  }

  @Override
  public boolean playerTargetTogether() {
    return worldObj.playerTargetTogether();

  }

  @Override
  public boolean gameOver() {
    return worldObj.gameOver();
  }

  @Override
  public int getTargetHealth() {
    return worldObj.getTargetHealth();
  }

  @Override
  public String getTargetName() {
    return worldObj.getTargetName();
  }

  @Override
  public String[] getItemNames() {
    return worldObj.getItemNames();
  }

  @Override
  public String[] getRoomNames() {
    String[] roomNames = new String[worldObj.getRoomNames().size()];
    for (int i = 0; i < worldObj.getRoomNames().size(); i++) {
      roomNames[i] = worldObj.getRoomNames().get(i);
    }
    return roomNames;
  }

  @Override
  public String drawMap(Graphics g) {
    if (g == null) {
      throw new IllegalArgumentException("Invalid graphics");
    }
    return worldObj.createGraph(g);

  }

  @Override
  public String[] getPlayerItemNames() {
    return worldObj.getPlayerItemNames();

  }

  @Override
  public int[][] getWorldMatrix() {
    return worldObj.getWorldMatrix();
  }

  @Override
  public String getWinner() {
    return worldObj.getWinner();
  }

  @Override
  public void setMaxturn(int maxTurn) {
    if (maxTurn < 0) {
      throw new IllegalArgumentException("Invalid max turns");
    }
    worldObj.setMaxturn(maxTurn);
  }

  @Override
  public String getPlayerInformation(String playerName) {
    if (playerName == null || playerName.isBlank()) {
      throw new IllegalArgumentException("Invalid player name");
    }
    return worldObj.getPlayerInformation(playerName);
  }

  @Override
  public String checkIfPlayerPloted(int row, int col) {
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException("Invalid row or colummn");
    }
    return worldObj.checkIfPlayerPloted(row, col);
  }

  @Override
  public String getCurrentPlayerInformation() {
    return worldObj.getCurrentPlayerInformation();
  }
}

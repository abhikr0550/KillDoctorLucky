package facade;

import java.awt.Graphics;

/**
 * ReadOnlyIntermediateWorld is the facade class which acts as an read only
 * interface between the view and the model. It has all the functionalities
 * which the view can perform of read only type.
 * 
 * @author Abhishek & Valay
 */
public interface ReadOnlyIntermediateWorld {

  /**
   * This is called from the controller in order to check the neighbours of a
   * room. According to the given turn, it decides the player and then the room
   * the player is currently residing in. After then it returns the details of
   * neighbours of that room.
   * 
   * @return the string of details of neighbours.
   */
  public String lookUp();

  /**
   * This is called from the controller in order to display the player details. It
   * finds the player whose turn it is to play and returns the details of that
   * player.
   * 
   * 
   * @return the string of details of the player.
   */
  public String displayPlayerDetails();

  /**
   * 
   * This is called from the controller in order to display the details of any
   * particular space.
   * 
   * @param roomName is the name of the space whose details is required.
   * @return the details of the space.
   */
  public String getSpaceDetails(String roomName);

  /**
   * It returns if the current player is human or a computer.
   * 
   * @return true if computer player else returns false
   */
  public boolean computerPlayer();

  /**
   * Checks if there is any player in the world or not.
   * 
   * @return true if there is at least 1 player else returns false.
   */
  public boolean isPlayerEmpty();

  /**
   * It checks if the target and player are in the same room.
   * 
   * @return true if target and current player is in the same room.
   */
  public boolean playerTargetTogether();

  /**
   * It checks if game is Over or not.
   * 
   * @return true if the game is over.
   */
  public boolean gameOver();

  /**
   * Get target's current health.
   * 
   * @return Target's current health
   */
  public int getTargetHealth();

  /**
   * Get target's name.
   * 
   * @return Target's name
   */
  public String getTargetName();

  /**
   * Get item names in the world.
   * 
   * @return Item names in the world.
   */
  public String[] getItemNames();

  /**
   * Get room names in the world.
   * 
   * @return Room names in the world.
   */
  public String[] getRoomNames();

  /**
   * Get items carried by the current player.
   * 
   * @return Items carried by the current player
   */
  public String[] getPlayerItemNames();

  /**
   * Draw graphical representation of the world.
   * 
   * @param g Graphics object
   * @return Graph plotted if success
   */
  public String drawMap(Graphics g);

  /**
   * Get world interpretation matrix.
   * 
   * @return World interpretation matrix
   */
  public int[][] getWorldMatrix();

  /**
   * Get the winner name.
   * 
   * @return Winner name
   */
  public String getWinner();

  /**
   * Display player information i.e. player name and list of items on it.
   * 
   * @param playerName Player name who's details are requested
   * @return Player information i.e. player name and list of items on it
   */
  String getPlayerInformation(String playerName);

  /**
   * Check if player is plotted at given coordinates.
   * 
   * @param row row value of the plot
   * @param col column value of the plot
   * @return Player name who is present at given coordinate. Null if not present.
   */
  public String checkIfPlayerPloted(int row, int col);

  /**
   * Get current player's information.
   * 
   * @return Current player's information
   */
  String getCurrentPlayerInformation();

}

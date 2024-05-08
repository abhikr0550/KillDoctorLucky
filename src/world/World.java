package world;

import driver.MyRandomInterface;
import java.awt.Graphics;
import java.util.List;

/**
 * World is the place where the board game is created. It is responsible to
 * store all the rooms in the world. It also does the checking of the
 * neighbouring room while adding the room. It also is responsible to move the
 * target from one space to another. The world takes the input from the facade
 * class and processed the input and returns the output accordingly. Player can
 * also relocate pet and attempt to kill the target.
 */
public interface World {

  /**
   * It returns the name of the world.
   * 
   * @return the name of the world.
   */
  public String getworldName();

  /**
   * It checks for the overlap of the room if a new room is added. It also checks
   * for the neighbours of the given room. Finally it adds the room in the world.
   * 
   * @param room : the room to be added in the world.
   * @return true if the room is added successfully.
   */
  public boolean addRoom(Room room);

  /**
   * This is called from the controller in order to add a new player to the game.
   * The player is added to the first room and also to the world.
   * 
   * @param player : the player to be added in the world.
   * @return the string if the player is added successfully or not.
   */
  public String addPlayerToGame(Player player);

  /**
   * It adds the pet object into the World.
   * 
   * @param pet : The pet object to be added in the world.
   */
  public void addPet(Pet pet);

  /**
   * It returns the list of Room object which is stored in the world.
   * 
   * @return the list of the rooms from the world..
   */
  public List<Room> getRooms();

  /**
   * Display the info of the world.
   */
  void displayInfo();

  /**
   * This is called from the controller in order to check the neighbours of a
   * room. According to the given turn, it decides the player and then the room
   * the player is currently residing in. After then it returns the details of
   * neighbours of that room.
   * 
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
   * 
   * This is called from the controller in order to move the player to its one of
   * its neighbouring rooms.
   * 
   * @param nextSpace is the space where the player wants to move.
   * @param randObj   is the random object to choose random neighbours for
   *                  computer player.
   * @return if move is successful.
   */
  public String movePlayer(String nextSpace, MyRandomInterface randObj);

  /**
   * 
   * This is called from the controller in order to pick the item from the
   * player's room.
   * 
   * @param itemName is the item which the player wants to pick.
   * @param randObj  is the random object to pick random item for computer player.
   * @return if pick is successful or not.
   */
  public String pickUpItem(String itemName, MyRandomInterface randObj);

  /**
   * This function plots the graphn of the world which consists of the outline of
   * the existing spaces.
   * 
   * @param g Graphics object
   * 
   * @return the success or failure message on graph creation.
   */
  public String createGraph(Graphics g);

  /**
   * 
   * This is called from the controller in order to move the player to a specific
   * room in the world.
   * 
   * @param roomName is the item which the player wants to pick.
   * @param randObj  is the random object to pick random item for computer player.
   * 
   * @return the movement details of the pet.
   */
  public String movePet(String roomName, MyRandomInterface randObj);

  /**
   * 
   * This is called from the controller in order to make an attempt to kill the
   * target. The attack can be done using a weapon or poking. Attack is successful
   * if no one is watching the attack
   * 
   * @param itemName is the item which the player wants to pick.
   * 
   * @return the kill details of the target.
   */
  public String killTarget(String itemName);

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
   * @return list of Room names in the world.
   */
  public List<String> getRoomNames();

  /**
   * Get items carried by the current player.
   * 
   * @return Items carried by the current player
   */
  public String[] getPlayerItemNames();

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
   * Set maximum turn.
   * 
   * @param maxTurn Maximum number of turns
   */
  public void setMaxturn(int maxTurn);

  /**
   * Display player information i.e. player name and list of items on it.
   * 
   * @param playerName Player name who's details are requested
   * @return Player information i.e. player name and list of items on it
   */
  public String getPlayerInformation(String playerName);

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

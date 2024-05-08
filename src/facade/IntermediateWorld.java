package facade;

import driver.MyRandomInterface;

/**
 * 
 * IntermediateWorld is the facade class which acts as an interface between the
 * controller and the model. It has all the functionalities which the controller
 * can perform.
 * 
 * @author Abhishek & Valay
 *
 */
public interface IntermediateWorld extends ReadOnlyIntermediateWorld {

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
   * This is called from the controller in order to add the player to the game.
   * The player can be computer pr human.
   * 
   * @param playerName    name of the player.
   * @param firstRoom     name of the landing room.
   * @param maxItemPlayer maximum number of item a player can carry.
   * @param isBot         whether the player is computer or human.
   * @return if move is successful.
   */
  public String addPlayerToGame(String playerName, String firstRoom, int maxItemPlayer,
      boolean isBot);

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
   * 
   * This is called from the controller in order to move the player to a specific
   * room in the world.
   * 
   * @param roomName is the item which the player wants to pick.
   * @param randObj  is the random object to pick random item for computer player.
   * 
   * @return the movement details of the pet.
   */
  public String relocatePet(String roomName, MyRandomInterface randObj);

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
   * Set maximum turn.
   * 
   * @param maxTurn Maximum number of turns
   */
  public void setMaxturn(int maxTurn);

}

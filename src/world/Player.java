package world;

import java.util.List;

/**
 * The player is anyone who wants to play the game. Its contains various
 * properties like name, maxItem , etc. A player is capable to moving to its
 * neighbouring room and pick item.
 * 
 * @author abhishekkumar
 *
 */
public interface Player {

  /**
   * Add the item to list list of items for the player.
   * 
   * @param item to be added in the item list for the player.
   * @return true if the item is addedd successfully , else false.
   */
  boolean addItemToPlayer(Item item);

  /**
   * It returns the name of the player.
   * 
   * @return the name of the player.
   */
  String getName();

  /**
   * It is responsible for moving the player to one of its neighbouring room.
   * 
   * @param nextRoom the room where the player wants to move to.
   * @return true of moved to the room successfully, else false.
   */
  boolean move(String nextRoom);

  /**
   * It returns the name of the room the player is currently in.
   * 
   * @return the name of the room the player is currently in.
   */
  String getRoomName();

  /**
   * It returns the maximum number of item that a player can carry.
   * 
   * @return the maximum number of item that a player can carry
   */
  int getMaxItem();

  /**
   * It returns the list of items the player is carrying.
   * 
   * @return the list of items the player is carrying.
   */
  List<Item> getItems();

  /**
   * It gives us the info if the current player is a Human Player or a computer
   * controlled player.
   * 
   * @return true is is is computer controlled player and vice versa.
   */
  boolean getIsBot();
  
  /**
   * 
   * It removes the item from the player. An item can be removed only when the
   * player uses the item.
   * 
   * @param item to be removed from the room.
   * @return true or false if the item is picked successfully.
   */
  public boolean removeItemFromPlayer(Item item);
}

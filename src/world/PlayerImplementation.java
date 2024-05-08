package world;

import java.util.ArrayList;
import java.util.List;

/**
 * The player is anyone who wants to play the game. Its contains various
 * properties like name, maxItem , etc. A player is capable to moving to its
 * neighbouring room and pick item.
 * 
 * @author abhishekkumar
 *
 */
public class PlayerImplementation implements Player {

  private final String playerName;
  private String roomName;
  private final int maxItem;
  private List<Item> itemList;
  private final boolean isBot;

  /**
   * 
   * Initialises the player object with the given Player Name, Room Name, Maximum
   * item player can carry, and if the player is human or not.
   * 
   * @param playerName the name of the player.
   * @param roomName   the first room of the player.
   * @param maxItem    maximum item a player can carry.
   * @param isBot      and if the player is computer or human.
   */
  public PlayerImplementation(String playerName, String roomName, int maxItem, boolean isBot) {

    if (playerName == null || roomName == null || "".equals(playerName) || "".equals(roomName)
        || maxItem < 0) {
      throw new IllegalArgumentException("Invalid Input values for player.");
    }
    this.playerName = playerName;
    this.roomName = roomName;
    this.maxItem = maxItem;
    this.itemList = new ArrayList<Item>();
    this.isBot = isBot;

  }

  @Override
  public String getName() {
    return this.playerName;
  }

  @Override
  public boolean addItemToPlayer(Item item) {
    if (item != null) {
      if (this.itemList.size() < this.maxItem) {
        this.itemList.add(item);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getIsBot() {
    return this.isBot;
  }

  @Override
  public boolean move(String nextRoom) {
    if (!(nextRoom == null || "".equals(nextRoom))) {
      this.roomName = nextRoom;
      return true;
    }
    return false;
  }

  @Override
  public String getRoomName() {
    return this.roomName;
  }

  @Override
  public int getMaxItem() {
    return this.maxItem;
  }

  @Override
  public List<Item> getItems() {
    List<Item> itemCopy = new ArrayList<Item>();
    for (Item r : this.itemList) {
      itemCopy.add(r);
    }

    return itemCopy;
  }

  @Override
  public String toString() {
    return String.format(playerName);
  }

  @Override
  public boolean removeItemFromPlayer(Item item) {
    if (item != null) {
      if (this.itemList.contains(item)) {
        this.itemList.remove(item);
        return true;
      }
      return false;
    } else {
      throw new IllegalArgumentException("Item cannot be null");
    }
  }

}

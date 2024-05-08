package world;

import java.util.List;

/**
 * It is a space in the board game which has its own coordinates. It is the part
 * of the world and may contains multiple items in it. Also multiple player can
 * be present in a room. When a player picks item from the room, that item is no
 * longer present in the room. Also the target can move in and move out of the
 * room.
 */
public interface Room {

  /**
   * It add the item into the given room. An item can be added only while parsing
   * the input file.
   * 
   * @param item that has to be added into the room.
   * @return true if item is added successfully.
   */
  public boolean addItemToRoom(Item item);

  /**
   * 
   * It removes the item from the given room. An item can be removed only when a
   * player picks the item.
   * 
   * @param item to be removed from the room.
   * @return true or false if the item is picked successfully.
   */
  public boolean removeItemFromRoom(Item item);

  /**
   * Its add another room into the list of neighbours of the current room. The
   * room has to be the adjacent room to the current room.
   * 
   * @param room the room to be added in the list of neighbours.
   * @return the output string of the neighbour's name.
   */
  public String addNeighbour(Room room);

  /**
   * It adds the player to the current room and adds in the list of player.
   * 
   * @param player the player to be added in the room.
   * @return if the player is added in the room or not.
   */
  public boolean addPlayerToRoom(Player player);

  /**
   * It removes the player from the current room and removes from the list of
   * player.
   * 
   * @param player the player to be removed from the room.
   * @return if the player is removed in the room or not.
   */
  public boolean removePlayerFromRoom(Player player);

  /**
   * It returns the list of neighbours of the room.
   * 
   * @return list of neighbours.
   */
  public List<Room> getNeighbour();

  
  /**
   * It returns the 1st row coordinate.
   * 
   * @return the first row of the room.
   */
  public int getRow1();

  /**
   * It returns the 1st column coordinate.
   * 
   * @return the first columns of the room.
   */
  public int getColumn1();

  /**
   * It returns the last row coordinate.
   * 
   * @return the last row of the room.
   */
  public int getRow2();

  /**
   * It returns the last column coordinate.
   * 
   * @return the last columns of the room.
   */
  public int getColumn2();

  /**
   * It returns the name of the room.
   * 
   * @return the name of the room.
   */
  public String getRoomName();

  /**
   * It returns the list of items in the room.
   * 
   * @return the list of items in the room.
   */
  public List<Item> getItems();

  /**
   * It returns the list of players in the room.
   * 
   * @return the list of palyers in the room.
   */
  public List<Player> getPlayers();

  /**
   * It sets the presence of target data as true if target moves into the room and
   * sets false if the target moves out.
   * 
   * @param present sets true if target moves into the room and vice versa.
   */
  public void setTaregtPresence(boolean present);

  /**
   * It returns if target is present in the room.
   * 
   * @return true if target is present in the room, else false.
   */
  public boolean getTaregtPresence();

  /**
   * It takes all the details of the room, i.e players present, items present,
   * neighbours , target present and sends to the controller.
   * 
   * @return the details of the room.
   */
  public String displayInfo();
  
  /**
   * It sets the presence of pet data as true if pet moves into the room and
   * sets false if the pet moves out.
   * 
   * @param present sets true if pet moves into the room and vice versa.
   */
  public void setPetPresence(boolean present);

  /**
   * It returns if pet is present in the room or not.
   * 
   * @return true if pet is present in the room, else false.
   */
  public boolean getPetPresence();

}

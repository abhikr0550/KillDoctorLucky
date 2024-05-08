package world;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * It is a space in the board game which has its own coordinates. It is the part
 * of the world and may contains multiple items in it. Also multiple player can
 * be present in a room. When a player picks item from the room, that item is no
 * longer present in the room. Also the target can move in and move out of the
 * room.
 */
public class RoomImplementation implements Room {

  private final int row1;
  private final int column1;
  private final int row2;
  private final int column2;
  private final String roomName;
  private boolean targetPresent;
  private boolean petPresent;
  private List<Item> itemList;
  private List<Room> neighbours;
  private List<Player> playersList;

  /**
   * Initialises the room object with the given first row, last row, first column
   * and last columns, room name and if target is present or not.
   * 
   * @param row1           : Top row.
   * @param column1        : Leftmost Column.
   * @param row2           : Bottom row.
   * @param column2        : Rightmost column.
   * @param roomName       : Room name.
   * @param drLuckyPresent : Presence of Dr. Lucky.
   * @throws IllegalArgumentException : exception for Illegal Values.
   */
  public RoomImplementation(int row1, int column1, int row2, int column2, String roomName,
      boolean drLuckyPresent) throws IllegalArgumentException {

    if (roomName == null || row1 < 0 || column1 < 0 || row2 < 0 || column2 < 0 || row2 < row1
        || column2 < column1) {
      throw new IllegalArgumentException();
    }
    this.row1 = row1;
    this.column1 = column1;
    this.row2 = row2;
    this.column2 = column2;
    this.roomName = roomName;
    this.targetPresent = drLuckyPresent;
    itemList = new ArrayList<Item>();
    neighbours = new ArrayList<Room>();
    playersList = new ArrayList<Player>();

  }

  @Override
  public boolean addItemToRoom(Item item) {
    if (item != null) {
      this.itemList.add(item);
      return true;
    }
    return false;
  }

  @Override
  public boolean removeItemFromRoom(Item item) {
    if (item != null) {
      this.itemList.remove(item);
      return true;
    }
    return false;
  }

  @Override
  public boolean addPlayerToRoom(Player player) {
    if (player != null) {
      this.playersList.add(player);
      return true;
    }
    return false;
  }

  @Override
  public boolean removePlayerFromRoom(Player player) {
    if (player != null) {
      this.playersList.remove(player);
      return true;
    }
    return false;
  }

  /**
   * Return the top row number.
   * 
   * @return the row1.
   */
  public int getRow1() {
    return row1;
  }

  /**
   * Returns the leftmost column of the room.
   * 
   * @return the column1.
   */
  public int getColumn1() {
    return column1;
  }

  /**
   * Returns the bottom most row of the room.
   * 
   * @return the row2.
   */
  public int getRow2() {
    return row2;
  }

  /**
   * 
   * Returns the rightmost column of the room.
   * 
   * @return the column2.
   */
  public int getColumn2() {
    return column2;
  }

  /**
   * Returns the name of the room.
   * 
   * @return the name of the room.
   */
  @Override
  public String getRoomName() {

    return this.roomName;
  }

  @Override
  public String addNeighbour(Room room) {
    if (room != null) {
      if (!this.neighbours.contains(room)) {
        this.neighbours.add(room);
      }

      return room.getRoomName();
    } else {
      throw new IllegalArgumentException("Room cannot be null.");
    }
  }

  @Override
  public List<Room> getNeighbour() {
    List<Room> nighbourCopy = new ArrayList<Room>();
    for (Room r : this.neighbours) {
      if (r.getPetPresence()) {
        continue;
      }
      nighbourCopy.add(r);
    }
    return nighbourCopy;
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
  public List<Player> getPlayers() {
    List<Player> itemCopy = new ArrayList<Player>();
    for (Player r : this.playersList) {
      itemCopy.add(r);
    }
    return itemCopy;
  }

  @Override
  public void setTaregtPresence(boolean present) {
    this.targetPresent = present;
  }

  @Override
  public boolean getTaregtPresence() {
    return this.targetPresent;

  }

  @Override
  public String displayInfo() {
    StringBuilder s = new StringBuilder();
    s.append("Room Name : " + this.getRoomName() + "\n");
    
    s.append("Target present in the room : " + this.getTaregtPresence() + "\n");
    List<Room> displayRoomList = new ArrayList<Room>();
    displayRoomList = this.getNeighbour();
    s.append("Neighbours : " + displayRoomList + "\n");
    List<Item> displayItemList = new ArrayList<Item>();
    displayItemList = this.getItems();
    s.append("Items in the room : " + displayItemList + "\n");
    List<Player> displayPlayerList = new ArrayList<Player>();
    displayPlayerList = this.getPlayers();
    s.append("Players in the room: " + displayPlayerList + "\n");
    return s.toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(column1, column2, roomName, row1, row2, targetPresent);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (!(obj instanceof RoomImplementation)) {
      return false;
    }

    RoomImplementation other = (RoomImplementation) obj;
    return column1 == other.column1 && column2 == other.column2
        && Objects.equals(roomName, other.roomName) && row1 == other.row1 && row2 == other.row2
        && targetPresent == other.targetPresent;
  }

  @Override
  public String toString() {
    return String.format(roomName);
  }

  @Override
  public void setPetPresence(boolean present) {
    this.petPresent = present;

  }

  @Override
  public boolean getPetPresence() {
    return this.petPresent;
  }

}

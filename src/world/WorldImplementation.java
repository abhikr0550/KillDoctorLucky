package world;

import driver.MyRandom;
import driver.MyRandomInterface;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import view.CreateGameBoard;

/**
 * World is the place where the board game is created. It is responsible to
 * store all the rooms in the world. It also does the checking of the
 * neighbouring room while adding the room. It also is responsible to move the
 * target from one space to another. The world takes the input from the facade
 * class and processed the input and returns the output accordingly. Player can
 * also relocate pet and attempt to kill the target.
 */
public class WorldImplementation implements World {

  private final String worldName;
  private final int maxRows;
  private final int maxColumns;
  private Target target;
  private int[][] worldArray;
  private List<Room> rooms;
  private List<String> roomNameList;
  private List<Player> playersList;
  private List<String> playerNameList;
  private List<Boolean> playerTypeList;
  private Pet pet;
  private int turn;
  private int maxTurn;
  private Map<String, String> playerPlotCoordinates;

  /**
   * Initialises the WorldImplementation object with given values and sets the
   * matrix with default value.
   * 
   * @param worldName  : world name.
   * @param maxRows    : total rows.
   * @param maxColumns : total columns.
   * @param target     : stores target.
   */
  public WorldImplementation(String worldName, int maxRows, int maxColumns, Target target) {

    if ("".equals(worldName) || worldName == null) {
      throw new IllegalArgumentException("Invalid World name. Name cannot be empty or null");
    }
    if (maxRows < 0) {
      throw new IllegalArgumentException("Invalid Maximum rows. It cannot be negative.");
    }
    if (maxColumns < 0) {
      throw new IllegalArgumentException("Invalid Maximum columns. It cannot be negative.");
    }

    if (target == null) {
      throw new IllegalArgumentException("Invalid Target. It cannot be null.");
    }

    this.worldName = worldName;
    this.maxRows = maxRows;
    this.maxColumns = maxColumns;
    this.target = target;
    rooms = new ArrayList<Room>();
    roomNameList = new ArrayList<String>();
    playersList = new ArrayList<Player>();
    playerNameList = new ArrayList<String>();
    playerTypeList = new ArrayList<>();
    this.pet = null;
    this.turn = 0;
    this.createWorld();
    this.maxTurn = 0;

    this.playerPlotCoordinates = new HashMap<String, String>();

  }

  /**
   * Initialises the WorldImplementation object with given values and sets the
   * matrix with default value.
   * 
   * @param worldName  : world name.
   * @param maxRows    : total rows.
   * @param maxColumns : total columns.
   * @param target     : stores target.
   * @param pet        : stores pet.
   */
  public WorldImplementation(String worldName, int maxRows, int maxColumns, Target target,
      Pet pet) {

    if ("".equals(worldName) || worldName == null || pet == null) {
      throw new IllegalArgumentException("Invalid name. Name cannot be empty or null");
    }
    if (maxRows < 0) {
      throw new IllegalArgumentException("Invalid Maximum rows. It cannot be negative.");
    }
    if (maxColumns < 0) {
      throw new IllegalArgumentException("Invalid Maximum columns. It cannot be negative.");
    }

    if (target == null) {
      throw new IllegalArgumentException("Invalid Target. It cannot be null.");
    }

    this.worldName = worldName;
    this.maxRows = maxRows;
    this.maxColumns = maxColumns;
    this.target = target;
    rooms = new ArrayList<Room>();
    roomNameList = new ArrayList<String>();
    playersList = new ArrayList<Player>();
    playerNameList = new ArrayList<String>();
    playerTypeList = new ArrayList<>();
    this.pet = pet;
    this.turn = 0;

    this.createWorld();
  }

  @Override
  public void setMaxturn(int maxTurn) {
    this.maxTurn = maxTurn;
  }

  private void createWorld() {
    // create the matrix for the entire board.
    worldArray = new int[this.getMaxRows()][this.getMaxColumns()];
    for (int[] row : this.worldArray) {
      Arrays.fill(row, -1);
    }
  }

  /**
   * Returns the world name.
   */
  @Override
  public String getworldName() {
    return this.worldName;
  }

  /**
   * To add room to the world.
   */
  @Override
  public boolean addRoom(Room room) {

    if (room == null) {
      throw new IllegalStateException("Room cannot be null");
    }
    for (int i = room.getRow1(); i <= room.getRow2(); i++) {
      for (int j = room.getColumn1(); j <= room.getColumn2(); j++) {

        if ((i == room.getRow1() && (i > 0))) {
          if ((this.worldArray[i - 1][j] != -1)
              && (this.worldArray[i - 1][j] != this.rooms.size())) {
            room.addNeighbour(this.getRooms().get(this.worldArray[i - 1][j]));
            this.getRooms().get(this.worldArray[i - 1][j]).addNeighbour(room);
          }
        }
        if ((j == room.getColumn1()) && (j > 0) && (this.worldArray[i][j - 1] != -1)) {
          room.addNeighbour(this.getRooms().get(this.worldArray[i][j - 1]));
          this.getRooms().get(this.worldArray[i][j - 1]).addNeighbour(room);
        }
        if ((i == room.getRow2()) && (i < this.maxRows - 1) && (this.worldArray[i + 1][j] != -1)) {
          room.addNeighbour(this.getRooms().get(this.worldArray[i + 1][j]));
          this.getRooms().get(this.worldArray[i + 1][j]).addNeighbour(room);
        }
        if ((j == room.getColumn2()) && (j < this.maxColumns - 1)
            && (this.worldArray[i][j + 1] != -1)) {

          room.addNeighbour(this.getRooms().get(this.worldArray[i][j + 1]));
          this.getRooms().get(this.worldArray[i][j + 1]).addNeighbour(room);
        }

        if (this.worldArray[i][j] == -1) {
          this.worldArray[i][j] = this.rooms.size();
        } else {
          throw new IllegalStateException("Room already exist");
        }
      }
    }

    this.rooms.add(room);
    this.roomNameList.add(room.getRoomName());
    this.pet.addRoom(room.getRoomName());
    return true;
  }

  @Override
  public void addPet(Pet pet) {
    if (pet == null) {
      throw new IllegalStateException("Room cannot be null");
    }
    this.pet = pet;
  }

  /**
   * Returns the maximum number of row.
   * 
   * @return : return max row.
   */
  private int getMaxRows() {
    return this.maxRows;
  }

  private int getMaxColumns() {
    return this.maxColumns;
  }

  @Override
  public List<Room> getRooms() {
    List<Room> roomCopy = new ArrayList<Room>();
    for (Room r : this.rooms) {
      roomCopy.add(r);
    }
    return roomCopy;
  }

  @Override
  public List<String> getRoomNames() {
    return this.roomNameList;
  }

  private String moveTarget() {
    int currentTargetPos = this.target.getLocation();
    this.getRooms().get(currentTargetPos).setTaregtPresence(false);

    if (this.target.getLocation() == rooms.size() - 1) {
      currentTargetPos = this.target.move(true);
      this.getRooms().get(currentTargetPos).setTaregtPresence(true);

    } else {
      currentTargetPos = this.target.move(false);
      this.getRooms().get(currentTargetPos).setTaregtPresence(true);

    }

    return rooms.get(currentTargetPos).getRoomName();

  }

  /**
   * Display all details of the world.
   */
  public void displayInfo() {
    List<Room> roomList = new ArrayList<Room>();
    StringBuilder str = new StringBuilder();

    roomList = this.getRooms();
    str.append("Name of the world is : " + this.getworldName());

    str.append("Number of Rooms in " + this.getworldName() + "is :" + this.getRooms().size());

    str.append("List of Rooms in the world are :-");
    str.append("-------------------------------------------");
    str.append(roomList);

    str.append("Displaying all Neighbours of each room :-");
    str.append("-------------------------------------------");

    for (Room room : roomList) {
      str.append(room + " : " + room.getNeighbour());
    }

    str.append("Displaying all Items of each room :- ");
    str.append("-------------------------------------------");
    for (Room room : roomList) {
      str.append(room + " : " + room.getItems());
    }

  }

  /**
   * Returns Hash code of the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(maxColumns, maxRows, worldName);
  }

  /**
   * Checks for equality of the object.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (!(obj instanceof WorldImplementation)) {
      return false;
    }
    WorldImplementation other = (WorldImplementation) obj;
    return maxColumns == other.maxColumns && maxRows == other.maxRows
        && Objects.equals(worldName, other.worldName);
  }

  @Override
  public String toString() {
    return String
        .format("WorldName=" + worldName + " , maxRows=" + maxRows + ", maxColumns=" + maxColumns);

  }

  @Override
  public String addPlayerToGame(Player player) {

    StringBuilder str = new StringBuilder();
    if (player != null) {
      if (!this.getPlayerNames().contains(player.getName())) {
        if (this.getRoomNames().contains(player.getRoomName())) {
          this.getRooms().get(this.getRoomNames().indexOf(player.getRoomName()))
              .addPlayerToRoom(player);

          playersList.add(player);
          if (playerNameList.size() > 0) {
            turn = turn % playerNameList.size();
          }
          playerNameList.add(player.getName());
          playerTypeList.add(player.getIsBot());
        } else {
          throw new IllegalArgumentException("Invalid Room Input");
        }
      } else {
        throw new IllegalArgumentException("Player Name already present");
      }
    } else {
      throw new IllegalArgumentException("Player cannot be null");
    }

    return str.append(player.getName() + " Successfully Added." + "\n").toString();
  }

  @Override
  public String lookUp() {
    if (turn < 0) {
      throw new IllegalArgumentException("Invalid Turn");
    }
    if (this.getPlayers().size() == 0) {
      throw new IllegalArgumentException("Add player to the game first");
    }
    turn = turn % this.getPlayers().size();
    Player player = this.getPlayers().get(turn);
    StringBuilder str = new StringBuilder();
    String currentRoomOfPlayer = player.getRoomName();
    str.append(player.getName() + " is present in " + currentRoomOfPlayer + "\n");
    str.append(
        this.getRooms().get(this.getRoomNames().indexOf(currentRoomOfPlayer)).displayInfo() + "\n");
    Room room = this.getRooms().get(this.getRoomNames().indexOf(currentRoomOfPlayer));
    str.append("Neighbours are:" + "\n");
    int i = 0;
    for (Room r : room.getNeighbour()) {
      if (r.getRoomName() == pet.getRoomName()) {
        continue;
      }
      str.append(i + 1 + "." + "\n");
      str.append(
          this.getRooms().get(this.getRoomNames().indexOf(r.getRoomName())).displayInfo() + "\n");
      i++;

    }
    // str.append("Pet is in :" + pet.getRoomName());

    this.moveTarget();
    MyRandomInterface randObj = new MyRandom();
    this.movePet("dfs", randObj);
    this.turn++;
    this.maxTurn--;
    return str.toString();
  }

  @Override
  public String checkIfPlayerPloted(int row, int col) {
    String playerCoordinates = String.format("%d_%d", row, col);
    return playerPlotCoordinates.get(playerCoordinates);
  }

  @Override
  public String getPlayerInformation(String playerName) {
    if (playerName == null || playerName.isBlank()) {
      throw new IllegalArgumentException("Invalid player name");
    }
    StringBuilder playerInformation = new StringBuilder();
    for (Player player : playersList) {
      String storedPlayerName = player.getName();
      if (storedPlayerName.equals(playerName)) {
        playerInformation.append(String.format("Player name: %s", storedPlayerName));
        List<Item> itemsOnPlayer = player.getItems();
        if (itemsOnPlayer.isEmpty()) {
          playerInformation.append("\nNot carrying any items");
        } else {
          playerInformation.append("\nList of items:-\n");
        }
        int i = 1;
        for (Item item : itemsOnPlayer) {
          playerInformation.append(String.format("%d. ", i++));
          playerInformation.append(item.toString());
          playerInformation.append("\n");
        }
      }
    }
    return playerInformation.toString();
  }

  @Override
  public String displayPlayerDetails() {

    if (turn < 0) {
      throw new IllegalArgumentException("Invalid Turn");
    }
    if (this.getPlayers().size() == 0) {
      throw new IllegalArgumentException("Add player to the game first");
    }
    StringBuilder str = new StringBuilder();
    turn = turn % this.getPlayers().size();
    Player player = this.getPlayers().get(turn);
    String currentRoomOfPlayer = player.getRoomName();

    str.append(this.getSpaceDetails(currentRoomOfPlayer));
    str.append(String.format("Target is present in %s\n", this.getTargetLocation()));
    if (this.pet.getRoomName().equals(currentRoomOfPlayer)) {
      str.append(String.format("%s present in the room\n\n", pet.getPetName()));
    }

    return str.toString();
  }

  private List<Player> getPlayers() {
    return this.playersList;
  }

  private List<String> getPlayerNames() {
    return this.playerNameList;
  }

  @Override
  public String getSpaceDetails(String roomName) {

    if (roomName == null) {
      throw new IllegalArgumentException("Invalid room name");
    }
    StringBuilder str = new StringBuilder();

    if (this.getRoomNames().contains(roomName)) {
      Room room = this.getRooms().get(this.getRoomNames().indexOf(roomName));
      str.append(room.displayInfo());
    } else {
      throw new IllegalArgumentException("Room not present" + "\n");
    }
    return str.toString();

  }

  @Override
  public String movePlayer(String nextSpace, MyRandomInterface randObj) {

    if (turn < 0) {
      throw new IllegalArgumentException("Invalid Turn");
    }
    if (nextSpace == null || randObj == null) {
      throw new IllegalArgumentException("Invalid room name");
    }
    if (this.getPlayers().size() == 0) {
      throw new IllegalArgumentException("Add player to the game first");
    }
    StringBuilder str = new StringBuilder();

    turn = turn % this.getPlayers().size();
    Player player = this.getPlayers().get(turn);
    String currentRoomOfPlayer = player.getRoomName();
    Room room = this.getRooms().get(this.getRoomNames().indexOf(currentRoomOfPlayer));
    boolean movement = false;
    if (player.getIsBot()) {
      if (room.getNeighbour().size() > 0) {
        int loc = randObj.getRandomValue(room.getNeighbour().size());
        nextSpace = room.getNeighbour().get(loc).getRoomName();
        movement = true;
      } else {
        throw new IllegalArgumentException("No neighbour present for the room");
      }
    } else {
      for (Room r : room.getNeighbour()) {
        if (nextSpace.equals(r.getRoomName())) {
          movement = true;
          break;
        }
      }
    }

    if (movement) {
      room.removePlayerFromRoom(player);

      player.move(nextSpace);
      room = this.getRooms().get(this.getRoomNames().indexOf(nextSpace));
      room.addPlayerToRoom(player);
      str.append(player.getName() + " moved to " + room.getRoomName() + " Successfully.");
      this.moveTarget();
      this.movePet("dfs", randObj);
      this.turn++;
      this.maxTurn--;
    } else {
      throw new IllegalArgumentException("Wrong Input for neighbour");
    }
    return str.toString();
  }

  @Override
  public String pickUpItem(String itemName, MyRandomInterface randObj) {

    if (turn < 0) {
      throw new IllegalArgumentException("Invalid Turn");
    }
    if (itemName == null || randObj == null) {
      throw new IllegalArgumentException("Item Name cannot be null");
    }
    if (this.getPlayers().size() == 0) {
      throw new IllegalArgumentException("Add player to the game first");
    }
    StringBuilder str = new StringBuilder();

    turn = turn % this.getPlayers().size();
    Player player = this.getPlayers().get(turn);
    String currentRoomOfPlayer = player.getRoomName();
    Room room = this.getRooms().get(this.getRoomNames().indexOf(currentRoomOfPlayer));
    boolean pickUp = false;
    Item itemToPick = null;

    if (player.getIsBot()) {
      if (room.getItems().size() > 0) {
        int loc = randObj.getRandomValue(room.getItems().size());
        itemName = room.getItems().get(loc).getName();
        itemToPick = room.getItems().get(loc);
        pickUp = true;
      } else {
        throw new IllegalArgumentException("No item present in the room.");
      }
    } else {
      for (Item item : room.getItems()) {
        if (item.getName().equals(itemName)) {
          pickUp = true;
          itemToPick = item;
          break;
        }
      }
    }

    if (pickUp && itemToPick != null) {
      if (!(player.getMaxItem() > player.getItems().size())) {
        throw new IllegalArgumentException("Player has reached the maximum item.");
      }

      player.addItemToPlayer(itemToPick);
      room.removeItemFromRoom(itemToPick);
      str.append(player.getName() + " picked up " + itemName + " Successfully.");
      this.moveTarget();
      this.movePet("dfs", randObj);
      this.turn++;
      this.maxTurn--;

    } else {
      throw new IllegalArgumentException("Wrong Input for item" + "\n");
    }
    return str.toString();

  }

  /**
   * Get current player object.
   * 
   * @return current player object
   */
  private Player getCurrentPlayer() {
    turn = turn % this.getPlayers().size();
    return this.getPlayers().get(turn);
  }

  @Override
  public String createGraph(Graphics g) {

    StringBuilder str = new StringBuilder();
    CreateGameBoard boardObj = new CreateGameBoard(g);
    int limitPlayers = 0;
    for (Room r : this.getRooms()) {
      int x1 = r.getRow1();
      int x2 = r.getRow2();
      int y1 = r.getColumn1();
      int y2 = r.getColumn2();

      String rmName = r.getRoomName();

      boardObj.plotTheWorld(x1, x2, y1, y2, rmName);

      if (limitPlayers < 9) {
        List<Player> players = r.getPlayers();
        int playerCount = players.size();
        if (playerCount != 0) {
          int divisionFactor = playerCount;
          int roomPlayerPlotCount = 0;
          if (playerCount > (x2 - x1)) {
            divisionFactor = (x2 - x1);
          }
          double playerX1 = x1;
          double playerX2 = x1 + ((x2 - x1) / divisionFactor);
          double y = y1 + ((y2 - y1) / 2);
          double xaxisDelta = playerX2 - playerX1;
          double x = playerX1 + (xaxisDelta / 2);
          for (Player player : players) {
            if (playerCount > (x2 - x1)) {
              divisionFactor = (x2 - x1);
            }
            String plotCoordinates = String.format("%d_%d", (int) Math.floor(y),
                (int) Math.ceil(x));
            playerPlotCoordinates.put(plotCoordinates, player.getName());
            if (player.getName().equals(getCurrentPlayer().getName())) {
              boardObj.plotCurrentPlayer(x, y);
            } else {
              boardObj.plotThePlayers(x, y);
            }
            playerX1 = playerX2;
            playerX2 += xaxisDelta;
            x = playerX1 + ((playerX2 - playerX1) / 2);
            limitPlayers++;
            roomPlayerPlotCount++;
            if (limitPlayers > 9) {
              break;
            }
            if (roomPlayerPlotCount == (x2 - x1)) {
              roomPlayerPlotCount = 0;
              break;
            }
          }
        }
      }
      Room targetRoom = rooms.get(target.getLocation());
      boardObj.plotTheTarget(targetRoom.getRow1(), targetRoom.getColumn1());

      // boardObj.saveImage();

    }
    str.append("Graph Plotted");
    return str.toString();
  }

  private String getTargetLocation() {
    if (this.target.getLocation() < this.getRoomNames().size()) {
      return this.getRoomNames().get(this.target.getLocation());
    }
    return "Something is wrong with target";
  }

  @Override
  public String movePet(String roomName, MyRandomInterface randObj) {

    if (roomName == null) {
      throw new IllegalArgumentException("Room Name cannot be null");
    }
    if (randObj == null) {
      throw new IllegalArgumentException("randObj cannot be null");
    }
    StringBuilder str = new StringBuilder();

    if ("dfs".equals(roomName)) {
      List<Room> neighbourList = new ArrayList<>();
      neighbourList = this.rooms.get(roomNameList.indexOf(pet.getRoomName())).getNeighbour();
      List<String> neighbourNameList = new ArrayList<>();

      for (Room r : neighbourList) {
        neighbourNameList.add(r.getRoomName());
      }
      Room petCurRoom = this.rooms.get(roomNameList.indexOf(pet.getRoomName()));
      petCurRoom.setPetPresence(false);
      str.append(pet.movePetDfs(neighbourNameList));
      petCurRoom = this.rooms.get(roomNameList.indexOf(pet.getRoomName()));
      petCurRoom.setPetPresence(true);
      return str.toString();
    }
    if (this.getRoomNames().contains(roomName)) {

      this.getRooms().get(this.getRoomNames().indexOf(pet.getRoomName())).setPetPresence(false);
      this.getRooms().get(this.getRoomNames().indexOf(roomName)).setPetPresence(true);
      str.append(this.pet.setRoom(roomName));
      this.pet.nullifyDfs();
      movePet("dfs", randObj);
      this.moveTarget();
      this.turn++;
      this.maxTurn--;
      return str.toString();
    } else if ("comp".equalsIgnoreCase(roomName)) {
      if (rooms.size() > 0) {
        int loc = randObj.getRandomValue(rooms.size());
        this.getRooms().get(this.getRoomNames().indexOf(pet.getRoomName())).setPetPresence(false);
        // this.getRooms().get(this.getRoomNames().indexOf(roomName)).setPetPresence(true);
        this.getRooms().get(loc).setPetPresence(true);

        str.append(pet.setRoom(rooms.get(loc).getRoomName()));
        this.pet.nullifyDfs();
        movePet("dfs", randObj);
        // Change at last moment. Check the execution.
        this.moveTarget();
        this.turn++;
        this.maxTurn--;
        return str.toString();

      }
    }
    return "Something is wrong with pet";
  }

  @Override
  public String killTarget(String itemName) {

    if (itemName == null) {
      throw new IllegalArgumentException("Item Name cannot be null");
    }
    if (turn < 0) {
      throw new IllegalArgumentException("Invalid Turn");
    }
    if (this.getPlayers().size() == 0) {
      throw new IllegalArgumentException("Add player to the game first");
    }
    StringBuilder str = new StringBuilder();

    turn = turn % this.getPlayers().size();
    Player player = this.getPlayers().get(turn);

    if (!this.rooms.get(target.getLocation()).getRoomName()
        .equalsIgnoreCase(player.getRoomName())) {
      throw new IllegalArgumentException("Player and Target are not in the same room");
    }

    boolean hit = false;
    int health = 0;
    int hitVal = 0;
    Item itemToUse = null;

    if (player.getIsBot()) {
      for (Item item : player.getItems()) {
        if (item.getValue() > hitVal) {
          hitVal = item.getValue();
          itemToUse = item;
        }
      }
      if (hitVal == 0) {
        hitVal++;
      }
      hit = true;

    } else {
      for (Item item : player.getItems()) {
        if (item.getName().equals(itemName)) {
          hit = true;
          itemToUse = item;
          hitVal = item.getValue();
          break;
        }
      }
      if (!hit && "Poke".equalsIgnoreCase(itemName)) {
        hit = true;
        hitVal = 1;
      } else if (!hit) {
        throw new IllegalArgumentException("Invalid Item chosen");
      }
    }

    if (hit && hitVal > 0) {
      boolean seen = false;
      Room room = this.getRooms().get(this.getRoomNames().indexOf(player.getRoomName()));
      if (room.getPlayers().size() > 1) {
        seen = true;
      } else {
        if (pet.getRoomName().equals(player.getRoomName())) {
          seen = false;
        } else {
          for (Room r : room.getNeighbour()) {

            if (r.getPlayers().size() > 0) {
              seen = true;
              break;
            }

          }
        }
      }
      if (seen) {
        str.append(String.format("Cannot attempt the Attack as someone is watching you!"));

      } else {
        health = target.attack(hitVal);
        if (health <= 0) {
          str.append(String.format("Game Over!! %s wins the game.", player.getName()));
        } else {
          str.append(String.format("New health of the target is %d", health));
        }
      }
      if (itemToUse != null) {
        player.removeItemFromPlayer(itemToUse);
      }
      this.moveTarget();
      MyRandomInterface randObj = new MyRandom();
      this.movePet("dfs", randObj);

      this.turn++;
      this.maxTurn--;
      return str.toString();
    }
    return null;
  }

  @Override
  public boolean computerPlayer() {
    if (this.playerTypeList.size() > 0) {
      return this.playerTypeList.get(turn % (playerTypeList.size()));
    }
    return false;
  }

  @Override
  public boolean isPlayerEmpty() {
    if (this.playerTypeList.size() > 0) {
      return false;
    }
    return true;

  }

  @Override
  public boolean playerTargetTogether() {

    turn = turn % this.getPlayers().size();
    Player player = this.getPlayers().get(turn);

    if (this.rooms.get(target.getLocation()).getRoomName().equalsIgnoreCase(player.getRoomName())) {
      return true;
    }
    return false;
  }

  @Override
  public boolean gameOver() {
    if (target.getHealth() <= 0 || maxTurn <= 0) {
      return true;
    }

    return false;
  }

  // @Override
  // public int getTurnsPlayed() {
  //
  // return this.turn;
  //
  // }

  @Override
  public int getTargetHealth() {

    return this.target.getHealth();

  }

  @Override
  public String getTargetName() {

    return this.target.getName();

  }

  @Override
  public String[] getItemNames() {

    turn = turn % this.getPlayers().size();
    Player player = this.getPlayers().get(turn);
    String currentRoomOfPlayer = player.getRoomName();
    Room room = this.getRooms().get(this.getRoomNames().indexOf(currentRoomOfPlayer));
    String[] itemNames = new String[room.getItems().size()];

    for (int i = 0; i < room.getItems().size(); i++) {

      itemNames[i] = room.getItems().get(i).getName();
    }

    return itemNames;

  }

  @Override
  public String[] getPlayerItemNames() {

    turn = turn % this.getPlayers().size();
    Player player = this.getPlayers().get(turn);

    String[] itemNames = new String[player.getItems().size()];

    for (int i = 0; i < player.getItems().size(); i++) {

      itemNames[i] = player.getItems().get(i).getName();
    }

    return itemNames;

  }

  @Override
  public int[][] getWorldMatrix() {
    return this.worldArray;
  }

  @Override
  public String getWinner() {
    int winTurn = turn % this.getPlayers().size();
    if (winTurn == 0) {
      winTurn = this.getPlayers().size() - 1;
    } else {
      winTurn--;
    }
    Player player = this.getPlayers().get(winTurn);
    return player.getName();
  }

  @Override
  public String getCurrentPlayerInformation() {
    turn = turn % this.getPlayers().size();
    Player currentPlayer = this.getPlayers().get(turn);
    String currentRoomOfPlayer = currentPlayer.getRoomName();
    StringBuilder currentPlayerInformation = new StringBuilder();
    currentPlayerInformation.append(String.format("Current player: %s, Player Location: %s",
        currentPlayer.getName(), currentRoomOfPlayer));
    return currentPlayerInformation.toString();
  }

}

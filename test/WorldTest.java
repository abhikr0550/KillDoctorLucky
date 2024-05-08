import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import driver.MyRandom;
import driver.MyRandomInterface;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import world.Item;
import world.ItemImplementation;
import world.Pet;
import world.PetImplementation;
import world.Player;
import world.PlayerImplementation;
import world.Room;
import world.RoomImplementation;
import world.Target;
import world.World;
import world.WorldImplementation;

/**
 * J Unit test Class to test the World board game.
 *
 */
public class WorldTest {

  private World worldObj;
  private Target targetObj;
  private Room roomObj;
  private Item itemObj;
  private Player player;
  private MyRandomInterface ranObj;
  private Pet petObj;
  private Player p1;

  /**
   * Testing the implemented methods using unified object.
   * 
   * @throws FileNotFoundException : throws when file is null.
   */
  @Before
  public void setUp() throws FileNotFoundException {
    worldObj = null;
    targetObj = new Target("Dr.Lucky", 3);
    player = null;
    ranObj = new MyRandom();
    petObj = null;
    worldObj = new WorldImplementation("Kill Dr. Lucky", 50, 50, targetObj);
    roomObj = new RoomImplementation(22, 19, 23, 26, "Armory", false);
    petObj = new PetImplementation("Armory", "Daisy");
    worldObj.addPet(petObj);
    roomObj.setTaregtPresence(true);
    roomObj.setPetPresence(true);

    Room roomObj1 = new RoomImplementation(16, 21, 21, 28, "Billiard Room", false);

    itemObj = new ItemImplementation("Revolver", 3);
    Item itemObj1 = new ItemImplementation("Billiard Cue", 2);
    Item itemObj2 = new ItemImplementation("Knife", 4);

    roomObj.addItemToRoom(itemObj);
    roomObj1.addItemToRoom(itemObj1);
    roomObj1.addItemToRoom(itemObj2);
    Room roomObj2 = new RoomImplementation(12, 11, 21, 20, "Dining Hall", false);
    Room roomObj3 = new RoomImplementation(22, 13, 25, 18, "Drawing Room", false);
    worldObj.addRoom(roomObj);
    worldObj.addRoom(roomObj1);
    worldObj.addRoom(roomObj2);
    worldObj.addRoom(roomObj3);
    p1 = new PlayerImplementation("Abhishek", "Armory", 3, false);
    worldObj.addPlayerToGame(p1);
    Player p2 = new PlayerImplementation("Computer1", "Billiard Room", 3, false);
    worldObj.addPlayerToGame(p2);

  }

  // Testing Target Class.

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTargetName() {
    targetObj = new Target("", 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTargetHealth1() {
    targetObj = new Target("Dr.Lucky", 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTargetHealth2() {
    targetObj = new Target("Dr.Lucky", -34);
  }

  @Test
  public void testValidTarget() {
    targetObj = new Target("Dr.Lucky", 57);
  }

  @Test
  public void testGetLocation() {

    targetObj = new Target("Dr.Lucky", 57);

    assertEquals(0, targetObj.getLocation());
  }

  // @Test
  // public void testTargetMove() {
  //
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
  // Room roomObj2 = new RoomImplementation(8, 11, 11, 20, "Kitchen", false);
  //
  // worldObj.addRoom(roomObj);
  // worldObj.addRoom(roomObj1);
  // worldObj.addRoom(roomObj2);
  //
  // targetObj.move(false);
  // targetObj.move(false);
  // assertEquals(2, targetObj.getLocation());
  //
  // targetObj.move(true);
  // assertEquals(0, targetObj.getLocation());
  //
  // }

  @Test
  public void testTargetToString() {
    targetObj = new Target("Dr.Lucky", 57);
    assertEquals("Target [targetName=Dr.Lucky, health=57]", targetObj.toString());
  }

  /**
   * Testing Item.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidItemName() {
    itemObj = new ItemImplementation("", 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidItemValue1() {
    itemObj = new ItemImplementation("Dagger", 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidItemValue2() {
    itemObj = new ItemImplementation("Gun", -4);
  }

  @Test
  public void testValidItem() {
    itemObj = new ItemImplementation("Knife", 10);
  }

  @Test
  public void testItemName() {
    itemObj = new ItemImplementation("Knife", 10);
    assertEquals("Knife", itemObj.getName());
  }

  @Test
  public void testItemValue() {
    itemObj = new ItemImplementation("Knife", 10);
    assertEquals(10, itemObj.getValue());
  }

  @Test
  public void testItemToString() {
    itemObj = new ItemImplementation("Knife", 10);
    assertEquals("(ItemName=Knife, value=10)", itemObj.toString());
  }

  @Test
  public void testItemEquals() {

    itemObj = new ItemImplementation("Knife", 10);
    Item itemObj3 = new ItemImplementation("Knife", 20);
    Item itemObj4 = new ItemImplementation("Knife", 2);
    Item itemObj5 = new ItemImplementation("Hammer", 10);

    assertFalse(itemObj4.equals(itemObj3));
    assertFalse(itemObj5.equals(itemObj));
    assertTrue(itemObj.equals(itemObj));
    Item itemObj1 = new ItemImplementation("Hammer", 20);

    assertFalse(itemObj.equals(itemObj1));

    itemObj1 = itemObj;
    assertTrue(itemObj.equals(itemObj1));

    itemObj1 = null;
    assertFalse(itemObj.equals(itemObj1));

    Object itemObj2 = new Object();
    assertFalse(itemObj.equals(itemObj2));

    Item itemObj6 = new ItemImplementation("Knife", 20);
    assertTrue(itemObj6.equals(itemObj3));

  }

  @Test
  public void testItemHashCode() {

    itemObj = new ItemImplementation("Knife", 10);
    Item itemObj1 = new ItemImplementation("Knife", 10);
    assertEquals(itemObj.hashCode(), itemObj1.hashCode());

  }

  /**
   * Testing Room.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRoomX1() {
    roomObj = new RoomImplementation(-1, 0, 3, 4, "Kitchen", false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRoomY1() {
    roomObj = new RoomImplementation(1, -9, 3, 4, "Kitchen", false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRoomX2() {
    roomObj = new RoomImplementation(1, 0, -3, 4, "Kitchen", false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRoomY2() {
    roomObj = new RoomImplementation(1, 0, 3, -4, "Kitchen", false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRoomName() {
    roomObj = new RoomImplementation(-1, 0, 3, 4, "", false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRoomXs() {
    roomObj = new RoomImplementation(1, 0, 0, 4, "Kitchen", false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRoomYs() {
    roomObj = new RoomImplementation(1, 4, 6, 3, "Kitchen", false);
  }

  @Test
  public void testValid() {
    roomObj = new RoomImplementation(1, 4, 6, 8, "Kitchen", false);
  }

  @Test
  public void testAddItemToRoom() {

    roomObj = new RoomImplementation(1, 4, 6, 8, "Kitchen", false);
    itemObj = new ItemImplementation("Knife", 10);
    assertTrue(roomObj.addItemToRoom(itemObj));
    Item itemObj1 = null;
    assertFalse(roomObj.addItemToRoom(itemObj1));

  }

  @Test
  public void testAddPlayerToRoom() {

    roomObj = new RoomImplementation(1, 4, 6, 8, "Kitchen", false);
    player = new PlayerImplementation("Abhishek", "Armory", 3, false);
    assertTrue(roomObj.addPlayerToRoom(player));
    Player playerObj1 = null;
    assertFalse(roomObj.addPlayerToRoom(playerObj1));

  }

  @Test
  public void testRemovePlayerFromRoom() {

    roomObj = new RoomImplementation(1, 4, 6, 8, "Kitchen", false);
    player = new PlayerImplementation("Abhishek", "Armory", 3, false);
    assertTrue(roomObj.removePlayerFromRoom(player));

    Player playerObj1 = null;
    assertFalse(roomObj.removePlayerFromRoom(playerObj1));

  }

  @Test
  public void testRemoveItemFromRoom() {

    roomObj = new RoomImplementation(1, 4, 6, 8, "Kitchen", false);
    itemObj = new ItemImplementation("Knife", 10);
    assertTrue(roomObj.removeItemFromRoom(itemObj));
    itemObj = null;
    assertFalse(roomObj.removeItemFromRoom(itemObj));

  }

  @Test
  public void testDisplayDetails() {

    roomObj = new RoomImplementation(1, 4, 6, 8, "Kitchen", false);
    itemObj = new ItemImplementation("Knife", 10);
    player = new PlayerImplementation("Abhishek", "Armory", 3, false);
    roomObj.addPlayerToRoom(player);
    roomObj.addItemToRoom(itemObj);

  }

  /**
   * Test the getters of coordinates and room name.
   */
  @Test
  public void testRoomGetters() {

    roomObj = new RoomImplementation(1, 4, 6, 8, "Kitchen", false);

    assertEquals(1, roomObj.getRow1());
    assertEquals(4, roomObj.getColumn1());
    assertEquals(6, roomObj.getRow2());
    assertEquals(8, roomObj.getColumn2());

    assertEquals("Kitchen", roomObj.getRoomName());

  }

  @Test
  public void testRoomAddNeighbour() {

    roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
    Room roomObjNew = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
    roomObj.addNeighbour(roomObjNew);
    roomObjNew.addNeighbour(roomObj);
    assertEquals("Master Suite", roomObj.addNeighbour(roomObjNew));

  }

  @Test
  public void testGetPlayers() {

    roomObj = new RoomImplementation(1, 4, 6, 8, "Kitchen", false);
    itemObj = new ItemImplementation("Knife", 10);
    player = new PlayerImplementation("Abhishek", "Armory", 3, false);
    Player player1 = new PlayerImplementation("Abhinav", "Kitchen", 4, false);

    roomObj.addPlayerToRoom(player);
    roomObj.addPlayerToRoom(player1);

    roomObj.addItemToRoom(itemObj);

    List<String> mylist = new ArrayList<String>();
    mylist.add("Abhishek");
    mylist.add("Abhinav");

    int i = 0;
    for (Player p : roomObj.getPlayers()) {
      assertEquals(mylist.get(i), p.getName());
      i++;
    }

  }

  /**
   * Test the getters of coordinates and room name.
   */
  @Test
  public void testRoomGetNeighbours() {

    roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
    Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
    Room roomObj2 = new RoomImplementation(8, 11, 11, 20, "Kitchen", false);
    roomObj.addNeighbour(roomObj1);
    roomObj.addNeighbour(roomObj2);
    roomObj1.addNeighbour(roomObj);
    roomObj1.addNeighbour(roomObj2);
    roomObj2.addNeighbour(roomObj);
    roomObj2.addNeighbour(roomObj1);
    List<String> mylist = new ArrayList<String>();
    mylist.add("Master Suite");
    mylist.add("Kitchen");
    int i = 0;
    for (Room neighbour : roomObj.getNeighbour()) {
      assertEquals(mylist.get(i), neighbour.getRoomName());
      i++;
    }

  }

  @Test
  public void testRoomTargetPresent() {

    roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);

    assertFalse(roomObj.getTaregtPresence());
    roomObj.setTaregtPresence(true);
    assertTrue(roomObj.getTaregtPresence());

  }

  @Test
  public void testRoomgetItem() {

    roomObj = new RoomImplementation(1, 4, 6, 8, "Kitchen", false);
    itemObj = new ItemImplementation("Knife", 10);
    Item itemObj1 = new ItemImplementation("Poison", 20);

    roomObj.addItemToRoom(itemObj);
    roomObj.addItemToRoom(itemObj1);
    List<String> mylist = new ArrayList<String>();
    mylist.add("Knife");
    mylist.add("Poison");

    int i = 0;
    for (Item item : roomObj.getItems()) {
      assertEquals(mylist.get(i), item.getName());
      i++;
    }

  }

  @Test
  public void testRoomToString() {
    roomObj = new RoomImplementation(2, 9, 7, 14, "Kitchen", false);
    assertEquals("Kitchen", roomObj.toString());
  }

  @Test
  public void testRoomEquals() {

    roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
    Room roomObj2 = new RoomImplementation(8, 11, 11, 20, "Kitchen", false);
    Room roomObj3 = new RoomImplementation(8, 12, 11, 20, "Kitchen", false);

    assertFalse(roomObj.equals(roomObj2));
    assertTrue(roomObj.equals(roomObj));
    Room roomObj4 = new RoomImplementation(8, 11, 14, 20, "Kitchen", false);
    Room roomObj8 = new RoomImplementation(8, 11, 11, 20, "Hall", false);

    assertFalse(roomObj2.equals(roomObj3));
    assertFalse(roomObj2.equals(roomObj4));
    assertFalse(roomObj2.equals(roomObj8));
    Room roomObj6 = new RoomImplementation(8, 11, 11, 21, "Kitchen", false);
    Room roomObj7 = new RoomImplementation(8, 11, 11, 20, "Kitchen", true);
    assertFalse(roomObj2.equals(roomObj7));
    assertFalse(roomObj2.equals(roomObj6));
    assertTrue(roomObj2.equals(roomObj2));
    Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);

    roomObj1 = roomObj;
    assertTrue(roomObj.equals(roomObj1));

    roomObj1 = null;
    assertFalse(roomObj.equals(roomObj1));

    Object roomObj5 = new Object();
    assertFalse(roomObj.equals(roomObj5));

    Room roomObj9 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
    Room roomObj10 = new RoomImplementation(2, 15, 7, 22, "Master Suite", true);
    roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
    assertTrue(roomObj9.equals(roomObj1));

    assertFalse(roomObj10.equals(roomObj1));

  }

  @Test
  public void testRoomHashCode() {

    Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
    Room roomObj2 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);

    assertEquals(roomObj2.hashCode(), roomObj1.hashCode());

  }

  /**
   * Testing World.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidWorldName() {
    targetObj = new Target("Dr.Lucky", 57);
    worldObj = new WorldImplementation("", 50, 60, targetObj);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidWorldName1() {
    targetObj = new Target("Dr.Lucky", 57);
    worldObj = new WorldImplementation(null, 50, 60, targetObj);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMaxRows() {
    targetObj = new Target("Dr.Lucky", 57);
    worldObj = new WorldImplementation("Dr. Lucky mansion", -50, 60, targetObj);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMaxColumns() {
    targetObj = new Target("Dr.Lucky", 57);
    worldObj = new WorldImplementation("Dr. Lucky mansion", 50, -60, targetObj);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidWorldTarget() {
    targetObj = null;
    worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  }

  @Test
  public void testValidWorld() {
    targetObj = new Target("Dr.Lucky", 57);
    worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  }

  // @Test(expected = IllegalStateException.class)
  // public void testWorlInvalidAddRoom() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  //
  // targetObj = new Target("Dr.Lucky", 57);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // Room roomObj1 = new RoomImplementation(2, 14, 7, 22, "Master Suite", false);
  // worldObj.addRoom(roomObj);
  // worldObj.addRoom(roomObj1);
  //
  // }

  @Test
  public void testWorldGetWorldName() {
    targetObj = new Target("Dr.Lucky", 57);
    worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
    assertEquals("Dr. Lucky mansion", worldObj.getworldName());

  }

  // @Test
  // public void testWorlAddRoom() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // assertTrue(worldObj.addRoom(roomObj));
  // Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
  // Room roomObj2 = new RoomImplementation(8, 11, 11, 20, "Kitchen", false);
  //
  // assertTrue(worldObj.addRoom(roomObj1));
  // assertTrue(worldObj.addRoom(roomObj2));
  //
  // }

  // @Test
  // public void testWorlGetRooms() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
  // Room roomObj2 = new RoomImplementation(8, 11, 11, 20, "Kitchen", false);
  //
  // worldObj.addRoom(roomObj);
  // worldObj.addRoom(roomObj1);
  // worldObj.addRoom(roomObj2);
  //
  // List<String> mylist = new ArrayList<String>();
  // mylist.add("Lilac Room");
  // mylist.add("Master Suite");
  // mylist.add("Kitchen");
  // int i = 0;
  // for (Room room : worldObj.getRooms()) {
  // assertEquals(mylist.get(i), room.getRoomName());
  // i++;
  // }
  // }

  // @Test(expected = IllegalArgumentException.class)
  // public void testWorlGetSpaceDetails() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // worldObj.addRoom(roomObj);
  // worldObj.getSpaceDetails("Lilac Room");
  // worldObj.getSpaceDetails("Kitchen");
  //
  // }

  // @Test(expected = IllegalArgumentException.class)
  // public void testWorlGetSpaceDetailsInvalid() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // worldObj.addRoom(roomObj);
  // worldObj.getSpaceDetails(null);
  // }

  // @Test(expected = IllegalArgumentException.class)
  // public void testWorlInvalidLookUp1() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // worldObj.addRoom(roomObj);
  // worldObj.lookUp();
  // }

  // @Test(expected = IllegalArgumentException.class)
  // public void testWorlInvalidLookUp2() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // worldObj.addRoom(roomObj);
  // worldObj.lookUp();
  // }

  // @Test
  // public void testWorldLookUp() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // Player player1 = new PlayerImplementation("Abhinav", "Kitchen", 4, false);
  // worldObj.addRoom(roomObj);
  // worldObj.addRoom(roomObj1);
  // Room roomObj2 = new RoomImplementation(8, 11, 11, 20, "Kitchen", false);
  // worldObj.addRoom(roomObj2);
  // worldObj.addPlayerToGame(player);
  // worldObj.addPlayerToGame(player1);
  //
  // worldObj.lookUp();
  // }

  // @Test
  // public void testWorldDisplayInfo() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // Player player1 = new PlayerImplementation("Abhinav", "Kitchen", 4, false);
  // worldObj.addRoom(roomObj);
  // worldObj.addRoom(roomObj1);
  // Room roomObj2 = new RoomImplementation(8, 11, 11, 20, "Kitchen", false);
  // worldObj.addRoom(roomObj2);
  // worldObj.addPlayerToGame(player);
  // worldObj.addPlayerToGame(player1);
  //
  // worldObj.displayInfo();
  // }

  @Test(expected = IllegalArgumentException.class)
  public void testWorldAddPlayerToGame1() {
    targetObj = new Target("Dr.Lucky", 57);
    worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
    roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
    worldObj.addPlayerToGame(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWorldAddPlayerToGame3() {
    targetObj = new Target("Dr.Lucky", 57);
    worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
    roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
    player = null;
    worldObj.addPlayerToGame(player);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWorldAddPlayerToGame2() {
    targetObj = new Target("Dr.Lucky", 57);
    worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
    roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
    player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
    Player player1 = new PlayerImplementation("Abhishek", "Kitchen", 4, false);
    worldObj.addPlayerToGame(player);
    worldObj.addPlayerToGame(player1);
  }

  // @Test(expected = IllegalArgumentException.class)
  // public void testWorldAddPlayerToGame4() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // Player player1 = new PlayerImplementation("Abhishek", "Kitchen", 4, false);
  // worldObj.addRoom(roomObj);
  // worldObj.addRoom(roomObj1);
  // Room roomObj2 = new RoomImplementation(8, 11, 11, 20, "Kitchen", false);
  // worldObj.addRoom(roomObj2);
  // worldObj.addPlayerToGame(player);
  // worldObj.addPlayerToGame(player1);
  // }

  // @Test(expected = IllegalArgumentException.class)
  // public void testWorldInvalidPickItem1() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // itemObj = new ItemImplementation("Chair", 10);
  // roomObj.addItemToRoom(itemObj);
  // worldObj.addRoom(roomObj);
  // worldObj.addPlayerToGame(player);
  // worldObj.pickUpItem("Chair", ranObj);
  // }

  // @Test(expected = IllegalArgumentException.class)
  // public void testWorldInvalidPickItem2() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // itemObj = new ItemImplementation("Chair", 10);
  // roomObj.addItemToRoom(itemObj);
  // worldObj.addRoom(roomObj);
  // worldObj.addPlayerToGame(player);
  // worldObj.pickUpItem(null, ranObj);
  // }

  // @Test(expected = IllegalArgumentException.class)
  // public void testWorldInvalidPickItem3() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // itemObj = new ItemImplementation("Chair", 10);
  // roomObj.addItemToRoom(itemObj);
  // worldObj.addRoom(roomObj);
  // worldObj.pickUpItem("Chair", ranObj);
  //
  // }

  // @Test(expected = IllegalArgumentException.class)
  // public void testWorldInvalidPickItem4() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // itemObj = new ItemImplementation("Chair", 10);
  // roomObj.addItemToRoom(itemObj);
  // worldObj.addRoom(roomObj);
  // worldObj.addPlayerToGame(player);
  // worldObj.pickUpItem("Knife", ranObj);
  //
  // }

  // @Test(expected = IllegalArgumentException.class)
  // public void testWorldInvalidPickItem5() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // itemObj = new ItemImplementation("Chair", 10);
  // roomObj.addItemToRoom(itemObj);
  // worldObj.addRoom(roomObj);
  // worldObj.addPlayerToGame(player);
  // worldObj.pickUpItem("Chair1", ranObj);
  //
  // }

  // @Test(expected = IllegalArgumentException.class)
  // public void testWorldInvalidmovePlayer1() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // itemObj = new ItemImplementation("Chair", 10);
  // roomObj.addItemToRoom(itemObj);
  // worldObj.addRoom(roomObj);
  // worldObj.addPlayerToGame(player);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
  // Room roomObj2 = new RoomImplementation(8, 11, 11, 20, "Kitchen", false);
  // worldObj.addRoom(roomObj1);
  // worldObj.addRoom(roomObj2);
  //
  // worldObj.movePlayer("Kitchen", ranObj);
  // }
  //
  // @Test(expected = IllegalArgumentException.class)
  // public void testWorldInvalidmovePlayer2() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // itemObj = new ItemImplementation("Chair", 10);
  // roomObj.addItemToRoom(itemObj);
  // worldObj.addRoom(roomObj);
  // worldObj.addPlayerToGame(player);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
  // Room roomObj2 = new RoomImplementation(8, 11, 11, 20, "Kitchen", false);
  // worldObj.addRoom(roomObj1);
  // worldObj.addRoom(roomObj2);
  //
  // worldObj.movePlayer(null, ranObj);
  // }
  //
  // @Test(expected = IllegalArgumentException.class)
  // public void testWorldInvalidmovePlayer3() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // itemObj = new ItemImplementation("Chair", 10);
  // roomObj.addItemToRoom(itemObj);
  // worldObj.addRoom(roomObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
  // Room roomObj2 = new RoomImplementation(8, 11, 11, 20, "Kitchen", false);
  // worldObj.addRoom(roomObj1);
  // worldObj.addRoom(roomObj2);
  //
  // worldObj.movePlayer("Lilac Room", ranObj);
  // }
  //
  // @Test(expected = IllegalArgumentException.class)
  // public void testWorldInvalidmovePlayer4() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // itemObj = new ItemImplementation("Chair", 10);
  // roomObj.addItemToRoom(itemObj);
  // worldObj.addRoom(roomObj);
  // worldObj.addPlayerToGame(player);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
  // Room roomObj2 = new RoomImplementation(8, 11, 11, 20, "Kitchen", false);
  // worldObj.addRoom(roomObj1);
  // worldObj.addRoom(roomObj2);
  //
  // worldObj.movePlayer("Balcony", ranObj);
  // }

  // @Test
  // public void testWorldValidmovePlayer() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // itemObj = new ItemImplementation("Chair", 10);
  // roomObj.addItemToRoom(itemObj);
  // worldObj.addRoom(roomObj);
  // worldObj.addPlayerToGame(player);
  // Player player1 = new PlayerImplementation("Abhinav", "Lilac Room", 7, false);
  // worldObj.addPlayerToGame(player1);
  // assertEquals(
  // "Room Name : Lilac Room\n" + "Upper row : 2\n" + "Left column : 9\n" + "Lower
  // row : 7\n"
  // + "Right column : 14\n" + "Target present : false\n" + "Neighbours : []\n"
  // + "Items : [(ItemName=Chair, value=10)]\n" + "Players : [Abhishek,
  // Abhinav]\n" + "",
  // worldObj.getSpaceDetails("Lilac Room"));
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // Room roomObj1 = new RoomImplementation(2, 15, 7, 22, "Master Suite", false);
  // Room roomObj2 = new RoomImplementation(8, 11, 11, 20, "Kitchen", false);
  // worldObj.addRoom(roomObj1);
  // worldObj.addRoom(roomObj2);
  // assertEquals("Abhinav moved to Kitchen Successfully.",
  // worldObj.movePlayer("Kitchen", ranObj));
  //
  // }

  // @Test(expected = IllegalArgumentException.class)
  // public void testWorldInvalidDisplayPlayerDetails1() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // itemObj = new ItemImplementation("Chair", 10);
  // roomObj.addItemToRoom(itemObj);
  // worldObj.addRoom(roomObj);
  // worldObj.addPlayerToGame(player);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // worldObj.displayPlayerDetails();
  // }

  // @Test(expected = IllegalArgumentException.class)
  // public void testWorldInvalidDisplayPlayerDetails2() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // itemObj = new ItemImplementation("Chair", 10);
  // roomObj.addItemToRoom(itemObj);
  // worldObj.addRoom(roomObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // worldObj.displayPlayerDetails();
  // }

  // @Test
  // public void testWorldValidDisplayPlayerDetails() {
  // targetObj = new Target("Dr.Lucky", 57);
  // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // player = new PlayerImplementation("Abhishek", "Lilac Room", 7, false);
  // itemObj = new ItemImplementation("Chair", 10);
  // roomObj.addItemToRoom(itemObj);
  // worldObj.addRoom(roomObj);
  // worldObj.addPlayerToGame(player);
  // roomObj = new RoomImplementation(2, 9, 7, 14, "Lilac Room", false);
  // worldObj.displayPlayerDetails();
  // }

  @Test
  public void testWorldToString() {
    targetObj = new Target("Dr.Lucky", 57);

    worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
    assertEquals("WorldName=Dr. Lucky mansion , maxRows=50, maxColumns=60", worldObj.toString());
  }

  @Test
  public void testWorldEquals() {

    targetObj = new Target("Dr.Lucky", 57);

    worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
    World worldObj2 = new WorldImplementation("Dr. Lucky mansion1", 50, 60, targetObj);

    assertFalse(worldObj.equals(worldObj2));
    assertTrue(worldObj.equals(worldObj));
    World worldObj3 = new WorldImplementation("Dr. Lucky mansion", 51, 60, targetObj);
    World worldObj4 = new WorldImplementation("Dr. Lucky mansion", 50, 61, targetObj);

    assertFalse(worldObj.equals(worldObj2));
    assertFalse(worldObj.equals(worldObj3));
    assertFalse(worldObj.equals(worldObj4));
    World worldObj1 = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);

    assertTrue(worldObj.equals(worldObj1));

    worldObj1 = worldObj;
    assertTrue(worldObj.equals(worldObj1));

    worldObj1 = null;
    assertFalse(worldObj.equals(worldObj1));

    Object worldObj7 = new Object();
    assertFalse(worldObj.equals(worldObj7));

  }

  @Test
  public void testWorldHash() {
    targetObj = new Target("Dr.Lucky", 57);

    worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);
    World worldObj1 = new WorldImplementation("Dr. Lucky mansion", 50, 60, targetObj);

    assertEquals(worldObj.hashCode(), worldObj1.hashCode());

  }

  // Player test

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayer1() {
    player = new PlayerImplementation("Abhishek", "Armory", -7, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayer2() {
    player = new PlayerImplementation("Abhishek", "", 7, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayer3() {
    player = new PlayerImplementation("", "Armory", 7, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayer4() {

    player = new PlayerImplementation(null, "Armory", 7, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayer5() {
    player = new PlayerImplementation("Abhishek", null, 7, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayer6() {
    player = new PlayerImplementation(null, null, 7, false);
  }

  @Test
  public void testPlayerGetName() {
    player = new PlayerImplementation("Abhishek", "Armory", 7, false);
    Player player1 = new PlayerImplementation("Abhinav", "Kitchen", 4, false);

    assertEquals("Abhishek", player.getName());
    assertEquals("Abhinav", player1.getName());

  }

  @Test
  public void testPlayerAddItem() {
    player = new PlayerImplementation("Abhishek", "Armory", 3, false);
    itemObj = new ItemImplementation("Knife", 10);
    Item itemObj1 = new ItemImplementation("Dagger", 10);
    Item itemObj2 = new ItemImplementation("Spade", 10);

    assertTrue(player.addItemToPlayer(itemObj));
    assertTrue(player.addItemToPlayer(itemObj1));
    assertTrue(player.addItemToPlayer(itemObj2));
    Item itemObj3 = new ItemImplementation("Chair", 10);
    assertFalse(player.addItemToPlayer(itemObj3));

    assertFalse(player.addItemToPlayer(null));

  }

  @Test
  public void testPlayerMove() {
    player = new PlayerImplementation("Abhishek", "Armory", 3, false);

    assertTrue(player.move("Armory"));

    assertFalse(player.move(""));
    assertFalse(player.move(null));

  }

  @Test
  public void testPlayerGetRoomName() {
    player = new PlayerImplementation("Abhishek", "Armory", 3, false);
    player.move("Armory");
    assertEquals("Armory", player.getRoomName());
  }

  @Test
  public void testPlayerGetMaxItem() {
    player = new PlayerImplementation("Abhishek", "Armory", 3, false);
    assertEquals(3, player.getMaxItem());

  }

  @Test
  public void testPlayerGetItems() {
    player = new PlayerImplementation("Abhishek", "Armory", 3, false);
    itemObj = new ItemImplementation("Knife", 10);
    Item itemObj1 = new ItemImplementation("Dagger", 10);
    Item itemObj2 = new ItemImplementation("Spade", 10);
    assertTrue(player.addItemToPlayer(itemObj));
    assertTrue(player.addItemToPlayer(itemObj1));
    assertTrue(player.addItemToPlayer(itemObj2));
    Item itemObj3 = new ItemImplementation("Chair", 10);
    assertFalse(player.addItemToPlayer(itemObj3));
    assertEquals(3, player.getMaxItem());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayer12() {
    player = new PlayerImplementation("Abhishek", "Armory", -7, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayer22() {
    player = new PlayerImplementation("Abhishek", "", 7, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayer32() {
    player = new PlayerImplementation("", "Armory", 7, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayer42() {

    player = new PlayerImplementation(null, "Armory", 7, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayer52() {
    player = new PlayerImplementation("Abhishek", null, 7, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPlayer62() {
    player = new PlayerImplementation(null, null, 7, true);
  }

  @Test
  public void testPlayerGetName2() {
    player = new PlayerImplementation("Abhishek", "Armory", 7, true);
    Player player1 = new PlayerImplementation("Abhinav", "Kitchen", 4, true);

    assertEquals("Abhishek", player.getName());
    assertEquals("Abhinav", player1.getName());

  }

  @Test
  public void testPlayerAddItem2() {
    player = new PlayerImplementation("Abhishek", "Armory", 3, true);
    itemObj = new ItemImplementation("Knife", 10);
    Item itemObj1 = new ItemImplementation("Dagger", 10);
    Item itemObj2 = new ItemImplementation("Spade", 10);

    assertTrue(player.addItemToPlayer(itemObj));
    assertTrue(player.addItemToPlayer(itemObj1));
    assertTrue(player.addItemToPlayer(itemObj2));
    Item itemObj3 = new ItemImplementation("Chair", 10);
    assertFalse(player.addItemToPlayer(itemObj3));

    assertFalse(player.addItemToPlayer(null));

  }

  @Test
  public void testPlayerMove2() {
    player = new PlayerImplementation("Abhishek", "Armory", 3, true);

    assertTrue(player.move("Armory"));

    assertFalse(player.move(""));
    assertFalse(player.move(null));

  }

  @Test
  public void testPlayerGetRoomName2() {
    player = new PlayerImplementation("Abhishek", "Armory", 3, true);
    player.move("Armory");
    assertEquals("Armory", player.getRoomName());
  }

  @Test
  public void testPlayerGetMaxItem2() {
    player = new PlayerImplementation("Abhishek", "Armory", 3, true);
    assertEquals(3, player.getMaxItem());

  }

  @Test
  public void testPlayerGetItems2() {
    player = new PlayerImplementation("Abhishek", "Armory", 3, true);
    itemObj = new ItemImplementation("Knife", 10);
    Item itemObj1 = new ItemImplementation("Dagger", 10);
    Item itemObj2 = new ItemImplementation("Spade", 10);
    assertTrue(player.addItemToPlayer(itemObj));
    assertTrue(player.addItemToPlayer(itemObj1));
    assertTrue(player.addItemToPlayer(itemObj2));
    Item itemObj3 = new ItemImplementation("Chair", 10);
    assertFalse(player.addItemToPlayer(itemObj3));
    assertEquals(3, player.getMaxItem());

  }

  // Testing Pet Class.

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPetRoomName() {
    petObj = new PetImplementation(null, "Daisy");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPetPetName() {
    petObj = new PetImplementation("Armory", null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPet() {
    petObj = new PetImplementation("", "");
  }

  @Test
  public void testValidPet() {
    petObj = new PetImplementation("Armory", "Daisy");
  }

  @Test
  public void testPetSetRoom() {
    petObj = new PetImplementation("Armory", "Daisy");
    String roomName = "Kitchen";

    assertEquals("Daisy moved to Kitchen.", petObj.setRoom(roomName));

  }

  // @Test(expected = IllegalArgumentException.class)
  // public void testPetInValidSetRoom1() {
  // // targetObj = new Target("Dr.Lucky", 57);
  // //
  // // worldObj = new WorldImplementation("Dr. Lucky mansion", 50, 60,
  // targetObj);
  // // roomObj = new RoomImplementation(2, 9, 7, 14, "Armory", false);
  // // Room roomObj1 = new RoomImplementation(2, 9, 7, 14, "Kitchen", false);
  // petObj = new PetImplementation(null, "Daisy");
  // // worldObj.addPet(petObj);
  // // worldObj.addRoom(roomObj);
  // // worldObj.addRoom(roomObj1);
  //
  //
  // String roomName = "Kitchen";
  // assertEquals("Daisy moved to Kitchen.", petObj.setRoom(roomName));
  //
  // }

  @Test
  public void testWorldDisplayDetails() {

    assertEquals("Room Name : Armory\n" + "Target present in the room : true\n"
        + "Neighbours : [Billiard Room, Dining Hall, Drawing Room]\n"
        + "Items in the room : [(ItemName=Revolver, value=3)]\n"
        + "Players in the room: [Abhishek]\n" + "Target is present in Armory\n"
        + "Daisy present in the room\n" + "\n", worldObj.displayPlayerDetails());

  }

  @Test
  public void checkTargetLocation() {
    assertEquals("Room Name : Armory\n" + "Target present in the room : true\n"
        + "Neighbours : [Billiard Room, Dining Hall, Drawing Room]\n"
        + "Items in the room : [(ItemName=Revolver, value=3)]\n"
        + "Players in the room: [Abhishek]\n" + "Target is present in Armory\n"
        + "Daisy present in the room\n\n" + "", worldObj.displayPlayerDetails());

    worldObj.movePlayer("Dining Hall", ranObj);

    assertEquals("Room Name : Billiard Room\n" + "Target present in the room : true\n"
        + "Neighbours : [Armory, Dining Hall]\n"
        + "Items in the room : [(ItemName=Billiard Cue, value=2), (ItemName=Knife, value=4)]\n"
        + "Players in the room: [Computer1]\n" + "Target is present in Billiard Room\n"
        + "Daisy present in the room\n" + "\n", worldObj.displayPlayerDetails());

    // Display room without pet
    worldObj.movePlayer("Armory", ranObj);
    worldObj.lookUp();

    assertEquals(
        "Room Name : Armory\n" + "Target present in the room : false\n"
            + "Neighbours : [Billiard Room, Dining Hall]\n"
            + "Items in the room : [(ItemName=Revolver, value=3)]\n"
            + "Players in the room: [Computer1]\n" + "Target is present in Drawing Room\n" + "",
        worldObj.displayPlayerDetails());

  }

  @Test
  public void peekIntoNeighbour1() {

    Player p3 = new PlayerImplementation("Richard", "Armory", 3, false);
    worldObj.addPlayerToGame(p3);
    assertEquals("Abhishek is present in Armory\n" + "Room Name : Armory\n"
        + "Target present in the room : true\n"
        + "Neighbours : [Billiard Room, Dining Hall, Drawing Room]\n"
        + "Items in the room : [(ItemName=Revolver, value=3)]\n"
        + "Players in the room: [Abhishek, Richard]\n" + "\n" + "Neighbours are:\n" + "1.\n"
        + "Room Name : Billiard Room\n" + "Target present in the room : false\n"
        + "Neighbours : [Dining Hall]\n"
        + "Items in the room : [(ItemName=Billiard Cue, value=2), (ItemName=Knife, value=4)]\n"
        + "Players in the room: [Computer1]\n" + "\n" + "2.\n" + "Room Name : Dining Hall\n"
        + "Target present in the room : false\n" + "Neighbours : [Billiard Room, Drawing Room]\n"
        + "Items in the room : []\n" + "Players in the room: []\n" + "\n" + "3.\n"
        + "Room Name : Drawing Room\n" + "Target present in the room : false\n"
        + "Neighbours : [Dining Hall]\n" + "Items in the room : []\n"
        + "Players in the room: []\n\n" + "", worldObj.lookUp());
  }

  @Test
  public void peekIntoNeighbour2() {

    Player p3 = new PlayerImplementation("Richard", "Armory", 3, false);
    worldObj.addPlayerToGame(p3);

    assertEquals("Abhishek is present in Armory\n" + "Room Name : Armory\n"
        + "Target present in the room : true\n"
        + "Neighbours : [Billiard Room, Dining Hall, Drawing Room]\n"
        + "Items in the room : [(ItemName=Revolver, value=3)]\n"
        + "Players in the room: [Abhishek, Richard]\n" + "\n" + "Neighbours are:\n" + "1.\n"
        + "Room Name : Billiard Room\n" + "Target present in the room : false\n"
        + "Neighbours : [Dining Hall]\n"
        + "Items in the room : [(ItemName=Billiard Cue, value=2), (ItemName=Knife, value=4)]\n"
        + "Players in the room: [Computer1]\n" + "\n" + "2.\n" + "Room Name : Dining Hall\n"
        + "Target present in the room : false\n" + "Neighbours : [Billiard Room, Drawing Room]\n"
        + "Items in the room : []\n" + "Players in the room: []\n" + "\n" + "3.\n"
        + "Room Name : Drawing Room\n" + "Target present in the room : false\n"
        + "Neighbours : [Dining Hall]\n" + "Items in the room : []\n"
        + "Players in the room: []\n\n" + "", worldObj.lookUp());
  }

  @Test
  public void displayPlayerswithPet() {

    Player p3 = new PlayerImplementation("Richard", "Armory", 3, false);
    worldObj.addPlayerToGame(p3);

    assertEquals("Room Name : Armory\n" + "Target present in the room : true\n"
        + "Neighbours : [Billiard Room, Dining Hall, Drawing Room]\n"
        + "Items in the room : [(ItemName=Revolver, value=3)]\n"
        + "Players in the room: [Abhishek, Richard]\n" + "Target is present in Armory\n"
        + "Daisy present in the room\n" + "" + "\n", worldObj.displayPlayerDetails());
  }

  @Test
  public void killwihtPlayerPet() {

    Player p3 = new PlayerImplementation("Richard", "Armory", 3, false);
    worldObj.addPlayerToGame(p3);
    assertEquals("Cannot attempt the Attack as someone is watching you!",
        worldObj.killTarget("poke"));
  }

  @Test
  public void displayPlayerswithoutPet() {

    Player p3 = new PlayerImplementation("Richard", "Armory", 3, false);
    worldObj.addPlayerToGame(p3);
    worldObj.lookUp();
    worldObj.lookUp();
    assertEquals("Room Name : Armory\n" + "Target present in the room : false\n"
        + "Neighbours : [Billiard Room, Drawing Room]\n"
        + "Items in the room : [(ItemName=Revolver, value=3)]\n"
        + "Players in the room: [Abhishek, Richard]\n" + "Target is present in Dining Hall\n" + "",
        worldObj.displayPlayerDetails());
  }

  @Test
  public void checkLookAround1() {

    worldObj.pickUpItem("Revolver", ranObj);
    assertEquals("Computer1 is present in Billiard Room\n" + "Room Name : Billiard Room\n"
        + "Target present in the room : true\n" + "Neighbours : [Armory, Dining Hall]\n"
        + "Items in the room : [(ItemName=Billiard Cue, value=2), (ItemName=Knife, value=4)]\n"
        + "Players in the room: [Computer1]\n" + "\n" + "Neighbours are:\n" + "1.\n"
        + "Room Name : Armory\n" + "Target present in the room : false\n"
        + "Neighbours : [Dining Hall, Drawing Room]\n" + "Items in the room : []\n"
        + "Players in the room: [Abhishek]\n" + "\n" + "2.\n" + "Room Name : Dining Hall\n"
        + "Target present in the room : false\n" + "Neighbours : [Armory, Drawing Room]\n"
        + "Items in the room : []\n" + "Players in the room: []\n\n" + "", worldObj.lookUp());
  }

  @Test
  public void checkLookAround2() {

    worldObj.movePlayer("Drawing Room", ranObj);
    worldObj.lookUp();
    assertEquals("Abhishek is present in Drawing Room\n" + "Room Name : Drawing Room\n"
        + "Target present in the room : false\n" + "Neighbours : [Armory]\n"
        + "Items in the room : []\n" + "Players in the room: [Abhishek]\n" + "\n"
        + "Neighbours are:\n" + "1.\n" + "Room Name : Armory\n"
        + "Target present in the room : false\n" + "Neighbours : [Billiard Room, Drawing Room]\n"
        + "Items in the room : [(ItemName=Revolver, value=3)]\n" + "Players in the room: []\n"
        + "\n", worldObj.lookUp());
  }

  @Test
  public void checkLookAround() {

    assertEquals(
        "Abhishek is present in Armory\n" + "Room Name : Armory\n"
            + "Target present in the room : true\n"
            + "Neighbours : [Billiard Room, Dining Hall, Drawing Room]\n"
            + "Items in the room : [(ItemName=Revolver, value=3)]\n"
            + "Players in the room: [Abhishek]\n" + "\n" + "Neighbours are:\n" + "1.\n"
            + "Room Name : Billiard Room\n" + "Target present in the room : false\n"
            + "Neighbours : [Dining Hall]\n"
            + "Items in the room : [(ItemName=Billiard Cue, value=2), (ItemName=Knife, value=4)]\n"
            + "Players in the room: [Computer1]\n" + "\n" + "2.\n" + "Room Name : Dining Hall\n"
            + "Target present in the room : false\n"
            + "Neighbours : [Billiard Room, Drawing Room]\n" + "Items in the room : []\n"
            + "Players in the room: []\n" + "\n" + "3.\n" + "Room Name : Drawing Room\n"
            + "Target present in the room : false\n" + "Neighbours : [Dining Hall]\n"
            + "Items in the room : []\n" + "Players in the room: []\n" + "\n" + "",
        worldObj.lookUp());

    assertEquals(
        "Computer1 is present in Billiard Room\n" + "Room Name : Billiard Room\n"
            + "Target present in the room : true\n" + "Neighbours : [Armory, Dining Hall]\n"
            + "Items in the room : [(ItemName=Billiard Cue, value=2), (ItemName=Knife, value=4)]\n"
            + "Players in the room: [Computer1]\n" + "\n" + "Neighbours are:\n" + "1.\n"
            + "Room Name : Armory\n" + "Target present in the room : false\n"
            + "Neighbours : [Dining Hall, Drawing Room]\n"
            + "Items in the room : [(ItemName=Revolver, value=3)]\n"
            + "Players in the room: [Abhishek]\n" + "\n" + "2.\n" + "Room Name : Dining Hall\n"
            + "Target present in the room : false\n" + "Neighbours : [Armory, Drawing Room]\n"
            + "Items in the room : []\n" + "Players in the room: []\n" + "" + "\n",
        worldObj.lookUp());
    worldObj.movePlayer("Billiard Room", ranObj);
    worldObj.lookUp();
    // Without target , pet in neighbour
    assertEquals("Abhishek is present in Billiard Room\n" + "Room Name : Billiard Room\n"
        + "Target present in the room : false\n" + "Neighbours : [Armory]\n"
        + "Items in the room : [(ItemName=Billiard Cue, value=2), (ItemName=Knife, value=4)]\n"
        + "Players in the room: [Computer1, Abhishek]\n" + "\n" + "Neighbours are:\n" + "1.\n"
        + "Room Name : Armory\n" + "Target present in the room : true\n"
        + "Neighbours : [Billiard Room, Drawing Room]\n"
        + "Items in the room : [(ItemName=Revolver, value=3)]\n" + "Players in the room: []\n" + ""
        + "\n", worldObj.lookUp());

  }

  @Test
  public void checkRelocatePet() {

    // Pet is relocated based on dfs.
    worldObj.movePet("Dining Hall", ranObj);
    assertEquals("Room Name : Billiard Room\n" + "Target present in the room : true\n"
        + "Neighbours : [Armory, Dining Hall]\n"
        + "Items in the room : [(ItemName=Billiard Cue, value=2), (ItemName=Knife, value=4)]\n"
        + "Players in the room: [Computer1]\n" + "Target is present in Billiard Room\n"
        + "Daisy present in the room\n" + "" + "\n", worldObj.displayPlayerDetails());

    worldObj.lookUp();

    assertEquals("Room Name : Armory\n" + "Target present in the room : false\n"
        + "Neighbours : [Billiard Room, Dining Hall, Drawing Room]\n"
        + "Items in the room : [(ItemName=Revolver, value=3)]\n"
        + "Players in the room: [Abhishek]\n" + "Target is present in Dining Hall\n"
        + "Daisy present in the room\n" + "\n", worldObj.displayPlayerDetails());

    worldObj.movePet("dfs", ranObj);

    assertEquals(
        "Room Name : Armory\n" + "Target present in the room : false\n"
            + "Neighbours : [Billiard Room, Dining Hall]\n"
            + "Items in the room : [(ItemName=Revolver, value=3)]\n"
            + "Players in the room: [Abhishek]\n" + "Target is present in Dining Hall" + "" + "\n",
        worldObj.displayPlayerDetails());

    worldObj.movePet("dfs", ranObj);

    assertEquals("Room Name : Armory\n" + "Target present in the room : false\n"
        + "Neighbours : [Billiard Room, Dining Hall, Drawing Room]\n"
        + "Items in the room : [(ItemName=Revolver, value=3)]\n"
        + "Players in the room: [Abhishek]\n" + "Target is present in Dining Hall\n"
        + "Daisy present in the room\n\n" + "", worldObj.displayPlayerDetails());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testHitTargetInvalid() {

    worldObj.killTarget("whdl");
  }

  @Test
  public void testHitTarget() {

    // attack when being seen by neighbour
    assertEquals("New health of the target is 2", worldObj.killTarget("poke"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testHitTargetUnSuccess() {

    // attack when target not in same room.
    worldObj.pickUpItem("Revolver", ranObj);
    worldObj.lookUp();
    worldObj.movePlayer("Drawing Room", ranObj);
    worldObj.lookUp();

    worldObj.killTarget("poke");
  }

  @Test
  public void testHitTargetSuccess() {

    // attack by poking
    worldObj.pickUpItem("Revolver", ranObj);
    worldObj.pickUpItem("Knife", ranObj);
    worldObj.movePlayer("Drawing Room", ranObj);
    worldObj.lookUp();
    worldObj.movePet("Drawing Room", ranObj);
    // reduce health by 1.
    assertEquals("New health of the target is 2", worldObj.killTarget("poke"));
  }

  @Test
  public void testHitTargetSuccessItemHit() {

    // attack by item
    worldObj.pickUpItem("Revolver", ranObj);
    worldObj.pickUpItem("Billiard Cue", ranObj);
    worldObj.movePlayer("Drawing Room", ranObj);

    assertEquals(
        "Room Name : Billiard Room\n" + "Target present in the room : false\n"
            + "Neighbours : [Armory, Dining Hall]\n"
            + "Items in the room : [(ItemName=Knife, value=4)]\n"
            + "Players in the room: [Computer1]\n" + "Target is present in Drawing Room\n" + "",
        worldObj.displayPlayerDetails());
    worldObj.lookUp();
    worldObj.movePet("Drawing Room", ranObj);
    assertEquals("New health of the target is 1", worldObj.killTarget("Billiard Cue"));
    worldObj.lookUp();

    assertEquals("Room Name : Billiard Room\n" + "Target present in the room : false\n"
        + "Neighbours : [Dining Hall]\n" + "Items in the room : [(ItemName=Knife, value=4)]\n"
        + "Players in the room: [Computer1]\n" + "Target is present in Drawing Room" + "\n" + "",
        worldObj.displayPlayerDetails());
  }

  @Test
  public void testHitTargetSuccessKill() {

    // attack by item

    worldObj.pickUpItem("Revolver", ranObj);
    worldObj.pickUpItem("Knife", ranObj);
    worldObj.movePlayer("Drawing Room", ranObj);
    worldObj.lookUp();
    worldObj.movePet("Drawing Room", ranObj);

    assertEquals("Game Over!! Computer1 wins the game.", worldObj.killTarget("Knife"));
  }

  @Test
  public void testHitUnSuccessKill() {

    // attack by item

    worldObj.pickUpItem("Revolver", ranObj);
    worldObj.pickUpItem("Knife", ranObj);
    worldObj.movePlayer("Billiard Room", ranObj);
    worldObj.lookUp();
    worldObj.movePet("Drawing Room", ranObj);
    assertEquals("Cannot attempt the Attack as someone is watching you!",
        worldObj.killTarget("Knife"));
  }

  @Test
  public void testLookWithoutTarget() {

    // attack by item

    worldObj.pickUpItem("Revolver", ranObj);
    worldObj.pickUpItem("Knife", ranObj);
    worldObj.lookUp();

    assertEquals(
        "Room Name : Billiard Room\n" + "Target present in the room : false\n"
            + "Neighbours : [Armory, Dining Hall]\n"
            + "Items in the room : [(ItemName=Billiard Cue, value=2)]\n"
            + "Players in the room: [Computer1]\n" + "Target is present in Drawing Room\n" + "",
        worldObj.displayPlayerDetails());
    assertEquals("Computer1 is present in Billiard Room\n" + "Room Name : Billiard Room\n"
        + "Target present in the room : false\n" + "Neighbours : [Armory, Dining Hall]\n"
        + "Items in the room : [(ItemName=Billiard Cue, value=2)]\n"
        + "Players in the room: [Computer1]\n" + "\n" + "Neighbours are:\n" + "1.\n"
        + "Room Name : Armory\n" + "Target present in the room : false\n"
        + "Neighbours : [Billiard Room, Dining Hall]\n" + "Items in the room : []\n"
        + "Players in the room: [Abhishek]\n" + "\n" + "2.\n" + "Room Name : Dining Hall\n"
        + "Target present in the room : false\n" + "Neighbours : [Billiard Room, Armory]\n"
        + "Items in the room : []\n" + "Players in the room: []\n" + "\n", worldObj.lookUp());
  }

}

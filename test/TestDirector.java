import static org.junit.Assert.assertEquals;

import facade.Director;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.junit.Test;
import world.Item;
import world.ItemImplementation;
import world.Room;
import world.RoomImplementation;
import world.Target;
import world.World;
import world.WorldImplementation;

/**
 * 
 * Test Directory Class.
 *
 */
public class TestDirector {

  @Test
  public void testDirector() throws InputMismatchException, IOException {
    Director dirObj = new Director(new FileReader(
        "/Users/abhishekkumar/MyPC/MS/PDP-Workspace/cs5010-project-abhishekkr0550/res/input.txt"));
    World obj = dirObj.createWorld();
    Readable readFile = new FileReader(
        "/Users/abhishekkumar/MyPC/MS/PDP-Workspace/cs5010-project-abhishekkr0550/res/input.txt");
    Scanner scanner = new Scanner(readFile);

    int c = 1;
    int size1 = 0;
    int size2 = 0;
    int row1 = 0;
    int col1 = 0;
    int row2 = 0;
    int col2 = 0;
    int roomCount = 0;
    int roomIndexOfItem = 0;
    int itemValue = 0;
    String itemName = "";
    String roomName = "";

    String gameName = "";
    String targetName = "";
    World worldObj = null;
    Target targetObj = null;
    Room roomObj;
    Item itemObj;

    while (scanner.hasNext()) {
      if (c == 1) {
        size1 = scanner.nextInt();
        size2 = scanner.nextInt();
        gameName = scanner.nextLine().trim();
      } else if (c == 2) {
        int health = scanner.nextInt();
        targetName = scanner.nextLine().trim();
        targetObj = new Target(targetName, health);
      } else if (c == 3) {
        roomCount = scanner.nextInt();

        worldObj = new WorldImplementation(gameName, size1, size2, targetObj);

      } else if (c <= (roomCount + 3)) {
        row1 = scanner.nextInt();
        col1 = scanner.nextInt();
        row2 = scanner.nextInt();
        col2 = scanner.nextInt();
        roomName = scanner.nextLine().trim();
        roomObj = new RoomImplementation(row1, col1, row2, col2, roomName, false);
        worldObj.addRoom(roomObj);

      } else if (c == roomCount + 4) {
        scanner.nextInt();

      } else {
        roomIndexOfItem = scanner.nextInt();
        itemValue = scanner.nextInt();
        itemName = scanner.nextLine().trim();

        itemObj = new ItemImplementation(itemName, itemValue);

        ((Room) worldObj.getRooms().get(roomIndexOfItem)).addItemToRoom(itemObj);

      }
      c++;
    }
    scanner.close();
    assertEquals(worldObj.toString(), obj.toString());
  }

  @Test(expected = InputMismatchException.class)
  public void testDirectorInvalid() throws InputMismatchException, IOException {
    Director dirObj = new Director(
        new FileReader("/Users/abhishekkumar/MyPC/MS/PDP-Workspace/cs5010-project-abhishekkr0550/"
            + "res/inputInvalid.txt"));
    World obj = dirObj.createWorld();

    Scanner scanner = new Scanner(
        new FileReader("/Users/abhishekkumar/MyPC/MS/PDP-Workspace/cs5010-project-abhishekkr0550/"
            + "res/inputInvalid.txt"));
    int c = 1;
    int size1 = 0;
    int size2 = 0;
    int row1 = 0;
    int col1 = 0;
    int row2 = 0;
    int col2 = 0;
    int roomCount = 0;
    int roomIndexOfItem = 0;
    int itemValue = 0;
    String itemName = "";
    String roomName = "";

    String gameName = "";
    String targetName = "";
    World worldObj = null;
    Target targetObj = null;
    Room roomObj;
    Item itemObj;

    while (scanner.hasNext()) {
      if (c == 1) {
        size1 = scanner.nextInt();
        size2 = scanner.nextInt();
        gameName = scanner.nextLine().trim();
      } else if (c == 2) {
        int health = scanner.nextInt();
        targetName = scanner.nextLine().trim();
        targetObj = new Target(targetName, health);
      } else if (c == 3) {
        roomCount = scanner.nextInt();

        worldObj = new WorldImplementation(gameName, size1, size2, targetObj);

      } else if (c <= (roomCount + 3)) {
        row1 = scanner.nextInt();
        col1 = scanner.nextInt();
        row2 = scanner.nextInt();
        col2 = scanner.nextInt();
        roomName = scanner.nextLine().trim();
        roomObj = new RoomImplementation(row1, col1, row2, col2, roomName, false);
        worldObj.addRoom(roomObj);

      } else if (c == roomCount + 4) {
        scanner.nextInt();

      } else {
        roomIndexOfItem = scanner.nextInt();
        itemValue = scanner.nextInt();
        itemName = scanner.nextLine().trim();

        itemObj = new ItemImplementation(itemName, itemValue);

        ((Room) worldObj.getRooms().get(roomIndexOfItem)).addItemToRoom(itemObj);

      }
      c++;
    }
    scanner.close();
    assertEquals(worldObj.toString(), obj.toString());
  }

}

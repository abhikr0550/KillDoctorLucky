package facade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import world.Item;
import world.ItemImplementation;
import world.Pet;
import world.PetImplementation;
import world.Room;
import world.RoomImplementation;
import world.Target;
import world.World;
import world.WorldImplementation;

/**
 * 
 * A class to parse the input file and call the required functionalities.
 *
 * @author Abhishek & Valay
 */
public class Director {

  private final Readable file;

  /**
   * Takes the file as input and parses it to create a model object to play the
   * game.
   * 
   * @param file which is paresed for model creation.
   * @throws FileNotFoundException when the file is null.
   */
  public Director(Readable file) {
    if (file == null) {
      throw new IllegalStateException("File cannot be null");
    }
    this.file = file;
  }

  /**
   * It is responsible for performing the parse of the input file using Scanner
   * class. It creates the object of the Item, Room, Target and the World.
   * 
   * @return :returns WorldObject.
   * @throws IOException : Exception thrown.
   */
  public World createWorld() {

    try {
      Scanner scanner = new Scanner(this.file);
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
      String petName = "";
      String targetName = "";
      World worldObj = null;
      Target targetObj = null;
      Pet petObj = null;
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
          petName = scanner.nextLine().trim();
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

          if (c == 4) {
            petObj = new PetImplementation(roomName, petName);
            worldObj.addPet(petObj);
            roomObj.setTaregtPresence(true);
            roomObj.setPetPresence(true);
          }

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
      return worldObj;

    } catch (IllegalArgumentException iae) {
      System.out.println(iae);
    } catch (InputMismatchException inputmismatch) {
      System.out.println("The File does not have a proper format of input!!");
    }

    return null;

  }

}

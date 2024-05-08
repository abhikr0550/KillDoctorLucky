package world;

import java.util.ArrayList;
import java.util.List;

/**
 * It is the target's pet which moves across different room in the world. It
 * makes the room invisible for the player's of other rooms. A player can change
 * the position of the pet to any specific space in the world. After every turn,
 * the pet moves to the next space in DFS traversal.
 * 
 * @author abhishekkumar
 *
 */
public class PetImplementation implements Pet {

  private String roomName;
  private String petName;
  private List<String> roomNameList;
  private List<Boolean> roomVisited;
  private List<String> stack;

  /**
   * It initialises the pet with the first room which is same as the target's
   * room. It also sets the name of the pet.
   * 
   * @param roomName which the first landing room for the pet
   * @param petName  stores the name of the pet.
   */
  public PetImplementation(String roomName, String petName) {
    if (roomName == null || petName == null || "".equals(roomName) || "".equals(petName)) {
      throw new IllegalArgumentException("RoomName or Pet Name cannot be null");
    }
    this.roomName = roomName;
    this.petName = petName;
    roomNameList = new ArrayList<>();
    roomVisited = new ArrayList<>();
    stack = new ArrayList<>();
  }

  @Override
  public void addRoom(String roomName) {

    if (roomName == null) {
      throw new IllegalArgumentException("RoomName cannot be null");
    }

    this.roomNameList.add(roomName);
    this.roomVisited.add(false);
  }

  @Override
  public void nullifyDfs() {
    for (int i = 0; i < roomVisited.size(); i++) {
      roomVisited.set(i, false);
    }
  }

  @Override
  public boolean movePetDfs(List<String> neighbours) {

    if (neighbours == null) {
      throw new IllegalArgumentException("Neighbour list cannot be null");
    }
    StringBuilder str = new StringBuilder();

    if (stack.size() == 0) {
      nullifyDfs();
      roomVisited.set(roomNameList.indexOf(roomName), true);
    }

    boolean movement = false;
    for (String r : neighbours) {
      if (!roomVisited.get(roomNameList.indexOf(r))) {
        movement = true;
        if (stack.size() == 0) {
          stack.add(roomName);
        } else {
          if (!stack.get(stack.size() - 1).equals(roomName)) {
            stack.add(roomName);
          }
        }

        roomVisited.set(roomNameList.indexOf(roomName), true);
        str.append(this.setRoom(r));
        return movement;
      }
    }
    roomVisited.set(roomNameList.indexOf(roomName), true);
    stack.remove(roomName);
    if (stack.size() >= 1) {
      str.append(this.setRoom(stack.get(stack.size() - 1)));
      return true;
    }
    return false;

  }

  @Override
  public String setRoom(String roomName) {
    if (roomName == null) {
      throw new IllegalArgumentException("RoomName cannot be null");
    }

    StringBuilder str = new StringBuilder();

    this.roomName = roomName;

    str.append(String.format("%s moved to %s.", this.petName, this.roomName));
    return str.toString();
  }

  @Override
  public String getRoomName() {

    return this.roomName;

  }

  @Override
  public String getPetName() {

    return this.petName;

  }
}

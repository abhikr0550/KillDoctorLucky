package world;

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
public interface Pet {

  /**
   * It moves the pet the given room.
   * 
   * @param roomName the space the pet moves
   * @return the detils of the movememt.
   * 
   */
  public String setRoom(String roomName);

  /**
   * It returns the current room of the pet where it is currently present.
   * 
   * @return the name of the current room of the pet.
   * 
   */
  public String getRoomName();

  /**
   * It returns the name of the pet.
   * 
   * @return the name of the pet.
   */
  public String getPetName();

  /**
   * It adds the new room to the array list of rooms inside the pet.
   * 
   * @param roomName to be added to the arrays list of pet.
   */
  public void addRoom(String roomName);

  /**
   * It makes the mvememt of the pet in Depth First Search Traversal.
   * 
   * @param neighbours is the list of connected nodes to the current node.
   * @return true if movement is successful.
   */
  public boolean movePetDfs(List<String> neighbours);

  /**
   * It resets the whole arraylist of boolean to false. In other words, it
   * restarts the traversal of pet in DFS format.
   */
  public void nullifyDfs();

}

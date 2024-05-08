package com.milestone2.controller.command;

import com.milestone2.controller.Action;
import driver.MyRandomInterface;
import facade.IntermediateWorld;

/**
 * It is the class which implements the Action interface and changes the
 * position of the pet to any specific space in the world. The pet then moves in
 * DFS in every turn.
 * 
 * @author Abhishek & Valay
 *
 */
public class RelocatePet implements Action {

  private final String roomName;
  private String output;
  private final MyRandomInterface randObj;

  /**
   * 
   * This is initialised from the controller to relocate the pet to any space in
   * the world.
   * 
   * @param randObj  is the random object to choose random neighbours for computer
   *                 player.
   * @param roomName is the place where wants to move.
   */
  public RelocatePet(String roomName, MyRandomInterface randObj) {
    if (roomName == null || randObj == null) {
      throw new IllegalArgumentException("Input or Output Objects cannot be null");
    }
    this.roomName = roomName;
    this.output = "";
    this.randObj = randObj;

  }

  @Override
  public String performAction(IntermediateWorld facadeObj) {
    if (facadeObj != null) {
      try {
        output = facadeObj.relocatePet(roomName, randObj) + "\n";
      } catch (IllegalArgumentException e) {
        output = e.getMessage() + "\n";
      }
      return output;

    } else {
      throw new IllegalArgumentException("Invalid");
    }
  }

}

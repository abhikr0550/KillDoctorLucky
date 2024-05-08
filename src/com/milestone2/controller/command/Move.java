package com.milestone2.controller.command;

import com.milestone2.controller.Action;
import driver.MyRandomInterface;
import facade.IntermediateWorld;

/**
 * It is the class which implements the Action interface and tries to moves the
 * player to the given room.
 * 
 * @author Abhishek & Valay
 *
 */
public class Move implements Action {

  private final String roomName;
  private String output;
  private final MyRandomInterface randObj;

  /**
   * 
   * This is initialised from the controller in order to move the player to its
   * one of its neighbouring rooms.
   * 
   * @param randObj  is the random object to choose random neighbours for computer
   *                 player.
   * @param roomName is the place where wants to move.
   */
  public Move(String roomName, MyRandomInterface randObj) {
    if (roomName == null || randObj == null) {
      throw new IllegalArgumentException("Input or Output Objects cannot be null");
    }

    this.roomName = roomName;
    this.randObj = randObj;
    this.output = "";
  }

  @Override
  public String performAction(IntermediateWorld facadeObj) {

    if (facadeObj != null) {
      try {
        output = facadeObj.movePlayer(roomName, randObj) + "\n";
      } catch (IllegalArgumentException e) {
        output = e.getMessage() + "\n";
      }
      return output;

    } else {
      throw new IllegalArgumentException("Invalid");
    }
  }

}

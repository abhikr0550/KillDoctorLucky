package com.milestone2.controller.command;

import com.milestone2.controller.Action;
import facade.IntermediateWorld;

/**
 * It is the class which implements the Action interface and shows the details
 * of each neighbour where the player is currently present. .
 * 
 * @author Abhishek & Valay
 *
 */
public class LookAround implements Action {

  private String output;

  /**
   * 
   * This is called from the controller in order to check the neighbours of a
   * room. According to the given turn, it decides the player and then the room
   * the player is currently residing in.
   * 
   **/

  public LookAround() {
    this.output = "";

  }

  @Override
  public String performAction(IntermediateWorld facadeObj) {
    if (facadeObj != null) {
      try {
        output = facadeObj.lookUp() + "\n";

      } catch (IllegalArgumentException e) {
        output = e.getMessage() + "\n";
      }

      return output;
    } else {
      throw new IllegalArgumentException("Invalid");
    }
  }

}

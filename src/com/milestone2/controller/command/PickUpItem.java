package com.milestone2.controller.command;

import com.milestone2.controller.Action;
import driver.MyRandomInterface;
import facade.IntermediateWorld;

/**
 * It is the class which implements the Action interface and tries to pickup the
 * item from the room in which the player os present.
 * 
 * @author Abhishek & Valay
 *
 */
public class PickUpItem implements Action {

  private final String itemName;
  private String output;
  private final MyRandomInterface randObj;

  /**
   * This is initialised in the controller in order to pick the item from the
   * player's room.
   * 
   * 
   * @param randObj  is the random object to choose random neighbours for computer
   *                 player.
   * @param itemName is the item which the player wants to pick.
   **/

  public PickUpItem(String itemName, MyRandomInterface randObj) {
    if (itemName == null || randObj == null) {
      throw new IllegalArgumentException("Input or Output Objects cannot be null");
    }

    this.output = "";

    this.itemName = itemName;
    this.randObj = randObj;

  }

  @Override
  public String performAction(IntermediateWorld facadeObj) {
    if (facadeObj != null) {
      try {
        output = facadeObj.pickUpItem(itemName, randObj);
      } catch (IllegalArgumentException e) {
        output = e.getMessage() + "\n";
      }
      return output;

    } else {
      throw new IllegalArgumentException("Invalid");
    }
  }

}

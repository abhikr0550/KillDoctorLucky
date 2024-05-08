package com.milestone2.controller.command;

import com.milestone2.controller.Action;
import facade.IntermediateWorld;

/**
 * It is the class which implements the Action interface and attempts to kill
 * the target if it is in the same space as that of the player. The attack would
 * be unsuccessful if the player is seen by its neighbours. .
 * 
 * @author Abhishek & Valay
 *
 */
public class Attack implements Action {

  private String itemName;
  private String output;

  /**
   * 
   * This is initialised from the controller to attack the target if it is in the
   * same space.
   * 
   * @param itemName object to take the input.
   */
  public Attack(String itemName) {
    if (itemName == null) {
      throw new IllegalArgumentException("Input cannot be null");
    }

    this.itemName = itemName;
    this.output = "";

  }

  @Override
  public String performAction(IntermediateWorld facadeObj) {
    if (facadeObj != null) {
      try {
        // itemName = "";
        boolean firstTurn = facadeObj.isPlayerEmpty();

        if ((!firstTurn) && (facadeObj.computerPlayer())) {
          itemName = "Comp";
        }
        output = facadeObj.killTarget(itemName);
      } catch (IllegalArgumentException e) {
        output = e.getMessage() + "\n";
      }

      return output;
    } else {

      throw new IllegalArgumentException("Input cannot be null");
    }

  }

}

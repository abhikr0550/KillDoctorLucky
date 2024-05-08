package com.milestone2.controller.command;

import com.milestone2.controller.Action;
import facade.IntermediateWorld;

/**
 * It is called by the controller when the player id to be added to the game.
 * Here the player can be either the human or computer player and calls the
 * facade to add the player.
 * 
 * @author Abhishek & Valay
 *
 */
public class AddHumanPlayer implements Action {

  private final String playerName;
  private final String roomName;
  private final int maxItemPlayer;
  private final boolean isBot;
  private String output;

  /**
   * 
   * This is called from the controller in order to add the player to its one of
   * its neighbouring rooms.
   * 
   * @param playerName    name of the player.
   * @param roomName      name of the landing room.
   * @param maxItemPlayer maximum number of item a player can carry.
   * @param isBot         whether the player is computer or human.
   **/
  public AddHumanPlayer(String playerName, String roomName, int maxItemPlayer, boolean isBot) {
    if (playerName == null || roomName == null) {
      throw new IllegalArgumentException("I-O Objects cannot be null");
    }
    this.playerName = playerName;
    this.roomName = roomName;
    this.maxItemPlayer = maxItemPlayer;
    this.isBot = isBot;
    this.output = "";
  }

  @Override
  public String performAction(IntermediateWorld facadeObj) {

    if (facadeObj != null) {
      try {

        output = facadeObj.addPlayerToGame(playerName, roomName, maxItemPlayer, isBot);

      } catch (IllegalArgumentException e) {
        output = e.getMessage() + "\n";
      }
      return output;

    } else {

      throw new IllegalArgumentException("Input cannot be null");
    }
  }

}

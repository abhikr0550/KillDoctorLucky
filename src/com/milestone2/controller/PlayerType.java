package com.milestone2.controller;

/**
 * Represents type of Player in the game.
 * 
 * @author Abhishek & Valay
 */
public enum PlayerType {

  HUMAN(false), COMPUTER(true);

  private final boolean disp;

  private PlayerType(boolean disp) {
    this.disp = disp;
  }

  @Override
  public String toString() {
    return Boolean.toString(disp);
  }
}

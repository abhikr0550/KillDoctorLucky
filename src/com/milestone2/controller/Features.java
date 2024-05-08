package com.milestone2.controller;

/**
 * It receives the model object from the driver and also receives the max number
 * of turn. It the allows us to play the board game. It has various function
 * calls that can be performed while paying the game. It prepares the respective
 * command for each operation and calls the respective command patter class in
 * order to provide the operation.
 * 
 * @author Abhishek & Valay
 *
 */
public interface Features {

  /**
   * It marks the beginning of the game. It enables the first and initiates the
   * flow of the game.
   */
  void playGame();

  /**
   * Move player to the room of corresponding click coordinates.
   * 
   * @param row Row coordinate value
   * @param col Column coordinate value
   */
  public void movePlayerOnClick(int row, int col);

  /**
   * Loading world file specification given by the user.
   * 
   * @param filePath File path of the given world specification file
   */
  public void loadOtherFile(String filePath);

  /**
   * Adding listeners to the required components in the view.
   */
  public void addListeners();

  /**
   * Check if player is plotted at given coordinates.
   * 
   * @param row row value of the plot
   * @param col column value of the plot
   * @return Player name who is present at given coordinate. Null if not present.
   */
  boolean checkIfPlayerPlotted(int row, int col);

  /**
   * Display player information at given coordinates.
   * 
   * @param row row value of the plot
   * @param col column value of the plot
   */
  void showPlayerInformation(int row, int col);

}

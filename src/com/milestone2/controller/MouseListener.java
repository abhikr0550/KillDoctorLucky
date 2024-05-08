package com.milestone2.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class represents a mouse listener. It is configurable by the controller
 * that instantiates it. It handles the functionality when mouse if clicked.
 * 
 * @author Abhishek & Valay
 *
 */
public class MouseListener extends MouseAdapter {

  private final Features contObj;

  /**
   * Default constructor.
   * 
   * @param contObj stores the object of the controller.
   */
  public MouseListener(Features contObj) {
    if (contObj == null) {
      throw new IllegalArgumentException("Controller cannot be null");
    }

    this.contObj = contObj;

  }

  @Override
  public void mouseClicked(MouseEvent e) {

    int row = e.getX() / 20;
    int col = e.getY() / 20;

    if (contObj.checkIfPlayerPlotted(row, col)) {
      contObj.showPlayerInformation(row, col);
    } else {
      contObj.movePlayerOnClick(row, col);
    }
  }
}

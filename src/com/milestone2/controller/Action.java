package com.milestone2.controller;

import facade.IntermediateWorld;

/**
 * It is the interface for the command design patterns which basically has 2
 * functionalities, i.e to perform action and getOutput String. The
 * getOutputString returns the appendable object i.e string and perform action
 * is currently implemented by several Command Classes to perform its action
 * like, move, add player, display space, display player, lookup and pick item
 * 
 * @author Abhishek & Valay
 *
 */
public interface Action {

  /**
   * It is currently implemented by several Command Classes to perform its action
   * like, move, add player, display space, display player, lookup and pick item.
   * 
   * @param facadeObj is the facade object which is to be passes int o the model.
   * @return whether the action is successful or not.
   */
  String performAction(IntermediateWorld facadeObj);

}

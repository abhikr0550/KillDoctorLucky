package com.milestone2.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;

/**
 * This class represents a keyboard listener. It is configurable by the
 * controller that instantiates it.
 *
 * <p>
 * This listener keeps three maps, one each for key typed, key pressed and key
 * released Each map stores a key mapping. A key mapping is a pair
 * (keystroke,code to be executed with that keystroke) The latter part of that
 * pair is actually a function object, i.e. an object of a class that implements
 * the Runnable interface
 *
 * <p>
 * This class implements the KeyListener interface, so that its object can be
 * used as a valid key listener for Java Swing.
 * 
 * @author Abhishek & Valay
 */
public class KeyboardListener extends KeyAdapter {
  private Map<Character, Runnable> keyTypedMap;

  /**
   * Default constructor.
   */
  public KeyboardListener() {
    keyTypedMap = null;

  }

  /**
   * Set the map for key typed events. Key typed events in Java Swing are
   * characters.
   * 
   * @param map the actions for keys typed
   */
  public void setKeyTypedMap(Map<Character, Runnable> map) {
    if (map == null) {
      throw new IllegalArgumentException("\nInvalid key type map");
    }
    keyTypedMap = map;
  }

  /**
   * This is called when the view detects that a key has been typed. Find if
   * anything has been mapped to this key character and if so, execute it
   * 
   * @param e information on the key event that triggered this callback
   */

  @Override
  public void keyTyped(KeyEvent e) {
    if (e == null) {
      throw new IllegalArgumentException("\nInvalid key event");
    }
    if (keyTypedMap.containsKey(e.getKeyChar())) {
      keyTypedMap.get(e.getKeyChar()).run();
    }
  }
}

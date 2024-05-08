package com.milestone2.controller;

import com.milestone2.controller.command.AddHumanPlayer;
import com.milestone2.controller.command.Attack;
import com.milestone2.controller.command.LookAround;
import com.milestone2.controller.command.Move;
import com.milestone2.controller.command.PickUpItem;
import com.milestone2.controller.command.RelocatePet;
import driver.MyRandomInterface;
import facade.Director;
import facade.IntermediateWorld;
import facade.IntermediateWorldImplementation;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import view.GameView;
import world.World;

/**
 * 
 * It receives the model object from the driver and also receives the max number
 * of turn. It the allows us to play the board game. It has various function
 * calls that can be performed while paying the game. It prepares the respective
 * command for each operation and calls the respective command patter class in
 * order to provide the operation.
 * 
 * @author Abhishek & Valay
 *
 */
public class ControllerImplementation implements Features {

  private IntermediateWorld facadeObj;
  private GameView viewObj;
  private final String filePath;
  private final int maxTurn;
  private final MyRandomInterface randObj;

  private Action objAction;

  /**
   * It initialises the readable and appendable object which can be used to run
   * the game.
   * 
   * @param filePath  model path.
   * @param maxTurn   the Maximum turn of the game.
   * @param randObj   the for computer player to choose the object randomly.
   * @param facadeObj model Object.
   * @param viewObj   View Object.
   */
  public ControllerImplementation(IntermediateWorld facadeObj, GameView viewObj, int maxTurn,
      MyRandomInterface randObj, String filePath) {

    if (facadeObj == null || viewObj == null || viewObj == null || randObj == null
        || filePath == null || filePath.isEmpty()) {
      throw new IllegalArgumentException("Object parameter cannot be null");
    }

    this.facadeObj = facadeObj;
    this.filePath = filePath;
    this.viewObj = null;
    this.maxTurn = maxTurn;
    this.randObj = randObj;
    this.objAction = null;
    this.viewObj = viewObj;
    facadeObj.setMaxturn(maxTurn);
    viewObj.setUpFrame(facadeObj);

    this.addListeners();

  }

  @Override
  public void playGame() {

    viewObj.makeVisible("welcome");

  }

  @Override
  public void addListeners() {
    configureButtonListener();
    configureKeyBoardListener();
    configureMouseListener();
  }

  private void checkGameOver() {
    if (facadeObj.gameOver()) {
      if (facadeObj.getTargetHealth() <= 0) {
        viewObj.makeVisible("welcome");
      } else {
        String msg = "Game Over!! Target Escaped from the world!!";
        viewObj.addPlayerUp(msg);

        viewObj.makeVisible("welcome");
      }
    }
  }

  /**
   * Render the view after various changes in the view.
   */
  private void renderView() {
    viewObj.setCurrentPlayerLabel(facadeObj.getCurrentPlayerInformation());
    String playerDetails = facadeObj.displayPlayerDetails();
    String[] splitPlayerDetails = playerDetails.split("\n");
    StringBuilder tempPlayerDetails = new StringBuilder();
    int i = 0;
    for (String string : splitPlayerDetails) {
      if (i != 1) {
        tempPlayerDetails.append(string);
        tempPlayerDetails.append("\n");
      }
      i++;
    }
    playerDetails = tempPlayerDetails.toString();
    playerDetails = "<html>" + playerDetails + "<html>";

    playerDetails = playerDetails.replace("\n", "<br>");
    viewObj.setStatsLabel(playerDetails);
    viewObj.resetFocus();

    viewObj.repaint();

  }

  /**
   * Move computer player.
   */
  private void compMovement() {
    boolean isBot = facadeObj.computerPlayer();
    String s = "";
    if (isBot && !facadeObj.gameOver()) {
      int randVal = randObj.getRandomValue(5);

      if (facadeObj.playerTargetTogether()) {
        randVal = 4;
      }
      switch (randVal) {

        case 0:
          objAction = new Move("Invalid", randObj);
          s = objAction.performAction(facadeObj);
          s = "<html> Computer Player Played Move<html> <br><br>" + s;

          viewObj.addPlayerUp(s);
          break;
        case 1:
          objAction = new PickUpItem("Invalid", randObj);
          s = objAction.performAction(facadeObj);
          s = "<html> Computer Player Played Pick Item <html> <br><br>" + s;

          viewObj.addPlayerUp(s);

          renderView();
          break;
        case 2:
          objAction = new LookAround();
          s = objAction.performAction(facadeObj);
          s = "<html> Computer Player Played Look Around <html> <br><br>" + s;

          s = "<html>" + s + "<html>";
          s = s.replace("\n", "<br>");

          viewObj.lookAroundPopUp(s);

          renderView();
          break;
        case 3:
          objAction = new RelocatePet("Comp", randObj);
          s = objAction.performAction(facadeObj);
          s = "<html> Computer Player Played Move Pet <html> <br><br>" + s;

          s = "<html>" + s + "<html>";
          s = s.replace("\n", "<br>");

          viewObj.addPlayerUp(s);
          renderView();
          break;
        case 4:
          objAction = new Attack("Comp");
          s = objAction.performAction(facadeObj);
          s = "<html> Computer Player Played Kill Target <html> <br><br>" + s;

          if (!s.contains(" not")) {
            viewObj.addPlayerUp(s);
          }
          renderView();
          viewObj.setTargetHealth(facadeObj.getTargetHealth());
          break;
          
        default:
          throw new IllegalArgumentException("Handlig Checkstyle");
      }
    }
    checkGameOver();
    if (facadeObj.computerPlayer()) {
      compMovement();
    }

  }

  /**
   * Setting up the key listeners.
   */
  private void configureKeyBoardListener() {
    Map<Character, Runnable> keyTypes = new HashMap<>();

    keyTypes.put('p', () -> {

      String itemName = viewObj.pickPopUp(facadeObj.getItemNames());
      objAction = new PickUpItem(itemName, randObj);
      String s = objAction.performAction(facadeObj);
      viewObj.addPlayerUp(s);

      renderView();
      compMovement();
    });

    keyTypes.put('k', () -> {

      String[] itemNames = facadeObj.getPlayerItemNames();
      String[] newItemNames = new String[itemNames.length + 1];
      newItemNames[0] = "Poke";
      for (int i = 0; i < itemNames.length; i++) {
        newItemNames[i + 1] = itemNames[i];
      }
      String itemName = viewObj.attackPopUp(newItemNames);
      objAction = new Attack(itemName);
      String s = objAction.performAction(facadeObj);
      viewObj.addPlayerUp(s);
      renderView();
      viewObj.setTargetHealth(facadeObj.getTargetHealth());
      // viewObj.repaint();
      compMovement();

    });

    keyTypes.put('l', () -> {

      objAction = new LookAround();
      String s = objAction.performAction(facadeObj);
      s = "<html>" + s + "<html>";
      s = s.replace("\n", "<br>");

      viewObj.lookAroundPopUp(s);

      renderView();

      compMovement();

    });

    keyTypes.put('m', () -> {

      String[] roomNames = facadeObj.getRoomNames();

      String roomName = viewObj.movePetPopUp(roomNames);

      objAction = new RelocatePet(roomName, randObj);
      String s = objAction.performAction(facadeObj);
      s = "<html>" + s + "<html>";
      s = s.replace("\n", "<br>");

      viewObj.addPlayerUp(s);
      renderView();
      compMovement();

    });

    KeyboardListener kbd = new KeyboardListener();
    kbd.setKeyTypedMap(keyTypes);

    this.viewObj.addKeyListenerInController(kbd);

  }

  /**
   * Setting up the button listeners.
   */
  private void configureButtonListener() {
    Map<String, Runnable> buttonClickedMap = new HashMap<>();

    buttonClickedMap.put("PlayGame", () -> {

      viewObj.setInitialRoom(facadeObj.getRoomNames());
      viewObj.makeVisible("addPlayer");
      viewObj.resetFocus();
    });

    buttonClickedMap.put("AddPlayerButton", () -> {
      String playerName = viewObj.getNameField();
      String roomName = viewObj.getInitialRoom();
      int maxItemPlayer = viewObj.getMaxItem();
      boolean isBot = viewObj.getPlayerType();
      // call this by map.
      objAction = new AddHumanPlayer(playerName, roomName, maxItemPlayer, isBot);
      String s = objAction.performAction(facadeObj);
      viewObj.makeVisible("game");
      viewObj.addPlayerUp(s);
      renderView();
      viewObj.setTargetLabel(facadeObj.getTargetName());
      viewObj.setTargetHealth(facadeObj.getTargetHealth());
      viewObj.resetFocus();

    });

    buttonClickedMap.put("AddPlayerBetween", () -> {
      viewObj.makeVisible("addPlayer");

      viewObj.resetFocus();
    });

    buttonClickedMap.put("ClearButton", () -> {
      viewObj.resetNameField();
      viewObj.resetMaxItem();
      viewObj.resetFocus();
      viewObj.disposeInController();
    });

    buttonClickedMap.put("FileChoose", () -> {
      viewObj.showFileChooser(this);
      viewObj.setInitialRoom(facadeObj.getRoomNames());
      viewObj.makeVisible("addPlayer");
      viewObj.resetFocus();

    });

    buttonClickedMap.put("ExistingFile", () -> {

      loadOtherFile(filePath);
      viewObj.makeVisible("welcome");

    });

    buttonClickedMap.put("PickPopUp", () -> {
      viewObj.makeVisible("addPlayer");
      viewObj.resetFocus();
    });

    buttonClickedMap.put("Exit", () -> {
      this.viewObj.disposeInController();
    });
    ButtonListener buttonListener = new ButtonListener();
    buttonListener.setButtonClickedActionMap(buttonClickedMap);
    this.viewObj.addActionListener(buttonListener);
  }

  /**
   * Setting up the mouse listener.
   */
  private void configureMouseListener() {
    this.viewObj.addMouseListener(this);

  }

  @Override
  public void movePlayerOnClick(int row, int col) {
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException("\nInvalid row or column value");
    }

    int[][] worldMat = facadeObj.getWorldMatrix();
    if (row < worldMat[0].length && col < worldMat.length) {
      String[] roomNames = facadeObj.getRoomNames();
      objAction = new Move(roomNames[worldMat[col][row]], randObj);
      String s = objAction.performAction(facadeObj);
      viewObj.addPlayerUp(s);

      renderView();
      compMovement();
    }

  }

  @Override
  public void loadOtherFile(String filePath) {
    if (filePath == null || filePath.isEmpty()) {
      throw new IllegalArgumentException("\nInvalid file");
    }

    try {
      Readable file = new FileReader(filePath);

      Director facade = new Director(file);

      World worldObj = facade.createWorld();

      IntermediateWorld facadeObjNew = new IntermediateWorldImplementation(worldObj);
      this.facadeObj = facadeObjNew;
      facadeObj.setMaxturn(maxTurn);
      viewObj.setUpFrame(facadeObj);

      this.addListeners();

    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Invalid file path");
    }
  }

  @Override
  public boolean checkIfPlayerPlotted(int row, int col) {
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException("\nInvalid row or column value");
    }
    if (facadeObj.checkIfPlayerPloted(row, col) == null) {
      return false;
    }
    return true;
  }

  @Override
  public void showPlayerInformation(int row, int col) {
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException("\nInvalid row or column value");
    }
    String playerInformation = facadeObj
        .getPlayerInformation(facadeObj.checkIfPlayerPloted(row, col));
    playerInformation = String.format("<html>%s<html>", playerInformation);
    playerInformation = playerInformation.replace("\n", "<br>");
    viewObj.playerDetailsPopUp(playerInformation);
    viewObj.resetFocus();
    viewObj.repaint();
  }

}

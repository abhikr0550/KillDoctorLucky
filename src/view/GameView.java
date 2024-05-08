package view;

import com.milestone2.controller.Features;
import facade.ReadOnlyIntermediateWorld;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * A java interface which represent the view of the game.
 * 
 * @author Abhishek & Valay
 *
 */
public interface GameView {

  /**
   * Make the view visible to start the game session.
   * 
   * @param panelName name of the panel to view.
   */
  void makeVisible(String panelName);

  /**
   * this is to force the view to have a method to set up actions for buttons. All
   * the buttons must be given this action listener
   *
   * Thus our Swing-based implementation of this interface will already have such
   * a method.
   * 
   * @param listener the listener to add
   */
  void addActionListener(ActionListener listener);

  /**
   * This is to force the view to have a method to set up actions for mouse. All
   * the mouse events must be given this mouse listener
   * 
   * @param mouseListener add mouse listener to the panel.
   */
  public void addMouseListener(Features mouseListener);

  /**
   * Setting up the frame.
   * 
   * @param facadeObj Facade object
   */
  public void setUpFrame(ReadOnlyIntermediateWorld facadeObj);

  /**
   * Get the add player panel.
   * 
   * @return the addPlayerPanel
   */
  public AddPlayerPanel getAddPlayerPanel();

  /**
   * Get the welcome panel.
   * 
   * @return the welcomePanel
   */
  public WelcomeScreenPanel getWelcomePanel();

  /**
   * Get the board panel.
   * 
   * @return the boardPanel
   */
  public BoardPanel getBoardPanel();

  /**
   * Add key listener to the view.
   * 
   * @param keyListener KeyListener object
   */
  public void addKeyListenerInController(KeyListener keyListener);

  /**
   * Dispose/close the view.
   */

  public void disposeInController();

  /**
   * Call to the view notification pop up.
   * 
   * @param msg Message to show
   */
  void addPlayerUp(String msg);

  /**
   * Call to the view's setCurrentPlayerLabel method.
   * 
   * @param currentPlayerInformation Text to which the current player label is to
   *                                 be updated
   */
  void setCurrentPlayerLabel(String currentPlayerInformation);

  /**
   * Call to the view's setStatsLabel method.
   * 
   * @param playerDetails Text to which the stats label is to be updated
   */
  void setStatsLabel(String playerDetails);

  /**
   * Call to the panel's resetFocus method.
   */
  void resetFocus();

  /**
   * Method to repaint i.e. re-render the view.
   */
  void repaint();

  /**
   * Call to the view's look around pop up method.
   * 
   * @param s Message to show
   */
  void lookAroundPopUp(String s);

  /**
   * Call to the view's setTargetHealth method.
   * 
   * @param targetHealth Health to which the target health progress bar is to be
   *                     updated
   */
  void setTargetHealth(int targetHealth);

  /**
   * Call to the view's pickPopUp method.
   * 
   * @param itemNames Items to populate in the pop up combo box
   * 
   * @return the item that is picked.
   */
  String pickPopUp(String[] itemNames);

  /**
   * Call to the view's movePetPopUp method.
   * 
   * @param roomNames Room names to populate in the pop up combo box
   * @return the roomPicked
   */
  String movePetPopUp(String[] roomNames);

  /**
   * Call to the view's setTargetLabel method.
   * 
   * @param targetName Text to which the target label is to be updated
   */
  void setTargetLabel(String targetName);

  /**
   * Call to the view's attackPopUp method.
   * 
   * @param newItemNames Items to populate in the pop up combo box
   * 
   * @return the item selected.
   */
  String attackPopUp(String[] newItemNames);

  /**
   * Call to the view's playerDetailsPopUp method.
   * 
   * @param playerInformation Message to show
   */
  void playerDetailsPopUp(String playerInformation);

  /**
   * Call to the view's setInitialRoom method.
   * 
   * @param roomNames Room names in the world.
   */
  void setInitialRoom(String[] roomNames);

  /**
   * Call to the view's resetNameField method.
   */
  void resetNameField();

  /**
   * Call to the view's resetMaxItem method.
   */
  void resetMaxItem();

  /**
   * Call to the view's getNameField method.
   * 
   * @return the nameField.
   */
  String getNameField();

  /**
   * Call to the view's getInitialRoom method.
   * 
   * @return the roomName.
   */
  String getInitialRoom();

  /**
   * Call to the view's getMaxItem method.
   * 
   * @return the max item
   */
  int getMaxItem();

  /**
   * Call to the view's getPlayerType method.
   * 
   * @return the player type
   */
  boolean getPlayerType();

  /**
   * Call to the view's showFileChooser method.
   * 
   * @param controllerImplementation Controller object
   */
  void showFileChooser(Features controllerImplementation);

}

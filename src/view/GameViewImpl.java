package view;

import com.milestone2.controller.Features;
import facade.ReadOnlyIntermediateWorld;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 
 * A concrete game view class which represents the view of the game.
 * 
 * @author Abhishek & Valay
 *
 */
public class GameViewImpl extends JFrame implements GameView {

  private static final long serialVersionUID = 1L;
  private AddPlayerPanel addPlayerPanel;
  private WelcomeScreenPanel welcomePanel;
  private BoardPanel boardPanel;
  private final CardLayout layout;
  private JMenuItem predefinedWorlds;
  private JMenuItem userDefinedWorld;
  private JMenuItem quit;

  /**
   * 
   * Initilises the view i.e. the frame of the game.
   * 
   */
  public GameViewImpl() {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setPreferredSize(new Dimension(500, 500));
    this.setMinimumSize(new Dimension(300, 300));
    layout = new CardLayout();
    this.setLayout(layout);

  }

  @Override
  public void setUpFrame(ReadOnlyIntermediateWorld facadeObj) {
    if (facadeObj == null) {
      throw new IllegalArgumentException("\nInvalid facade object");
    }

    // welcome panel

    predefinedWorlds = new JMenuItem("Predefined Worlds");
    predefinedWorlds.setActionCommand("ExistingFile");

    userDefinedWorld = new JMenuItem("Own World");
    userDefinedWorld.setActionCommand("FileChoose");
    quit = new JMenuItem("Quit");
    quit.setActionCommand("Exit");

    JMenu menu = new JMenu("Menu");
    menu.add(predefinedWorlds);
    menu.add(userDefinedWorld);
    menu.add(quit);
    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu);
    this.setJMenuBar(menuBar);

    welcomePanel = new WelcomeScreenPanel();

    addPlayerPanel = new AddPlayerPanel();
    boardPanel = new BoardPanel(facadeObj);

    this.add(addPlayerPanel, "addPlayer");
    this.add(welcomePanel, "welcome");

    this.add(boardPanel, "game");

    layout.show(this.getContentPane(), "game");
    this.pack();

    this.setVisible(true);

  }

  @Override
  public void makeVisible(String panelName) {
    if (panelName == null || panelName.isEmpty()) {
      throw new IllegalArgumentException("\nInvalid panel name");
    }

    layout.show(this.getContentPane(), panelName);
    this.setVisible(true);
  }

  @Override
  public void addActionListener(ActionListener actionListener) {
    if (actionListener == null) {
      throw new IllegalArgumentException("\nInvalid action listener");
    }
    welcomePanel.addActionListener(actionListener);
    addPlayerPanel.addActionListener(actionListener);
    boardPanel.addActionListener(actionListener);
    userDefinedWorld.addActionListener(actionListener);
    predefinedWorlds.addActionListener(actionListener);
    quit.addActionListener(actionListener);
  }

  @Override
  public void addKeyListenerInController(KeyListener keyListener) {
    if (keyListener == null) {
      throw new IllegalArgumentException("\nInvalid key listener");
    }
    boardPanel.addKeyListener(keyListener);
  }

  @Override
  public void addMouseListener(Features contObj) {
    if (contObj == null) {
      throw new IllegalArgumentException("\nInvalid features object");
    }
    boardPanel.addMouseListener(contObj);
  }

  @Override
  public AddPlayerPanel getAddPlayerPanel() {
    return addPlayerPanel;
  }

  @Override
  public WelcomeScreenPanel getWelcomePanel() {
    return welcomePanel;
  }

  @Override
  public BoardPanel getBoardPanel() {
    return boardPanel;
  }

  @Override
  public void disposeInController() {
    this.dispose();

  }

  @Override
  public void addPlayerUp(String msg) {
    
    if (msg == null) {
      throw new IllegalArgumentException("Parameter cannot be null.");
    }
    
    
    this.boardPanel.addPlayerUp(msg);

  }

  @Override
  public void setCurrentPlayerLabel(String currentPlayerInformation) {
    
    if (currentPlayerInformation == null) {
      throw new IllegalArgumentException("Parameter cannot be null.");
    }
    
    this.boardPanel.setCurrentPlayerLabel(currentPlayerInformation);

  }

  @Override
  public void setStatsLabel(String playerDetails) {
    
    if (playerDetails == null) {
      throw new IllegalArgumentException("Parameter cannot be null.");
    }

    this.boardPanel.setStatsLabel(playerDetails);

  }

  @Override
  public void resetFocus() {
    this.boardPanel.resetFocus();

  }

  @Override
  public void lookAroundPopUp(String s) {
    
    if (s == null) {
      throw new IllegalArgumentException("Parameter cannot be null.");
    }
    this.boardPanel.lookAroundPopUp(s);

  }

  @Override
  public void setTargetHealth(int targetHealth) {
    
    this.boardPanel.setTargetHealth(targetHealth);

  }

  @Override
  public String pickPopUp(String[] itemNames) {
    if (itemNames == null) {
      throw new IllegalArgumentException("Parameter cannot be null.");
    }

    return this.boardPanel.pickPopUp(itemNames);
  }

  @Override
  public String movePetPopUp(String[] roomNames) {
    
    if (roomNames == null) {
      throw new IllegalArgumentException("Parameter cannot be null.");
    }
    
    return this.boardPanel.movePetPopUp(roomNames);
  }

  @Override
  public void setTargetLabel(String targetName) {
    
    if (targetName == null) {
      throw new IllegalArgumentException("Parameter cannot be null.");
    }
    
    this.boardPanel.setTargetLabel(targetName);

  }

  @Override
  public String attackPopUp(String[] newItemNames) {
    
    if (newItemNames == null) {
      throw new IllegalArgumentException("Parameter cannot be null.");
    }
    
    return this.boardPanel.attackPopUp(newItemNames);
  }

  @Override
  public void playerDetailsPopUp(String playerInformation) {
    
    if (playerInformation == null) {
      throw new IllegalArgumentException("Parameter cannot be null.");
    }
    
    this.boardPanel.playerDetailsPopUp(playerInformation);
  }

  @Override
  public void setInitialRoom(String[] roomNames) {
    
    if (roomNames == null) {
      throw new IllegalArgumentException("Parameter cannot be null.");
    }
    
    this.addPlayerPanel.setInitialRoom(roomNames);

  }

  @Override
  public void resetNameField() {
    this.addPlayerPanel.resetNameField();

  }

  @Override
  public void resetMaxItem() {
    this.addPlayerPanel.resetMaxItem();

  }

  @Override
  public String getNameField() {
    return this.addPlayerPanel.getNameField();
  }

  @Override
  public String getInitialRoom() {
    
    return this.addPlayerPanel.getInitialRoom();
  }

  @Override
  public int getMaxItem() {
    
    return this.addPlayerPanel.getMaxItem();
  }

  @Override
  public boolean getPlayerType() {
    return this.addPlayerPanel.getPlayerType();
  }

  @Override
  public void showFileChooser(Features controllerImplementation) {
    
    if (controllerImplementation == null) {
      throw new IllegalArgumentException("Parameter cannot be null.");
    }
    
    this.welcomePanel.showFileChooser(controllerImplementation);
    
  }

}

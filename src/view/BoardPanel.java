package view;

import com.milestone2.controller.Features;
import com.milestone2.controller.MouseListener;
import facade.ReadOnlyIntermediateWorld;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

/**
 * 
 * JPanel for board panel screen.
 * 
 * @author Abhishek & Valay
 *
 */
public class BoardPanel extends JPanel {

  private static final long serialVersionUID = 1L;
  private final JLabel currentPlayerLabel;
  private final JLabel targetLabel;
  private final JProgressBar targetHealthProgressBar;
  private final JPanel map;
  private final JLabel statsLabel;
  private final JButton addPlayerButton;

  /**
   * 
   * Initializes all the components in the board panel screen.
   * 
   * @param facadeObj is the model object
   */
  public BoardPanel(ReadOnlyIntermediateWorld facadeObj) {
    super();
    if (facadeObj == null) {
      throw new IllegalArgumentException("Invalid model facade");
    }
    this.setLayout(new GridBagLayout());

    GridBagConstraints gameConstraints = new GridBagConstraints();
    gameConstraints.fill = GridBagConstraints.BOTH;

    gameConstraints.gridx = 0;
    gameConstraints.gridy = 0;
    gameConstraints.weighty = 0.01d;
    gameConstraints.weightx = 1d;
    JPanel target = new JPanel();
    target.setBackground(Color.decode("#93C572"));
    this.add(target, gameConstraints);

    target.setLayout(new GridBagLayout());
    GridBagConstraints targetPanelConstraints = new GridBagConstraints();
    targetPanelConstraints.insets = new Insets(5, 5, 5, 5);
    targetPanelConstraints.fill = GridBagConstraints.BOTH;

    currentPlayerLabel = new JLabel();
    targetPanelConstraints.gridx = 0;
    targetPanelConstraints.gridy = 0;
    targetPanelConstraints.weighty = 1d;
    targetPanelConstraints.weightx = 0.45d;
    currentPlayerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    target.add(currentPlayerLabel, targetPanelConstraints);

    targetLabel = new JLabel();
    targetPanelConstraints.insets = new Insets(5, 15, 5, 0);
    targetPanelConstraints.gridx = 1;
    targetPanelConstraints.gridy = 0;
    targetPanelConstraints.weighty = 1d;
    targetPanelConstraints.weightx = 0.35d;
    targetLabel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
    target.add(targetLabel, targetPanelConstraints);

    JLabel healthLabel = new JLabel();
    healthLabel.setText("Health: ");
    healthLabel.setHorizontalAlignment(JLabel.RIGHT);
    targetPanelConstraints.insets = new Insets(5, 0, 5, 0);
    targetPanelConstraints.gridx = 2;
    targetPanelConstraints.gridy = 0;
    targetPanelConstraints.weighty = 1d;
    targetPanelConstraints.weightx = 0.10d;
    healthLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
    target.add(healthLabel, targetPanelConstraints);

    targetHealthProgressBar = new JProgressBar();
    targetHealthProgressBar.setForeground(Color.RED);
    targetHealthProgressBar.setMaximum(facadeObj.getTargetHealth());
    targetHealthProgressBar.setMinimum(0);
    targetHealthProgressBar.setString("Health");
    targetHealthProgressBar.setStringPainted(true);
    targetPanelConstraints.insets = new Insets(5, 0, 5, 5);
    targetPanelConstraints.gridx = 3;
    targetPanelConstraints.gridy = 0;
    targetPanelConstraints.weighty = 1d;
    targetPanelConstraints.weightx = 0.20d;
    targetHealthProgressBar.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
    target.add(targetHealthProgressBar, targetPanelConstraints);

    gameConstraints.gridx = 0;
    gameConstraints.gridy = 1;
    gameConstraints.weighty = 0.80d;
    gameConstraints.weightx = 1d;

    class Map extends JPanel {
      private static final long serialVersionUID = 1L;

      /**
       * Inner class which represents a map.
       */
      public Map() {
        this.setBackground(Color.decode("#B6D0E2"));
        this.setPreferredSize(new Dimension(1000, 1000));
      }

      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        facadeObj.drawMap(g);
      }
    }

    map = new Map();
    map.setName("PlayZone");
    JScrollPane scrollpane1 = new JScrollPane();
    scrollpane1.setViewportView(map);

    this.add(scrollpane1, gameConstraints);

    gameConstraints.gridx = 0;
    gameConstraints.gridy = 2;
    gameConstraints.weighty = 0.15d;
    gameConstraints.weightx = 1d;

    JPanel stats = new JPanel();
    stats.setBackground(Color.decode("#E34234"));
    JScrollPane scrollpane2 = new JScrollPane();

    scrollpane2.setViewportView(stats);

    this.add(scrollpane2, gameConstraints);

    stats.setLayout(new BorderLayout());
    stats.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    statsLabel = new JLabel();
    statsLabel.setBorder(
        BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 1),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    statsLabel.setForeground(Color.WHITE);
    stats.add(statsLabel);

    gameConstraints.gridx = 0;
    gameConstraints.gridy = 3;
    gameConstraints.weighty = 0.04d;
    gameConstraints.weightx = 1d;
    JPanel hint = new JPanel();

    hint.setBackground(Color.decode("#CECECE"));
    this.add(hint, gameConstraints);

    hint.setLayout(new GridBagLayout());
    GridBagConstraints hintPanelConstraints = new GridBagConstraints();
    hintPanelConstraints.insets = new Insets(5, 5, 5, 5);
    hintPanelConstraints.fill = GridBagConstraints.BOTH;

    hintPanelConstraints.gridx = 0;
    hintPanelConstraints.gridy = 0;
    hintPanelConstraints.weighty = 1d;
    hintPanelConstraints.weightx = 0.93d;

    JLabel hintLabel = new JLabel();
    hintLabel.setText("<html>Instrictions:<br>Click Player : Player "
        + "description | Click room : Move Player | Press 'p' : Pick Item | "
        + "Press 'l' : Look Around | Press 'm' : Move Pet | Press 'k' : Kill target</html>");
    hintLabel.setBorder(
        BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 1),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    JScrollPane scrollpane3 = new JScrollPane();
    scrollpane3.setViewportView(hintLabel);

    hint.add(scrollpane3, hintPanelConstraints);

    addPlayerButton = new JButton("Add Player");
    addPlayerButton.setActionCommand("AddPlayerBetween");

    addPlayerButton.setFocusable(false);
    hintPanelConstraints.gridx = 1;
    hintPanelConstraints.gridy = 0;
    hintPanelConstraints.weighty = 1d;
    hintPanelConstraints.weightx = 0.07d;
    hint.add(addPlayerButton, hintPanelConstraints);

  }

  /**
   * Add player pop up set up.
   * 
   * @param text Message to show
   */
  public void addPlayerUp(String text) {
    if (text == null || text.isEmpty()) {
      throw new IllegalArgumentException("\nInvalid text input");
    }

    final JComponent[] inputs = new JComponent[] { new JLabel(text) };
    String[] options = new String[] { "OK" };
    JOptionPane.showOptionDialog(this, inputs, "Result", JOptionPane.OK_OPTION,
        JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
  }

  /**
   * Player Details pop up set up.
   * 
   * @param text Message to show
   */
  public void playerDetailsPopUp(String text) {
    if (text == null || text.isEmpty()) {
      throw new IllegalArgumentException("\nInvalid text input");
    }
    final JComponent[] inputs = new JComponent[] { new JLabel(text) };
    String[] options = new String[] { "OK" };
    JOptionPane.showOptionDialog(this, inputs, "Player details", JOptionPane.OK_OPTION,
        JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
  }

  /**
   * Move player pop up set up.
   */
  public void movePopUp() {

    final JComponent[] inputs = new JComponent[] { new JLabel("Do you want to move the player?") };
    String[] options = new String[] { "OK", "Cancel" };
    JOptionPane.showOptionDialog(this, inputs, "Move player", JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
  }

  /**
   * Pick up item pop up set up.
   * 
   * @param itemNames Items to populate in the pop up combo box
   * 
   * @return the item that is picked.
   */
  public String pickPopUp(String[] itemNames) {
    if (itemNames == null) {
      throw new IllegalArgumentException("\nInvalid item names input");
    }

    if (itemNames.length == 0) {
      itemNames = new String[1];
      itemNames[0] = "";
    }
    Object selectedItem = JOptionPane.showInputDialog(this, "Select the item you want to pick",
        "Pick Item", JOptionPane.PLAIN_MESSAGE, null, itemNames, itemNames[0]);

    return selectedItem.toString();
  }

  /**
   * Look Around pop up set up.
   * 
   * @param text Message to show
   */
  public void lookAroundPopUp(String text) {
    if (text == null || text.isEmpty()) {
      throw new IllegalArgumentException("\nInvalid text input");
    }

    final JComponent[] inputs = new JComponent[] { new JLabel(text) };
    String[] options = new String[] { "OK" };
    JOptionPane.showOptionDialog(this, inputs, "Look Around", JOptionPane.OK_OPTION,
        JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
  }

  /**
   * Pick up item pop up set up.
   * 
   * @param roomNames Room names to populate in the pop up combo box
   * @return the roomPicked.
   */
  public String movePetPopUp(String[] roomNames) {
    if (roomNames == null) {
      throw new IllegalArgumentException("\nInvalid room names input");
    }

    if (roomNames.length == 0) {
      roomNames = new String[1];
      roomNames[0] = "";
    }

    Object selectedItem = JOptionPane.showInputDialog(this,
        "Select the Room you want to move the pet to:", "Move Pet", JOptionPane.PLAIN_MESSAGE, null,
        roomNames, roomNames[0]);

    return selectedItem.toString();

  }

  /**
   * Attack target pop up set up.
   * 
   * @param itemNames Items to populate in the pop up combo box
   * 
   * @return the item picked.
   */
  public String attackPopUp(String[] itemNames) {
    if (itemNames == null) {
      throw new IllegalArgumentException("\nInvalid item names input");
    }

    Object selectedItem = JOptionPane.showInputDialog(this, "Select the item to Atttack the target",
        "Attack", JOptionPane.PLAIN_MESSAGE, null, itemNames, itemNames[0]);
    return selectedItem.toString();
  }

  /**
   * Game Over pop up set up.
   */
  public void gameOverPopUp() {
    String gameStatus = "Game Over!";
    final JComponent[] inputs = new JComponent[] { new JLabel(gameStatus) };
    String[] options = new String[] { "OK", "Cancel" };
    JOptionPane.showOptionDialog(this, inputs, "Game Over", JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
  }

  /**
   * Set current player label text to input text.
   * 
   * @param text Text to which the current player label is to be updated
   */
  public void setCurrentPlayerLabel(String text) {
    if (text == null || text.isEmpty()) {
      throw new IllegalArgumentException("\nInvalid text input");
    }
    currentPlayerLabel.setText(text);
  }

  /**
   * Set stats label text to input text.
   * 
   * @param text Text to which the stats label is to be updated
   */
  public void setStatsLabel(String text) {
    if (text == null || text.isEmpty()) {
      throw new IllegalArgumentException("\nInvalid text input");
    }
    statsLabel.setText(text);
  }

  /**
   * Set target label text to input text.
   * 
   * @param text Text to which the target label is to be updated
   */
  public void setTargetLabel(String text) {
    if (text == null || text.isEmpty()) {
      throw new IllegalArgumentException("\nInvalid text input");
    }
    targetLabel.setText(String.format("Target: %s", text));
  }

  /**
   * Set target health progress bar to input health.
   * 
   * @param health Health to which the target health progress bar is to be updated
   */
  public void setTargetHealth(int health) {
    targetHealthProgressBar.setValue(health);
    targetHealthProgressBar.setString(String.valueOf(health));
  }

  /**
   * Adding listeners to the buttons on the current panel.
   * 
   * @param actionListener ButtonListener object
   */
  public void addActionListener(ActionListener actionListener) {
    if (actionListener == null) {
      throw new IllegalArgumentException("\nInvalid action listener");
    }
    addPlayerButton.addActionListener(actionListener);
  }

  /**
   * Adding mouse listener to the current panel.
   * 
   * @param contObj Controller object
   */
  public void addMouseListener(Features contObj) {
    if (contObj == null) {
      throw new IllegalArgumentException("\nInvalid controller object");
    }

    MouseListener mouseListener = new MouseListener(contObj);

    map.addMouseListener(mouseListener);

  }

  /**
   * Reset the focus on current panel.
   */
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }

}

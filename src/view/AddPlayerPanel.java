package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 * JPanel for add player screen.
 * 
 * @author Abhishek & Valay
 *
 */
public class AddPlayerPanel extends JPanel {

  private static final long serialVersionUID = 1L;
  private final JTextField nameField;
  private final JComboBox<String> initialRoomComboBox;
  private final JButton addPlayerButton;
  private final JButton clearButton;
  private final ButtonGroup playerTypeGroup;
  private final JSlider maxItemsSlider;

  /**
   * Initializes all the components in the add player screen.
   */
  public AddPlayerPanel() {
    super();
    this.setLayout(new GridBagLayout());
    GridBagConstraints addPlayerConstraints = new GridBagConstraints();
    addPlayerConstraints.insets = new Insets(5, 5, 5, 5);

    JLabel titleLabel = new JLabel();
    titleLabel.setText("Add Player");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    addPlayerConstraints.gridx = 0;
    addPlayerConstraints.gridy = 0;
    addPlayerConstraints.gridwidth = 2;
    addPlayerConstraints.fill = GridBagConstraints.HORIZONTAL;
    this.add(titleLabel, addPlayerConstraints);

    addPlayerConstraints = new GridBagConstraints();
    addPlayerConstraints.insets = new Insets(5, 5, 5, 5);

    JLabel nameLabel = new JLabel();
    nameLabel.setText("Name:");
    addPlayerConstraints.anchor = GridBagConstraints.EAST;
    addPlayerConstraints.gridx = 0;
    addPlayerConstraints.gridy = 1;
    this.add(nameLabel, addPlayerConstraints);

    nameField = new JTextField(21);
    nameField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    nameLabel.setLabelFor(nameField);
    addPlayerConstraints.anchor = GridBagConstraints.WEST;
    addPlayerConstraints.gridx = 1;
    addPlayerConstraints.gridy = 1;
    this.add(nameField, addPlayerConstraints);

    JLabel initialRoomLabel = new JLabel();
    initialRoomLabel.setText("Initial Room:");
    addPlayerConstraints.anchor = GridBagConstraints.EAST;
    addPlayerConstraints.gridx = 0;
    addPlayerConstraints.gridy = 2;
    this.add(initialRoomLabel, addPlayerConstraints);

    String[] rooms = { "Armory", "Kitchen", "Dining Hall" };
    initialRoomComboBox = new JComboBox<>(rooms);
    initialRoomLabel.setLabelFor(initialRoomComboBox);
    addPlayerConstraints.anchor = GridBagConstraints.WEST;
    addPlayerConstraints.gridx = 1;
    addPlayerConstraints.gridy = 2;
    this.add(initialRoomComboBox, addPlayerConstraints);

    JLabel maxItemsLabel = new JLabel();
    maxItemsLabel.setText("Maximum Items:");
    addPlayerConstraints.anchor = GridBagConstraints.EAST;
    addPlayerConstraints.gridx = 0;
    addPlayerConstraints.gridy = 3;
    this.add(maxItemsLabel, addPlayerConstraints);

    maxItemsSlider = new JSlider(0, 20, 1);
    maxItemsSlider.setPreferredSize(new Dimension(300, 60));
    maxItemsSlider.setPaintTicks(true);
    maxItemsSlider.setMajorTickSpacing(2);
    maxItemsSlider.setPaintLabels(true);
    maxItemsLabel.setLabelFor(maxItemsSlider);

    addPlayerConstraints.anchor = GridBagConstraints.WEST;
    addPlayerConstraints.gridx = 1;
    addPlayerConstraints.gridy = 3;
    this.add(maxItemsSlider, addPlayerConstraints);

    JLabel playerTypeLabel = new JLabel();
    playerTypeLabel.setText("Player Type:");
    addPlayerConstraints.anchor = GridBagConstraints.EAST;
    addPlayerConstraints.gridx = 0;
    addPlayerConstraints.gridy = 4;
    this.add(playerTypeLabel, addPlayerConstraints);

    JRadioButton computerPlayerButton = new JRadioButton("Computer");
    computerPlayerButton.setActionCommand("Computer");

    addPlayerConstraints.insets = new Insets(5, 5, 0, 5);
    addPlayerConstraints.anchor = GridBagConstraints.WEST;
    addPlayerConstraints.gridx = 1;
    addPlayerConstraints.gridy = 4;
    this.add(computerPlayerButton, addPlayerConstraints);

    JRadioButton humanPlayerButton = new JRadioButton("Human");
    humanPlayerButton.setActionCommand("Human");

    addPlayerConstraints.insets = new Insets(0, 5, 5, 5);
    addPlayerConstraints.anchor = GridBagConstraints.WEST;
    addPlayerConstraints.gridx = 1;
    addPlayerConstraints.gridy = 5;
    this.add(humanPlayerButton, addPlayerConstraints);

    playerTypeGroup = new ButtonGroup();
    playerTypeGroup.add(computerPlayerButton);
    playerTypeGroup.add(humanPlayerButton);

    addPlayerButton = new JButton("Add");
    addPlayerButton.setActionCommand("AddPlayerButton");

    addPlayerConstraints.anchor = GridBagConstraints.EAST;
    addPlayerConstraints.gridx = 0;
    addPlayerConstraints.gridy = 6;
    this.add(addPlayerButton, addPlayerConstraints);

    clearButton = new JButton("Clear");
    clearButton.setActionCommand("ClearButton");
    addPlayerConstraints.anchor = GridBagConstraints.WEST;
    addPlayerConstraints.gridx = 1;
    addPlayerConstraints.gridy = 6;
    this.add(clearButton, addPlayerConstraints);
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
    clearButton.addActionListener(actionListener);

  }

  /**
   * return the name of the player entered in the text field.
   * 
   * @return the nameField.
   */
  public String getNameField() {
    return nameField.getText();
  }

  /**
   * return the roomName of the player entered in the text field.
   * 
   * @return the roomName.
   */
  public String getInitialRoom() {

    return initialRoomComboBox.getSelectedItem().toString();
  }

  /**
   * Updating the combo box values based on the world rooms.
   * 
   * @param roomNames Room names in the world.
   */
  public void setInitialRoom(String[] roomNames) {

    if (roomNames == null) {
      throw new IllegalArgumentException("\nInvalid room names input");
    }

    initialRoomComboBox.removeAllItems();
    for (int i = 0; i < roomNames.length; i++) {
      initialRoomComboBox.addItem(roomNames[i]);
    }
  }

  /**
   * return the roomName of the player entered in the text field.
   * 
   * @return the roomName.
   */
  public boolean getPlayerType() {

    if ("Human".equals(playerTypeGroup.getSelection().getActionCommand())) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * return the type of the maxItem that a player can carry entered in the slider.
   * 
   * @return the max item.
   */
  public int getMaxItem() {

    return maxItemsSlider.getValue();
  }

  /**
   * Set the slider's value to zero (clear).
   */
  public void resetMaxItem() {
    maxItemsSlider.setValue(0);
  }

  /**
   * Clear the name field text.
   */
  public void resetNameField() {
    nameField.setText("");
  }

}

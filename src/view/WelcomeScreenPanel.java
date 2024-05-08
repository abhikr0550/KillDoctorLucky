package view;

import com.milestone2.controller.Features;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * JPanel for welcome screen.
 * 
 * @author Abhishek & Valay
 *
 */
public class WelcomeScreenPanel extends JPanel {

  private static final long serialVersionUID = 1L;
  private final JLabel welcomeLabel;
  private final JComboBox<?> worldNameComboBox;
  private final JButton playButton;
  private final JLabel creditsLabel;

  /**
   * 
   * Initializes all the components in the welcome screen.
   * 
   */
  public WelcomeScreenPanel() {
    super();
    this.setLayout(new GridBagLayout());
    GridBagConstraints welcomePanelConstraints = new GridBagConstraints();
    welcomePanelConstraints.insets = new Insets(5, 5, 5, 5);

    welcomeLabel = new JLabel();
    welcomeLabel.setText("Welcome to the Game!");
    welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
    welcomePanelConstraints.gridx = 0;
    welcomePanelConstraints.gridy = 0;
    welcomePanelConstraints.gridwidth = 2;
    welcomePanelConstraints.fill = GridBagConstraints.HORIZONTAL;
    welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
    this.add(welcomeLabel, welcomePanelConstraints);

    welcomePanelConstraints = new GridBagConstraints();
    welcomePanelConstraints.insets = new Insets(5, 5, 5, 5);

    String[] worldNames = { "Doctor Lucky", "Naruto", "Game of Thrones" };
    worldNameComboBox = new JComboBox<String>(worldNames);
    welcomePanelConstraints.gridx = 0;
    welcomePanelConstraints.gridy = 1;
    this.add(worldNameComboBox, welcomePanelConstraints);

    playButton = new JButton("Play");
    playButton.setActionCommand("PlayGame");

    welcomePanelConstraints.gridx = 1;
    welcomePanelConstraints.gridy = 1;
    this.add(playButton, welcomePanelConstraints);

    creditsLabel = new JLabel();

    creditsLabel.setText("<html>Credits:<br>Abhishek Kumar<br>Valay Gundecha</html>");
    welcomePanelConstraints.insets = new Insets(40, 5, 5, 5);
    welcomePanelConstraints.gridx = 1;
    welcomePanelConstraints.gridy = 2;
    this.add(creditsLabel, welcomePanelConstraints);

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
    playButton.addActionListener(actionListener);
  }

  /**
   * Display the file chooser option.
   * 
   * @param control Controller object
   */
  public void showFileChooser(Features control) {
    if (control == null) {
      throw new IllegalArgumentException("\nInvalid features object");
    }
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.showOpenDialog(null);
    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
    control.loadOtherFile(filePath);

  }

}

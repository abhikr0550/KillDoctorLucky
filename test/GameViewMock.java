import com.milestone2.controller.Features;
import facade.ReadOnlyIntermediateWorld;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import view.AddPlayerPanel;
import view.BoardPanel;
import view.GameView;
import view.WelcomeScreenPanel;

/**
 * Mock class for the GameView interface.
 * 
 * @author Abhishek & Valay
 *
 */
public class GameViewMock implements GameView {

  private StringBuilder out;
  private String uniqueKey;

  /**
   * Initialize StringBuilder object.
   * 
   * @param out StringBuilder object.
   * @param key is the secret key. 
   */
  public GameViewMock(StringBuilder out, String key) {
    if (out == null || key == null || key.isBlank()) {
      throw new IllegalArgumentException(
          "Invalid StringBuilder object or unique key in GameViewMock");
    }
    this.out = out;
    this.uniqueKey = key;
  }

  @Override
  public void makeVisible(String panelName) {
    if (panelName == null || panelName.isEmpty()) {
      throw new IllegalArgumentException("Invalid panel name in GameViewMock");
    }
    out.append(
        String.format("makeVisible method in view called with values : %s and unique key is %s\n",
            panelName, uniqueKey));
  }

  @Override
  public void addActionListener(ActionListener listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Invalid action listener in GameViewMock");
    }
    out.append(
        String.format("addActionListener method in view called and unique key is %s\n", uniqueKey));
  }

  @Override
  public void addMouseListener(Features mouseListener) {
    if (mouseListener == null) {
      throw new IllegalArgumentException("Invalid controller object in GameViewMock");
    }
    out.append(
        String.format("addMouseListener method in view called and unique key is %s\n", uniqueKey));
  }

  @Override
  public AddPlayerPanel getAddPlayerPanel() {
    out.append(
        String.format("addMouseListener method in view called and unique key is %s\n", uniqueKey));
    return new AddPlayerPanel();
  }

  @Override
  public WelcomeScreenPanel getWelcomePanel() {
    out.append(
        String.format("getWelcomePanel method in view called and unique key is %s\n", uniqueKey));
    return new WelcomeScreenPanel();
  }

  @Override
  public BoardPanel getBoardPanel() {
    out.append(
        String.format("getBoardPanel method in view called and unique key is %s\n", uniqueKey));
    return new BoardPanel(new IntermediateMockWorldImplemenation(out, uniqueKey));
  }

  @Override
  public void setUpFrame(ReadOnlyIntermediateWorld facadeObj) {
    if (facadeObj == null) {
      throw new IllegalArgumentException("Invalid facade object in GameViewMock");
    }
    out.append(String.format("setUpFrame method in view called and unique key is %s\n", uniqueKey));
  }

  @Override
  public void addKeyListenerInController(KeyListener keyListener) {
    if (keyListener == null) {
      throw new IllegalArgumentException("Invalid key listener in GameViewMock");
    }
    out.append(String.format(
        "addKeyListenerInController method in view called and unique key is %s\n", uniqueKey));
  }

  @Override
  public void disposeInController() {
    out.append(String.format("disposeInController method in view called and unique key is %s\n",
        uniqueKey));
  }

  @Override
  public void addPlayerUp(String msg) {
    out.append(String.format("addPlayerUp method in view called and unique key is %s\n",
        uniqueKey));
    
  }

  @Override
  public void setCurrentPlayerLabel(String currentPlayerInformation) {
    out.append(String.format("setCurrentPlayerLabel method in view called and unique key is %s\n",
        uniqueKey));
    
  }

  @Override
  public void setStatsLabel(String playerDetails) {
    out.append(String.format("setStatsLabel method in view called and unique key is %s\n",
        uniqueKey));
    
  }

  @Override
  public void resetFocus() {
    out.append(String.format("resetFocus method in view called and unique key is %s\n",
        uniqueKey));
    
  }

  @Override
  public void repaint() {
    out.append(String.format("repaint method in view called and unique key is %s\n",
        uniqueKey));
    
  }

  @Override
  public void lookAroundPopUp(String s) {
    out.append(String.format("lookAroundPopUp method in view called and unique key is %s\n",
        uniqueKey));
    
  }

  @Override
  public void setTargetHealth(int targetHealth) {
    out.append(String.format("setTargetHealth method in view called and unique key is %s\n",
        uniqueKey));
    
  }

  @Override
  public String pickPopUp(String[] itemNames) {
    out.append(String.format("pickPopUp method in view called and unique key is %s\n",
        uniqueKey));
    return "";
  }

  @Override
  public String movePetPopUp(String[] roomNames) {
    out.append(String.format("movePetPopUp method in view called and unique key is %s\n",
        uniqueKey));
    return "";
  }

  @Override
  public void setTargetLabel(String targetName) {
    out.append(String.format("setTargetLabel method in view called and unique key is %s\n",
        uniqueKey));
    
  }

  @Override
  public String attackPopUp(String[] newItemNames) {
    out.append(String.format("attackPopUp method in view called and unique key is %s\n",
        uniqueKey));
    return "";
  }

  @Override
  public void playerDetailsPopUp(String playerInformation) {
    out.append(String.format("playerDetailsPopUp method in view called and unique key is %s\n",
        uniqueKey));
  }

  @Override
  public void setInitialRoom(String[] roomNames) {
    out.append(String.format("setInitialRoom method in view called and unique key is %s\n",
        uniqueKey));
    
  }

  @Override
  public void resetNameField() {
    out.append(String.format("resetNameField method in view called and unique key is %s\n",
        uniqueKey));
    
  }

  @Override
  public void resetMaxItem() {
    out.append(String.format("resetMaxItem method in view called and unique key is %s\n",
        uniqueKey));
    
  }

  @Override
  public String getNameField() {
    out.append(String.format("getNameField method in view called and unique key is %s\n",
        uniqueKey));
    return "";
  }

  @Override
  public String getInitialRoom() {
    out.append(String.format("getInitialRoom method in view called and unique key is %s\n",
        uniqueKey));
    return "";
  }

  @Override
  public int getMaxItem() {
    out.append(String.format("getMaxItem method in view called and unique key is %s\n",
        uniqueKey));
    return 4;
  }

  @Override
  public boolean getPlayerType() {
    out.append(String.format("getPlayerType method in view called and unique key is %s\n",
        uniqueKey));
    return false;
  }

  @Override
  public void showFileChooser(Features controllerImplementation) {
    out.append(String.format("showFileChooser method in view called and unique key is %s\n",
        uniqueKey));
    
  }

}

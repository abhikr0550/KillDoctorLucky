package world;

/**
 * A class to store the details of the Target and perform its functionalities.
 * 
 */
public class Target {

  private final String targetName;
  private int health;
  private int location;

  /**
   * Initialises the TARGET for the item.
   * 
   * @param targetName : name of the target.
   * @param health     : health of the target.
   * @throws IllegalArgumentException : exception for Illegal Values.
   */
  public Target(String targetName, int health) throws IllegalArgumentException {

    if ("".equals(targetName) || targetName == null) {
      throw new IllegalArgumentException("Invalid Name. name cannot be empty");
    }
    if (health <= 0) {
      throw new IllegalArgumentException("Initial health of the target cannot be 0 or negative");
    }
    this.location = 0;

    this.targetName = targetName;
    this.health = health;

  }

  /**
   * returns the current location.
   * 
   * @return the location
   */
  public int getLocation() {
    return location;
  }

  /**
   * Moves the position of target to the next Index.
   * 
   * @param roomEndIndex : whether list of rooms has ended or not.
   * @return the index of current location.
   */
  public int move(boolean roomEndIndex) {
    if (roomEndIndex == true) {
      this.location = 0;

    } else {
      this.location = this.getLocation() + 1;
    }

    return this.location;
  }

  /**
   * This method is called when there is a successful attempt on the target. It
   * reduced the heath of the target according to the weapon used to attack.
   * 
   * @param val is the hit value of the item. Health of the target will be reduced
   *            by val,
   * @return the index of current location.
   */
  public int attack(int val) {
    if (val <= 0) {
      throw new IllegalArgumentException("Invalid attack.");
    }
    if (val > 0) {
      this.health = this.health - val;
    }

    return this.health;
  }

  /**
   * The target has a member data called health. This method returns the current
   * health of the target.
   * 
   * @return the current health of the target.
   */
  public String getName() {

    return this.targetName;
  }

  /**
   * The target has a member data called health. This method returns the current
   * health of the target.
   * 
   * @return the current health of the target.
   */
  public int getHealth() {

    return this.health;
  }

  @Override
  public String toString() {
    return String.format("Target [targetName=" + targetName + ", health=" + health + "]");
  }

}

package world;

/**
 * Item or weapon is an object which is present inside room or being carried by
 * any player. It has a name and certain power of it represented as value..
 */
public interface Item {

  /**
   * Its returns the name of the item.
   * 
   * @return name of the item.
   */
  public String getName();

  /**
   * Its returns the value of the item.
   * 
   * @return the value of the item.
   */
  public int getValue();

}

package world;

import java.util.Objects;

/**
 * Item or weapon is an object which is present inside room or being carried by
 * any player. It has a name and certain power of it represented as value..
 */
public class ItemImplementation implements Item {

  private final String itemName;
  private final int value;

  /**
   * Initialises the object for the item.
   * 
   * @param itemName : stores item name.
   * @param value    : stores item value.
   * @throws IllegalArgumentException : exception for Illegal Values.
   */
  public ItemImplementation(String itemName, int value) throws IllegalArgumentException {
    if ("".equals(itemName) || itemName == null) {
      throw new IllegalArgumentException("Invalid Name. name cannot be empty.");
    }

    if (value <= 0) {
      throw new IllegalArgumentException("Value of the item cannot be negative or 0.");
    }
    this.itemName = itemName;
    this.value = value;
  }

  @Override
  public String getName() {

    return this.itemName;
  }

  @Override
  public int getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    return String.format("(ItemName=" + itemName + ", value=" + value + ")");
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemName, value);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof ItemImplementation)) {
      return false;
    }
    ItemImplementation other = (ItemImplementation) obj;

    return Objects.equals(itemName, other.itemName) && (value == other.value);
  }

}

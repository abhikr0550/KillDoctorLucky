package driver;

/**
 * It generates a random set of integer in order to move the computer player
 * randomly.
 * 
 * @author Abhishek & Valay
 *
 */
public interface MyRandomInterface {

  /**
   * Its take the of the random number to be generated and generates a single
   * random integer.
   * 
   * @param limit the maximum value of random.
   * @return the generated integer.
   */
  public int getRandomValue(int limit);

}

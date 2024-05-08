package driver;

import java.util.Random;

/**
 * It generates a random set of integer in order to move the computer player
 * randomly.
 * 
 * @author Abhishek & Valay
 *
 */
public class MyRandom implements MyRandomInterface {

  private Random random;
  private boolean testRandom;
  private int loc;
  private int[] ar;

  /**
   * To get the random number while playing the game.
   */
  public MyRandom() {
    this.random = new Random();
    this.testRandom = false;
    this.loc = -1;
    this.ar = null;
  }

  /**
   * To get the predicted random number while playing the game.
   * 
   * @param randomList list of predicted random value.
   */
  public MyRandom(int... randomList) {
    if (randomList != null) {

      this.loc = 0;
      this.random = null;
      this.testRandom = true;
      this.ar = randomList.clone();
    }

  }

  @Override
  public int getRandomValue(int limit) {
    int val = 0;
    if (testRandom) {
      if (this.loc < this.ar.length) {
        val = ar[loc];
        this.loc++;
      } else {
        this.loc = 0;
        val = ar[loc];
        loc++;
      }

    } else {
      val = random.nextInt(limit);
    }
    return val;

  }

}

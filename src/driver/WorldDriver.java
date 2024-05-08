package driver;

import com.milestone2.controller.ControllerImplementation;
import facade.Director;
import facade.IntermediateWorld;
import facade.IntermediateWorldImplementation;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import view.GameViewImpl;
import world.World;

/**
 * Retrieves the file and passes to the parser.
 *
 * @author Abhishek & Valay
 */
public class WorldDriver {

  /**
   * Beginning of Execution of the board game.
   * 
   * @param args : Command line argument to store the input file.
   * @throws IOException : Throws exception.
   */
  public static void main(String[] args) {

    try {
      if (args.length == 0) {
        throw new IllegalArgumentException("Please Enter File path in command Line!!");
      } else if (args.length == 1) {
        throw new IllegalArgumentException("Please Enter maximum number of turns!!");
      }
      String fileName = args[0];
      int maxTurns = Integer.parseInt(args[1]);
      String absolutePath = System.getProperty("user.dir");
      String osSeparator = System.getProperty("file.separator");
      String completeFilePath = absolutePath + osSeparator + fileName;

      Readable file = new FileReader(completeFilePath);
      Director facade = new Director(file);

      World worldObj = facade.createWorld();

      IntermediateWorld facadeObj = new IntermediateWorldImplementation(worldObj);
      facadeObj.setMaxturn(maxTurns);
      MyRandomInterface rand = new MyRandom();

      GameViewImpl viewObj = new GameViewImpl();

      new ControllerImplementation(facadeObj, viewObj, maxTurns, rand, completeFilePath).playGame();

    } catch (IllegalArgumentException iae) {
      System.out.println(iae);
    } catch (FileNotFoundException fnf) {
      System.out.println("Unable to locate the file.");
    } catch (InputMismatchException inputmismatch) {
      System.out.println("The File does not have a proper format of input!!");
    }

  }

}

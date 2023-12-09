import model.ShapeAlbum;
import model.Snapshot;
import utility.CommandFileReader;
import view.GraphicalView;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhotoAlbumMain {
  public static void main(String[] args) {
    // Initiating mandatory parameters
    String inputFileName = null;
    String viewTypeName = null;

    // Default values for optional parameters
    String outputFileName = null;
    int viewWidth = 1000; // Default width
    int viewHeight = 1000; // Default height


    // check if th command-line arguments are provided
    if (args.length < 4) {
      // initiating a scanner, asking for users' input, reads input
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the command-line arguments: \n");
      String commandLine  = scan.nextLine();
      String[] commandArgs = commandLine.split(" ");


      // parsing the commandArgs
      for (int i = 0; i < commandArgs.length; i++) {
        switch (commandArgs[i]) {
          case "-in":
            inputFileName = commandArgs[++i];
            break;
          case "-view":
          case "-v":
            viewTypeName = commandArgs[++i];
            break;
          case "-out":
            outputFileName = commandArgs[++i];
            break;

        }
      }

      scan.close();
    }

    System.out.println("inputFileName");

    System.out.println(inputFileName);


    // Check if mandatory parameters are provided
    if (inputFileName == null || viewTypeName == null) {
      System.err.println("Missing required arguments: -in and -view");
      return;
    }



    // Initialize the model (ShapeAlbum) and view
    ShapeAlbum album = new ShapeAlbum();
    CommandFileReader reader = new CommandFileReader(inputFileName, album);
    GraphicalView view = null;

    reader.readCommands();

    if (viewTypeName.equals("graphical")) {
      view = new GraphicalView(viewWidth, viewHeight, reader.getAlbum().getShapes());
    } else {
      System.err.println("Unsupported view type.");
      return;
    }


  }

}


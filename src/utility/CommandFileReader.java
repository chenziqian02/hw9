package utility;

import model.*;
import model.Oval;
import org.w3c.dom.css.RGBColor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandFileReader {
  private String inputFileName;
  private ShapeAlbum album;

  public CommandFileReader(String inputFileName, ShapeAlbum album) {
    this.inputFileName = inputFileName;
    this.album = album;
  }

  public ShapeAlbum getAlbum() {
    return this.album;
  }

  public void readCommands() {
    try {
      Scanner scanner = new Scanner(new File(inputFileName));
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (line.length() == 0 || line.trim().charAt(0) == '#') {
          continue;
        }
        processLine(line);
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.err.println("File not found: " + inputFileName);
    }
  }

  private void processLine(String line) {
    String[] tokens = line.trim().split("\\s+");
    String command = tokens[0];

    switch (command) {
      case "shape":
        createShape(tokens);
        break;
      case "move":
        moveShape(tokens);
        break;
      case "color":
        colorShape(tokens);
        break;
      case "resize":
        resizeShape(tokens);
        break;
      case "remove":
        removeShape(tokens);
        break;
      case "snapshot":
        album.takeSnapshot("snapshot");
        break;
      default:
        System.out.println("Invalid command: " + command);
        break;
    }
  }

  private void createShape(String[] tokens) {
    String shapeName = tokens[1];
    String shapeType = tokens[2];
    int x = Integer.parseInt(tokens[3]);
    int y = Integer.parseInt(tokens[4]);
    int width = Integer.parseInt(tokens[5]);
    int height = Integer.parseInt(tokens[6]);
    int red = Integer.parseInt(tokens[7]);
    int green = Integer.parseInt(tokens[8]);
    int blue = Integer.parseInt(tokens[9]);



    Color color = Color.UNKNOWN;
    color.setRGB(red, green, blue);

    System.out.println("tokens");
    System.out.println(tokens);

    System.out.println("shapeType");
    System.out.println(shapeType);


    switch (shapeType) {

      case "rectangle":
        Rectangle rect = new Rectangle(x, y, color, shapeName, width, height);

        System.out.println(rect);

        album.addShape(rect);
        break;
      case "oval":
        Oval oval = new Oval(x, y, color, shapeName, width, height);
        album.addShape(oval);
        break;

    }
  }


  private void moveShape(String[] tokens) {
  }

  private void colorShape(String[] tokens) {
  }

  private void resizeShape(String[] tokens) {
  }

  private void removeShape(String[] tokens) {
  }
}

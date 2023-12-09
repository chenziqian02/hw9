package model;

import java.util.ArrayList;


public class Main {

  public static void main(String[] args) {
    //init shapes as ShapeAlbum
    ShapeAlbum shapes = new ShapeAlbum();

    // Creates a new Rectangle instance named 'R'
    AbstractShape R = new Rectangle(200.0, 200.0, Color.RED, "R", 20.0, 20.0);
    System.out.println(R);

    // Creates a new Oval instance named 'O'
    AbstractShape O = new Oval(500.0, 100.0, Color.BLUE, "O", 60.0, 30.0);
    System.out.println(O);

    // Adding to the ShapeAlbum

    shapes.addShape(R);
    shapes.addShape(O);

    shapes.takeSnapshot("After first selfie");
//    System.out.println(shapes.getLastSnapshot());

    R.move(-100, 100);
    R.resize(25, 100);
    R.setColor(Color.BLUE);
    shapes.takeSnapshot("2nd selfie");

    System.out.println("(NB: After moving and resizing and changing color of rectangle)\n");
    System.out.println(R);
    System.out.println(O);

    O.move(0, 300);
    O.setColor(Color.GREEN);
    shapes.takeSnapshot("");

    System.out.println("(NB: After moving oval)\n");
    System.out.println(R);


    System.out.println("(NB: After removing rectangle)\n");
    shapes.removeShape(R);
    shapes.takeSnapshot("Selfie after removing the rectangle from the picture");

    System.out.println(O);

    System.out.println("List of snapshots taken before reset: " + shapes.getAllSnapshotsTimeStamp() + "\n");

    for (Snapshot snapshot : shapes.getSnapshots()) {
      System.out.println(snapshot);
    }
  }
}


package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents a snapshot of the state of shapes at a specific point in time.
 */
public class Snapshot {
  private String description;
  private ArrayList<IShape> shapes;
  private LocalDateTime timestamp;
  private static Snapshot instance = new Snapshot();


  /**
   * Creates a snapshot of the current state of the provided shapes.
   *
   * @param shapes The list of shapes to capture in the snapshot.
   */
  public Snapshot(String description, ArrayList<IShape> shapes) {
    this.description = description;
    this.shapes = shapes;
    this.timestamp = LocalDateTime.now();
  }

  /**
   * private constructs a snapshot.
   */
  private Snapshot() {
  }

  /**
   * returns the instance of the snapshot.
   */
  public static Snapshot getInstance() {
    return instance;
  }


  /**
   * Gets the description of the snapshot.
   *
   * @return The description of the snapshot.
   */
  public String getDescription() {
    return description;
  }


  /**
   * Gets the timestamp of when the snapshot was taken.
   *
   * @return The timestamp of the snapshot.
   */
  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  /**
   * Returns a string representation of the Snapshot.
   * Includes the snapshot ID, timestamp, description, and details of the shapes.
   *
   * @return A string representation of the Snapshot.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Snapshot ID: ").append(timestamp.toString()).append("\n");
    sb.append("Timestamp: ").append(timestamp.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))).append("\n");
    sb.append("Description: ").append(description).append("\n");
    sb.append("Shape Information:\n");
    for (IShape shape : shapes) {
      sb.append(shape.toString()).append("\n");
    }
    return sb.toString();
  }


}

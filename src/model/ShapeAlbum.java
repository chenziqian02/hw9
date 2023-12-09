package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Manages a collection of shapes and their snapshots.
 * Allows adding and removing shapes, taking snapshots of their states, and retrieving these snapshots.
 */
public class ShapeAlbum {
  private ArrayList<IShape> shapes;
  private ArrayList<Snapshot> snapshots;
  public static ShapeAlbum instance = new ShapeAlbum();
  private static HashMap<String, List<IShape>> shapeMap = new HashMap<>();


  /**
   * Constructor for creating a new Shape Album.
   */
  public ShapeAlbum() {
    shapes = new ArrayList<>();
    snapshots = new ArrayList<>();
  }

  /**
   * get the instance of the ShapeAlbum.
   */
  public static ShapeAlbum getInstance() {
    return instance;
  }

  /**
   * Adds a shape to the album.
   *
   * @param shape The shape to be added.
   */
  public void addShape(IShape shape) {
    shapes.add(shape);
  }

  /**
   * Removes a shape from the album.
   *
   * @param shape The shape to be removed.
   */
  public void removeShape(IShape shape) {
    shapes.remove(shape);
  }

  /**
   * Takes a snapshot of the current state of shapes in the album.
   *
   * @param description A description of the snapshot.
   */
  public void takeSnapshot(String description) {
    snapshots.add(new Snapshot(description, getSnapshotShapeList()));
  }

  /**
   * Generates a list of cloned shapes to be stored in a snapshot.
   *
   * @return An ArrayList of cloned shapes.
   */
  public ArrayList<IShape> getSnapshotShapeList(){
    ArrayList<IShape> snapshotShapeList = new ArrayList<>();
    if(shapes == null || shapes.size() == 0)
        return snapshotShapeList;

    for (IShape shape : shapes) {
      snapshotShapeList.add(shape.deepClone());
    }

    return snapshotShapeList;
  }

  public HashMap<String, List<IShape>> getMap() {
    return shapeMap;
  }



  /**
   * Returns an unmodifiable list of snapshots taken in this album.
   *
   * @return An unmodifiable list of snapshots.
   */
  public List<Snapshot> getSnapshots() {
    return Collections.unmodifiableList(snapshots);
  }

  /**
   * Gets the number of snapshots taken in the album.
   *
   * @return The number of snapshots.
   */
  public int getSnapshotsSize() {
    return snapshots.size();
  }

  /**
   * Get the list of shapes where the index = index
   * @param index
   * @return
   */
  public List<IShape> getIndexShape(int index){
    return snapshots.get(index).getShapes();
  }

  /**
   * get current snapshot's description
   * @param index
   * @return
   */
  public String getCurrentSnapshotDesc(int index){
    return snapshots.get(index).toString();
  }

  /**
   * Retrieves the last snapshot taken in the album, if any.
   *
   * @return The last snapshot, or null if no snapshots have been taken.
   */
  public Snapshot getLastSnapshot() {
    if(getSnapshotsSize() == 0)
      return null;
    return snapshots.get(getSnapshotsSize() - 1);
  }

  /**
   * Returns a list of current shapes in the album.
   *
   * @return A list of current shapes.
   */
  public List<IShape> getShapes() {
    return shapes;
  }

  /**
   * Clears all shapes and snapshots from the album.
   *
   * @return True if both shapes and snapshots are cleared successfully.
   */
  public boolean clearAll(){
    shapes.clear();
    snapshots.clear();
    return shapes.size() == 0 && snapshots.size() == 0;
  }

  /**
   * Retrieves timestamps of all snapshots taken in the album.
   *
   * @return A list of timestamps in String format.
   */
  public List<String> getAllSnapshotsTimeStamp(){
    List<String> allTimeStamp = new ArrayList<>();
    if( snapshots == null || snapshots.size() == 0)
      return allTimeStamp;

    for (Snapshot snapshot : snapshots){
      allTimeStamp.add(snapshot.getTimestamp().toString());
    }

    return allTimeStamp;
  }

}

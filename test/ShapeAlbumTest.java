import model.Snapshot;
import model.Color;
import model.ShapeAlbum;
import model.IShape;
import model.Rectangle;
import model.Oval;
import model.Triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * Test class for ShapeAlbum.
 * It tests the addition, removal, and retrieval of shapes and snapshots using real shape objects.
 */
public class ShapeAlbumTest {

  private ShapeAlbum album;
  private IShape rectangle;
  private IShape oval;

  /**
   * Initializes a ShapeAlbum instance with Rectangle and Oval shapes before each test.
   */
  @BeforeEach
  void setUp() {
    album = new ShapeAlbum();
    rectangle = new Rectangle(0, 0, Color.RED, "Rectangle", 10, 20);
    oval = new Oval(0, 0, Color.BLUE, "Oval", 5, 10);
    album.addShape(rectangle);
    album.addShape(oval);
  }

  /**
   * Tests adding shapes to the ShapeAlbum.
   */
  @Test
  void testAddShape() {
    assertEquals(2, album.getShapes().size());
  }

  /**
   * Tests removing shapes from the ShapeAlbum.
   */
  @Test
  void testRemoveShape() {
    album.removeShape(rectangle);
    assertEquals(1, album.getShapes().size());
  }

  /**
   * Tests taking a snapshot of the current state of shapes in the album.
   */
  @Test
  void testTakeSnapshot() {
    album.takeSnapshot("First Snapshot");
    assertEquals(1, album.getSnapshotsSize());
  }

  /**
   * Tests retrieving snapshots from the album.
   */
  @Test
  void testGetSnapshots() {
    album.takeSnapshot("Snapshot");
    List<Snapshot> snapshots = album.getSnapshots();
    assertNotNull(snapshots);
    assertEquals(1, snapshots.size());
  }

  /**
   * Tests getting the size of snapshots in the album.
   */
  @Test
  void testGetSnapshotsSize() {
    album.takeSnapshot("Snapshot");
    assertEquals(1, album.getSnapshotsSize());
  }

  /**
   * Tests retrieving the last snapshot taken in the album.
   */
  @Test
  void testGetLastSnapshot() {
    album.takeSnapshot("Snapshot");
    Snapshot lastSnapshot = album.getLastSnapshot();
    assertNotNull(lastSnapshot);
    assertEquals("Snapshot", lastSnapshot.getDescription());
  }

  /**
   * Tests retrieving the current shapes in the album.
   */
  @Test
  void testGetShapes() {
    List<IShape> shapes = album.getShapes();
    assertNotNull(shapes);
    assertEquals(2, shapes.size());
  }

  /**
   * Tests clearing all shapes and snapshots from the album.
   */
  @Test
  void testClearAll() {
    album.clearAll();
    assertEquals(0, album.getShapes().size());
    assertEquals(0, album.getSnapshotsSize());
  }

  /**
   * Tests retrieving timestamps of all snapshots in the album.
   */
  @Test
  void testGetAllSnapshotsTimeStamp() {
    album.takeSnapshot("Snapshot");
    List<String> timestamps = album.getAllSnapshotsTimeStamp();
    assertNotNull(timestamps);
    assertEquals(1, timestamps.size());
  }

}

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Test class for Snapshot.
 * It tests the creation of snapshots and retrieval of snapshot details using real shape objects.
 */
public class SnapshotTest {

  private Snapshot snapshot;
  private ArrayList<IShape> shapes;
  private String description;

  @BeforeEach
  void setUp() {
    shapes = new ArrayList<>();
    shapes.add(new Rectangle(0, 0, Color.RED, "Rectangle", 10, 20));
    shapes.add(new Oval(0, 0, Color.BLUE, "Oval", 5, 10));
    description = "Test Snapshot";
    snapshot = new Snapshot(description, shapes);
  }

  @Test
  void testConstructor() {
    assertNotNull(snapshot);
    assertEquals(description, snapshot.getDescription());
  }

  @Test
  void testGetDescription() {
    assertEquals(description, snapshot.getDescription());
  }

  @Test
  void testGetTimestamp() {
    assertNotNull(snapshot.getTimestamp());
  }

  @Test
  void testToString() {
    String expectedString = "Snapshot ID: " + snapshot.getTimestamp().toString() + "\n" +
            "Timestamp: " + snapshot.getTimestamp().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\n" +
            "Description: " + description + "\n" +
            "Shape Information:\n" + shapes.get(0).toString() + "\n" + shapes.get(1).toString() + "\n";
    assertEquals(expectedString, snapshot.toString());
  }
}

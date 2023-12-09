import model.Color;
import model.Rectangle;
import model.ShapeAlbum;
import model.AbstractShape;
import model.Snapshot;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for the Rectangle class.
 */
public class RectangleTest {
  /**
   * Tests the Rectangle constructor.
   */
  @Test
  public void testConstructor() {
    Rectangle rect = new Rectangle(10, 20, Color.RED, "Rectangle1", 30, 40);
    assertEquals(10, rect.getX(), 0.01);
    assertEquals(20, rect.getY(), 0.01);
    assertEquals(Color.RED, rect.getColor());
    assertEquals("Rectangle1", rect.getName());
    assertEquals(30, rect.getWidth(), 0.01);
    assertEquals(40, rect.getHeight(), 0.01);
  }

  /**
   * Tests the copy constructor for creating a new Rectangle.
   */
  @Test
  public void testCopyConstructor() {
    Rectangle original = new Rectangle(10, 20, Color.RED, "Rectangle1", 30, 40);
    Rectangle copy = new Rectangle(original);
    assertNotSame(original, copy);
    assertEquals(original.getX(), copy.getX(), 0.01);
    assertEquals(original.getY(), copy.getY(), 0.01);
    assertEquals(original.getColor(), copy.getColor());
    assertEquals(original.getName(), copy.getName());
    assertEquals(original.getWidth(), copy.getWidth(), 0.01);
    assertEquals(original.getHeight(), copy.getHeight(), 0.01);
  }

  /**
   * Tests the getArea() method.
   */
  @Test
  public void testGetArea() {
    Rectangle rect = new Rectangle(10, 20, Color.RED, "Rectangle1", 30, 40);
    assertEquals(1200, rect.getArea(), 0.01);
  }

  /**
   * Tests the resize() method.
   */
  @Test
  public void testResize() {
    Rectangle rect = new Rectangle(10, 20, Color.RED, "Rectangle1", 30, 40);
    rect.resize(60, 80);
    assertEquals(60, rect.getWidth());
    assertEquals(80, rect.getHeight());
  }

  /**
   * Tests the resize() method with incorrect parameters.
   */
  @Test
  public void testResizeWithIncorrectParameters() {
    Rectangle rect = new Rectangle(10, 20, Color.RED, "Rectangle1", 30, 40);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      rect.resize(60); // Only one parameter
    });
    String expectedMessage = "Rectangle resize requires two double parameters.";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  /**
   * Tests the deepClone() method.
   */
  @Test
  public void testDeepClone() {
    Rectangle original = new Rectangle(10, 20, Color.RED, "Rectangle1", 30, 40);
    Rectangle clone = original.deepClone();
    assertNotSame(original, clone);
    assertEquals(original.getX(), clone.getX(), 0.01);
    assertEquals(original.getY(), clone.getY(), 0.01);
    assertEquals(original.getColor(), clone.getColor());
    assertEquals(original.getName(), clone.getName());
    assertEquals(original.getWidth(), clone.getWidth(), 0.01);
    assertEquals(original.getHeight(), clone.getHeight(), 0.01);
  }

  /**
   * Tests the toString() method.
   */
  @Test
  public void testToString() {
    Rectangle rect = new Rectangle(10, 20, Color.RED, "Rectangle1", 30, 40);
    String expectedOutput = "Name: Rectangle1\nType: RECTANGLE\n"
            + "Min Corner: (10.0,20.0), Width: 30.0, Height: 40.0, Color: (1.0,0.0,0.0)\n";
    assertEquals(expectedOutput, rect.toString());
  }


}
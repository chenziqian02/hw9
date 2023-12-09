import model.Color;
import model.Triangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Triangle class.
 */
public class TriangleTest {

  /**
   * Tests the Triangle constructor.
   */
  @Test
  public void testConstructor() {
    Triangle triangle = new Triangle(0, 0, Color.RED, "Triangle1", 3, 4, 3, 4, 5);
    assertEquals(0, triangle.getX());
    assertEquals(0, triangle.getY());
    assertEquals(Color.RED, triangle.getColor());
    assertEquals("Triangle1", triangle.getName());
    assertEquals(3, triangle.getBase());
    assertEquals(4, triangle.getHeight());
    assertEquals(3, triangle.getSideA());
    assertEquals(4, triangle.getSideB());
    assertEquals(5, triangle.getSideC());
  }

  /**
   * Tests the copy constructor for creating a new Triangle.
   */
  @Test
  public void testCopyConstructor() {
    Triangle original = new Triangle(0, 0, Color.RED, "Triangle1", 3, 4, 3, 4, 5);
    Triangle copy = new Triangle(original);
    assertNotSame(original, copy);
    assertEquals(original.getX(), copy.getX());
    assertEquals(original.getY(), copy.getY());
    assertEquals(original.getColor(), copy.getColor());
    assertEquals(original.getName(), copy.getName());
    assertEquals(original.getBase(), copy.getBase());
    assertEquals(original.getHeight(), copy.getHeight());
    assertEquals(original.getSideA(), copy.getSideA());
    assertEquals(original.getSideB(), copy.getSideB());
    assertEquals(original.getSideC(), copy.getSideC());
  }

  /**
   * Tests the getArea() method.
   */
  @Test
  public void testGetArea() {
    Triangle triangle = new Triangle(0, 0, Color.RED, "Triangle1", 3, 4, 3, 4, 5);
    assertEquals(6, triangle.getArea()); // Area for 3-4-5 triangle
  }

  /**
   * Tests the getPerimeter() method.
   */
  @Test
  public void testGetPerimeter() {
    Triangle triangle = new Triangle(0, 0, Color.RED, "Triangle1", 3, 4, 3, 4, 5);
    assertEquals(12, triangle.getPerimeter()); // Perimeter for 3-4-5 triangle
  }

  /**
   * Tests the resize() method with valid parameters.
   */
  @Test
  public void testResizeValid() {
    Triangle triangle = new Triangle(0, 0, Color.RED, "Triangle1", 3, 4, 3, 4, 5);
    triangle.resize(5, 12, 13); // Resize to another valid triangle
    assertEquals(5, triangle.getSideA());
    assertEquals(12, triangle.getSideB());
    assertEquals(13, triangle.getSideC());
  }

  /**
   * Tests the resize() method with invalid parameters.
   */
  @Test
  public void testResizeInvalid() {
    Triangle triangle = new Triangle(0, 0, Color.RED, "Triangle1", 3, 4, 3, 4, 5);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      triangle.resize(1, 1, 1); // Invalid triangle sides
    });
    String expectedMessage = "The given sides do not form a valid triangle.";
    assertTrue(exception.getMessage().contains(expectedMessage));
  }

  /**
   * Tests the deepClone() method.
   */
  @Test
  public void testDeepClone() {
    Triangle original = new Triangle(0, 0, Color.RED, "Triangle1", 3, 4, 3, 4, 5);
    Triangle clone = original.deepClone();
    assertNotSame(original, clone);
    assertEquals(original.getX(), clone.getX());
    assertEquals(original.getY(), clone.getY());
    assertEquals(original.getColor(), clone.getColor());
    assertEquals(original.getName(), clone.getName());
    assertEquals(original.getBase(), clone.getBase());
    assertEquals(original.getHeight(), clone.getHeight());
    assertEquals(original.getSideA(), clone.getSideA());
    assertEquals(original.getSideB(), clone.getSideB());
    assertEquals(original.getSideC(), clone.getSideC());
  }

}


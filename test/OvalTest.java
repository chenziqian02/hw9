import model.Color;
import model.Oval;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Oval class.
 */
public class OvalTest {

  /**
   * Tests the Oval constructor.
   */
  @Test
  public void testConstructor() {
    Oval oval = new Oval(100, 100, Color.BLUE, "Oval1", 60, 30);
    assertEquals(100, oval.getX());
    assertEquals(100, oval.getY());
    assertEquals(Color.BLUE, oval.getColor());
    assertEquals("Oval1", oval.getName());
    assertEquals(60, oval.getRadiusX());
    assertEquals(30, oval.getRadiusY());
  }

  /**
   * Tests the copy constructor for creating a new Oval.
   */
  @Test
  public void testCopyConstructor() {
    Oval original = new Oval(100, 100, Color.BLUE, "Oval1", 60, 30);
    Oval copy = new Oval(original);
    assertNotSame(original, copy);
    assertEquals(original.getX(), copy.getX());
    assertEquals(original.getY(), copy.getY());
    assertEquals(original.getColor(), copy.getColor());
    assertEquals(original.getName(), copy.getName());
    assertEquals(original.getRadiusX(), copy.getRadiusX());
    assertEquals(original.getRadiusY(), copy.getRadiusY());
  }


  /**
   * Tests the resize() method.
   */
  @Test
  public void testResize() {
    Oval oval = new Oval(100, 100, Color.BLUE, "Oval1", 60, 30);
    oval.resize(120, 60);
    double delta = 0.01;
    assertEquals(120, oval.getRadiusX(), delta);
    assertEquals(60, oval.getRadiusY(), delta);
  }

  /**
   * Tests the resize() method with incorrect parameters.
   */
  @Test
  public void testResizeWithIncorrectParameters() {
    Oval oval = new Oval(100, 100, Color.BLUE, "Oval1", 60, 30);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      oval.resize(120); // Only one parameter
    });
    String expectedMessage = "Oval resize requires two double parameters.";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  /**
   * Tests the deepClone() method.
   */
  @Test
  public void testDeepClone() {
    Oval original = new Oval(100, 100, Color.BLUE, "Oval1", 60, 30);
    Oval clone = original.deepClone();
    assertNotSame(original, clone);
    assertEquals(original.getX(), clone.getX());
    assertEquals(original.getY(), clone.getY());
    assertEquals(original.getColor(), clone.getColor());
    assertEquals(original.getName(), clone.getName());
    assertEquals(original.getRadiusX(), clone.getRadiusX());
    assertEquals(original.getRadiusY(), clone.getRadiusY());
  }

  /**
   * Tests the toString() method.
   */
  @Test
  public void testToString() {
    Oval oval = new Oval(100, 100, Color.BLUE, "Oval1", 60, 30);
    String expectedOutput = "Name: Oval1\nType: OVAL\nCenter: (100.0,100.0), X radius: 60.0, Y radius: 30.0, Color: BLUE\n";
    assertEquals(expectedOutput, oval.toString());
  }
}

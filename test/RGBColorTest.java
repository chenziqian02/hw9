import model.RGBColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains JUnit tests for the RGBColor class.
 * It tests getter and setter methods for red, green, and blue components,
 * as well as the toString method of the RGBColor class.
 */
public class RGBColorTest {

  private RGBColor color;

  /**
   * Sets up the testing environment.
   * Initializes an RGBColor object with default values before each test.
   */
  @BeforeEach
  void setUp() {
    // Initialize a color with some default values
    color = new RGBColor(0.5f, 0.5f, 0.5f);
  }

  /**
   * Tests if the getRed method returns the correct red value.
   */
  @Test
  void testGetRed() {
    assertEquals(0.5f, color.getRed(), "getRed should return the correct red value");
  }

  /**
   * Tests if the setRed method updates the red value correctly.
   */
  @Test
  void testSetRed() {
    color.setRed(0.25f);
    assertEquals(0.25f, color.getRed(), "setRed should update the red value correctly");
  }

  /**
   * Tests if the getGreen method returns the correct green value.
   */
  @Test
  void testGetGreen() {
    assertEquals(0.5f, color.getGreen(), "getGreen should return the correct green value");
  }


  /**
   * Tests if the setGreen method updates the green value correctly.
   */
  @Test
  void testSetGreen() {
    color.setGreen(0.25f);
    assertEquals(0.25f, color.getGreen(), "setGreen should update the green value correctly");
  }

  /**
   * Tests if the getBlue method returns the correct blue value.
   */
  @Test
  void testGetBlue() {
    assertEquals(0.5f, color.getBlue(), "getBlue should return the correct blue value");
  }

  /**
   * Tests if the setBlue method updates the blue value correctly.
   */
  @Test
  void testSetBlue() {
    color.setBlue(0.25f);
    assertEquals(0.25f, color.getBlue(), "setBlue should update the blue value correctly");
  }

  /**
   * Tests if the toString method returns the correct string representation of the RGBColor object.
   */
  @Test
  void testToString() {
    String expected = "(0.5,0.5,0.5)";
    assertEquals(expected, color.toString(), "toString should return the correct string representation");
  }

}

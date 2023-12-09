package model;


/**
 * Represents a color in the RGB color space.
 * This class encapsulates the red, green, and blue components of a color, each ranging from 0.0 to 1.0.
 */
public class RGBColor {
  private float red;
  private float green;
  private float blue;

  /**
   * Constructs an RGBColor with specified red, green, and blue components.
   *
   * @param red   The red component of the color (0.0 to 1.0).
   * @param green The green component of the color (0.0 to 1.0).
   * @param blue  The blue component of the color (0.0 to 1.0).
   */
  public RGBColor(float red, float green, float blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Gets the red component of the color.
   *
   * @return The red component.
   */
  public float getRed() {
    return red;
  }

  /**
   * Sets the red component of the color.
   *
   * @param red The new red component value.
   */
  public void setRed(float red) {
    this.red = red;
  }

  /**
   * Gets the green component of the color.
   *
   * @return The green component.
   */
  public float getGreen() {
    return green;
  }

  /**
   * Sets the green component of the color.
   *
   * @param green The new green component value.
   */
  public void setGreen(float green) {
    this.green = green;
  }

  /**
   * Gets the blue component of the color.
   *
   * @return The blue component.
   */
  public float getBlue() {
    return blue;
  }

  /**
   * Sets the blue component of the color.
   *
   * @param blue The new blue component value.
   */
  public void setBlue(float blue) {
    this.blue = blue;
  }

  /**
   * Returns a string representation of the RGBColor.
   * The string representation includes the red, green, and blue components in the format (red,green,blue).
   *
   * @return A string representation of the RGBColor.
   */
  @Override
  public String toString() {
    return "(" + this.red + "," + this.blue + "," + this.green + ")";
  }

}

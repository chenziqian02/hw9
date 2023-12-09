package model;
import java.awt.Graphics;

/**
 * Represents an oval shape.
 */
public class Oval extends AbstractShape {
  private double radiusX;
  private double radiusY;

  /**
   * Constructor for creating an oval.
   *
   * @param x       The x-coordinate of the oval's center.
   * @param y       The y-coordinate of the oval's center.
   * @param color   The color of the oval.
   * @param name    The name of the oval.
   * @param radiusX The horizontal radius of the oval.
   * @param radiusY The vertical radius of the oval.
   */
  public Oval(double x, double y, Color color, String name, double radiusX, double radiusY) {
    super(x, y, color, name, Type.OVAL);
    this.radiusX = radiusX;
    this.radiusY = radiusY;
  }

  /**
   * Copy constructor for Oval.
   *
   * @param oval The Oval to copy.
   */
  public Oval(Oval oval) {
    super(oval);
    this.radiusX = oval.radiusX;
    this.radiusY = oval.radiusY;
  }

  public double getRadiusX() {
    return this.radiusX;
  }

  public double getRadiusY() {
    return this.radiusY;
  }


  /**
   * Resizes the oval by the specified scale factor.
   */
  @Override
  public void resize(double... params) {
    if (params.length != 2) {
      throw new IllegalArgumentException("Oval resize requires two double parameters.");
    }
    this.radiusX = params[0];
    this.radiusY = params[1];
  }

  /**
   * Creates and returns a deep clone of this Oval.
   *
   * @return A deep clone of the Oval instance.
   */
  @Override
  public Oval deepClone(){
    return new Oval(this);
  }



  /**
   * Returns a string representation of the Oval
   *
   * @return A string representation of the Oval
   */
  public String toString() {
    String oval = "";
    String output = super.toString();

    oval += "Center: (" + String.format("%.1f", getX()) + ","
            + String.format("%.1f", getY()) + "), "
            + "X radius: " + String.format("%.1f", radiusX) + ", "
            + "Y radius: " + String.format("%.1f", radiusY) + ", "
            + "Color: " + this.color + "\n";

    return output + oval;
  }


}

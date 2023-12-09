package model;
import java.awt.Graphics;


/**
 * Represents a rectangle shape.
 */
public class Rectangle extends AbstractShape {
  private double width;
  private double height;
  private Color color;

  /**
   * Constructor for creating a rectangle.
   *
   * @param x      The x-coordinate of the rectangle's starting point.
   * @param y      The y-coordinate of the rectangle's starting point.
   * @param color  The color of the rectangle.
   * @param name   The name of the rectangle.
   * @param width  The width of the rectangle.
   * @param height The height of the rectangle.
   */
  public Rectangle(double x, double y, Color color,
                   String name, double width, double height) {
    super(x, y, color, name, Type.RECTANGLE);
    this.width = width;
    this.height = height;
  }

  /**
   * Copy constructor for Rectangle.
   *
   */
  public Rectangle(Rectangle other) {
    super(other);
    this.width = other.width;
    this.height = other.height;
  }

  /**
   * Returns the width of the Rectangle.
   *
   */
  public double getWidth() {
    return this.width;
  }

  /**
   * Returns the height of the Rectangle.
   *
   */
  public double getHeight() {
    return this.height;
  }


  /**
   * Calculates the area of the rectangle.
   *
   * @return The area of the rectangle.
   */
  public double getArea() {
    return width * height;
  }


  /**
   * Resizes the rectangle by changing the height and width.
   *
   */
  @Override
  public void resize(double... params) {
    if (params.length != 2) {
      throw new IllegalArgumentException("Rectangle resize requires two double parameters.");
    }
    this.width = params[0];
    this.height = params[1];
  }

  @Override
  public Rectangle deepClone(){
    return new Rectangle(this);
  }


  /**
   * Returns a string representation of the Rectangle
   *
   * @return A string representation of the Rectangle
   */
  public String toString() {
    String rec = "";
    String output = super.toString();

    rec += "Min Corner: (" + String.format("%.1f", getX()) + ","
            + String.format("%.1f", getY()) + "), "
            + "Width: " + String.format("%.1f", width) + ", "
            + "Height: " + String.format("%.1f", height) + ", "
            + "Color: " + this.color + "\n";

    return output + rec;
  }


}
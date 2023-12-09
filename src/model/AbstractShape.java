package model;

/**
 * Abstract class for shapes, providing common properties and functionalities.
 */
public abstract class AbstractShape implements IShape {
  protected double x;  //x-coordinate
  protected double y;  //y-coordinate
  protected Color color;
  protected String name;
  protected Type type;


  /**
   * Constructor for abstract shape.
   *
   * @param x     The x-coordinate of the shape.
   * @param y     The y-coordinate of the shape.
   * @param color The color of the shape.
   * @param name  The name of the shape.
   */
  public AbstractShape(double x, double y, Color color, String name, Type type) {
    this.type = type;

    setX(x);
    setY(y);
    setName(name);
    setColor(color);
  }

  /**
   * Copy constructor to create a new Shape instance by copying another shape.
   * @param other represents Shape instance to copy
   */
  public AbstractShape(AbstractShape other) {
    this.type = other.type;
    setX(other.x);
    setY(other.y);
    setName(other.name);
    setColor(other.color);
  }

  /**
   * Returns the x-coordinate of the shape
   * @return The x-coordinate
   */
  public double getX() {
    return x;
  }

  /**
   * Sets the x-coordinate of the shape
   * @param x The new x-coordinate
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Returns the y-coordinate of the shape
   * @return The y-coordinate
   */
  public double getY() {
    return y;
  }

  /**
   * Sets the y-coordinate of the shape
   * @param y The new y-coordinate
   */
  public void setY(double y) {
    this.y = y;
  }



  /**
   * Sets the name of the shape
   * @param name
   */
  public void setName(String name){ this.name = name; }

  /**
   * Returns the name of the shape
   * @return The name
   */
  public String getName() {return this.name; }

  /**
   * Returns the type of the shape
   * @return The type
   */
  public Type getType() { return this.type; }
  /**
   * Moves the shape to a new location.
   *
   * @param deltaX The change in x-coordinate.
   * @param deltaY The change in y-coordinate.
   */
  public void move(double deltaX, double deltaY) {
    this.x += deltaX;
    this.y += deltaY;
  }

  public Color getColor() {
    return this.color;
  }

  public void setColor(Color original){
    this.color = original;
  }




  /**
   * Changes the color of the shape.
   *
   * @param newColor The new color of the shape.
   */
  public void changeColor(Color newColor) {
    setColor(color);
  }

  /**
   * Returns a string representation of the shape.
   * @return A string describing the shape
   */
  public String toString() {
    String output = "Name: " + name + "\n";
    output += "Type: " + type.toString() + "\n";
    return output;
  }

}

package model;

import java.awt.*;

/**
 * Represents a triangle shape.
 */
public class Triangle extends AbstractShape {
  private double base, height;
  private double sideA, sideB, sideC;

  /**
   * Constructor for creating a triangle.
   *
   * @param x      The x-coordinate of the triangle's starting point.
   * @param y      The y-coordinate of the triangle's starting point.
   * @param color  The color of the triangle.
   * @param name   The name of the triangle.
   * @param base   The base length of the triangle.
   * @param height The height of the triangle.
   * @param sideA  The length of side A of the triangle.
   * @param sideB  The length of side B of the triangle.
   * @param sideC  The length of side C of the triangle.
   */
  public Triangle(double x, double y, Color color, String name, double base,
                  double height, double sideA, double sideB, double sideC) {
    super(x, y, color, name, Type.TRIANGLE);
    this.base = base;
    this.height = height;
    this.sideA = sideA;
    this.sideB = sideB;
    this.sideC = sideC;
  }


  /**
   * Copy constructor for Triangle.
   */
  public Triangle(Triangle other) {
    super(other);
    this.base = other.base;
    this.height = other.height;
    this.sideA = other.sideA;
    this.sideB = other.sideB;
    this.sideC = other.sideC;
  }

  public double getBase() {
    return this.base;
  }

  public double getHeight() {
    return this.height;
  }

  public double getSideA() {
    return this.sideA;
  }

  public double getSideB() {
    return this.sideB;
  }

  public double getSideC() {
    return this.sideC;
  }

  /**
   * Calculates the area of the triangle.
   *
   * @return The area of the triangle.
   */
  public double getArea() {
    return 0.5 * base * height;
  }

  /**
   * Calculates the perimeter of the triangle.
   *
   * @return The perimeter of the triangle.
   */
  public double getPerimeter() {
    return sideA + sideB + sideC;
  }

  /**
   * Resizes the triangle by changing the lengths of its sides.
   *
   * @param params An array of parameters where params[0] is the new length of side A,
   *               params[1] is the new length of side B, and params[2] is the new length of side C.
   * @throws IllegalArgumentException if an incorrect number of parameters is passed or
   *                                  if the parameters do not form a valid triangle.
   */
  @Override
  public void resize(double... params) {
    if (params.length != 3) {
      throw new IllegalArgumentException("Triangle resize requires three double parameters.");
    }
    if (!isValidTriangle(params[0], params[1], params[2])) {
      throw new IllegalArgumentException("The given sides do not form a valid triangle.");
    }

    this.sideA = params[0];
    this.sideB = params[1];
    this.sideC = params[2];
  }

  /**
   * Validates if the sides form a valid triangle.
   *
   * @param a Length of side A.
   * @param b Length of side B.
   * @param c Length of side C.
   * @return true if the sides form a valid triangle, false otherwise.
   */
  private boolean isValidTriangle(double a, double b, double c) {
    return a + b > c && a + c > b && b + c > a;
  }

  /**
   * Creates and returns a deep clone of this Triangle.
   *
   * @return A deep clone of the Triangle instance.
   */
  @Override
  public Triangle deepClone(){
    return new Triangle(this);
  }


}

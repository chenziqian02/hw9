package model;

/**
 * Enumeration of available shape colors.
 */
public class Color {

  public static Color RED = new Color(255,0,0);
  public static Color GREEN = new Color(0,255,0);
  public static Color BLUE = new Color(0,0,255);
  public static Color YELLOW = new Color(255, 255, 0);

  private int red;
  private int green;
  private int blue;

  public Color(int red, int green, int blue){
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  // Method to set RGB values for CUSTOM color
  public void setRGB(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  // Getters for RGB values
  public int getRed() { return red; }
  public int getGreen() { return green; }
  public int getBlue() { return blue; }

  public java.awt.Color toAwtColor(){
    return new java.awt.Color(red,green,blue);
  }
}

package model;

/**
 * Enumeration of available shape colors.
 */
public enum Color {
  RED, GREEN, BLUE, YELLOW, UNKNOWN;

  private int red;
  private int green;
  private int blue;

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
}

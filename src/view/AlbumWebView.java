package view;

import model.*;
import model.Rectangle;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class generates and stores HTML representations of a photo album.
 */
public class AlbumWebView {
  private final ShapeAlbum album;

  /**
   * Creates a web view of a photo album.
   *
   * @param album The photo album to be displayed in HTML.
   */
  public AlbumWebView(ShapeAlbum album) {
    this.album = album;
  }

  /**
   * Produces the HTML representation of the album.
   *
   * @return HTML content as a string.
   */
  public String createHtmlRepresentation() {
    StringBuilder htmlBuilder = new StringBuilder();
    htmlBuilder.append("<!DOCTYPE html>\n<html>\n<head>\n")
            .append("<title>Album of Shapes</title>\n</head>\n<body>\n");

    for (Snapshot image : album.getSnapshots()) {
      htmlBuilder.append("<section class=\"image-snapshot\">\n")
              .append("<header>Time Captured: ")
              .append(image.getTimestamp())
              .append("</header>\n")
              .append("<article>Description: ")
              .append(image.getDescription())
              .append("</article>\n")
              .append("<figure>\n<svg width=\"1000\" height=\"1000\">\n");

      for (IShape shape : image.getShapes()) {
        String shapeSvg = shape instanceof Oval ? createEllipseSvg((Oval) shape)
                : createRectangleSvg((Rectangle) shape);
        htmlBuilder.append(shapeSvg);
      }

      htmlBuilder.append("</svg>\n</figure>\n</section>\n");
    }

    htmlBuilder.append("</body>\n</html>");
    return htmlBuilder.toString();
  }

  private String createEllipseSvg(Oval ellipse) {
    return String.format("<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\" style=\"fill:rgb(%d,%d,%d)\" />\n",
            ellipse.getX(), ellipse.getY(), ellipse.getRadiusX(), ellipse.getRadiusY(),
            ellipse.getColor().getRed(), ellipse.getColor().getGreen(), ellipse.getColor().getBlue());
  }

  private String createRectangleSvg(Rectangle rect) {
    return String.format("<rect x=\"%f\" y=\"%f\" width=\"%f\" height=\"%f\" style=\"fill:rgb(%d,%d,%d)\" />\n",
            rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(),
            rect.getColor().getRed(), rect.getColor().getGreen(), rect.getColor().getBlue());
  }

  /**
   * Stores the HTML content in a specified file.
   *
   * @param filename The file's name for storing the HTML.
   */
  public void storeHtmlToFile(String filename) {
    String htmlContent = createHtmlRepresentation();
    try (BufferedWriter htmlWriter = new BufferedWriter(new FileWriter(filename))) {
      htmlWriter.write(htmlContent);
    } catch (IOException e) {
      System.err.println("Error when writing to file: " + e.getMessage());
    }
  }
}

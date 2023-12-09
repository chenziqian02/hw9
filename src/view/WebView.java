//package view;
//
//import model.ShapeAlbum;
//import model.Snapshot;
//import model.IShape;
//import model.Oval;
//import model.Rectangle;
//import model.IShape;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//
///**
// * The WebView class is responsible for generating and saving HTML content
// * that represents the snapshots and shapes of a photo album.
// */
//public class WebView {
//  private final ShapeAlbum album;
//
//  /**
//   * Constructs a WebView with a given ShapesPhotoAlbum.
//   *
//   * @param album The ShapesPhotoAlbum to be rendered as HTML.
//   */
//  public WebView(ShapeAlbum album) {
//    this.album = album;
//  }
//
//  /**
//   * Generates HTML content representing the snapshots and shapes.
//   *
//   * @return A String containing the generated HTML content.
//   */
//  public String generateHTMLContent() {
//    StringBuilder htmlContent = new StringBuilder();
//    htmlContent.append("<!DOCTYPE html>\n")
//            .append("<html>\n<head>\n<title>Shapes Photo Album</title>\n</head>\n<body>\n");
//
//    for (Snapshot snapshot : album.getSnapshots()) {
//      htmlContent.append("<div class=\"snapshot\">\n")
//              .append("<h2>Timestamp: ")
//              .append(snapshot.getTimestamp())
//              .append("</h2>\n")
//              .append("<h3>Description: ")
//              .append(snapshot.getDescription())
//              .append("</h3>\n")
//              .append("<svg width=\"1000\" height=\"1000\">\n");
//
//      for (IShape shape : snapshot.getShapes()) {
//        if (shape instanceof Oval) {
//          Oval oval = (Oval) shape;
//          htmlContent.append("<ellipse cx=\"")
//                  .append(oval.getRadiusX())
//                  .append("\" ry=\"")
//                  .append(oval.getRadiusY())
//                  .append("\" style=\"fill:rgb(")
//                  .append(oval.getColor().getRed()).append(",")
//                  .append(oval.getColor().getGreen()).append(",")
//                  .append(oval.getColor().getBlue()).append(")\" />\n");
//        } else if (shape instanceof Rectangle) {
//          Rectangle rect = (Rectangle) shape;
//          htmlContent.append("<rect x=\"")
//                  .append(rect.getX())
//                  .append("\" y=\"")
//                  .append(rect.getY())
//                  .append("\" width=\"")
//                  .append(rect.getWidth())
//                  .append("\" height=\"")
//                  .append(rect.getHeight())
//                  .append("\" style=\"fill:rgb(")
//                  .append(rect.getColor().getRed()).append(",")
//                  .append(rect.getColor().getGreen()).append(",")
//                  .append(rect.getColor().getBlue()).append(")\" />\n");
//        }
//      }
//
//      htmlContent.append("</svg>\n</div>\n");
//    }
//
//    htmlContent.append("</body>\n</html>");
//    return htmlContent.toString();
//  }
//
//  /**
//   * Saves the generated HTML content to a file.
//   *
//   * @param filename The name of the file to save the HTML content.
//   */
//  public void saveToFile(String filename) {
//    String htmlContent = generateHTMLContent();
//    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
//      writer.write(htmlContent);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//}

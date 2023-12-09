package view;

import model.*;
import model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphicalView extends JFrame implements IShapeView {
  private int xMax;
  private int yMax;
  private JFrame frame;
  private Snapshot snapshot;
  private List<IShape> shapesToDraw = new ArrayList<>();

  private List<String> IDList;
  private int index;
  private JPanel drawingPanel;


  public GraphicalView(int viewWidth, int viewHeight, List<IShape> shapesToDraw) {
    initializeView(viewWidth, viewHeight);
    this.shapesToDraw = shapesToDraw;
  }

  @Override
  public void initializeView(int width, int height) {
    // Setting up the frame
    setTitle("Shapes Photo Album");
    setSize(width, height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());


    // Create and add panels
    drawingPanel = new JPanel() {

      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawShapes(g);
      }
    };


    add(drawingPanel, BorderLayout.CENTER);

    // Create a panel for buttons
    JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    // Creating buttons
    JButton btnPrevious = new JButton("<< Prev <<");
    JButton btnSelect = new JButton("^^ Select ^^");
    JButton btnNext = new JButton(">> Next >>");
    JButton btnQuit = new JButton("xx Quit xx");

    // Add buttons to the control panel
    controlPanel.add(btnSelect);
    controlPanel.add(btnPrevious);
    controlPanel.add(btnNext);
    controlPanel.add(btnQuit);

    // Add action listeners to buttons (to be implemented)
//    btnPrevious.addActionListener(e -> previousnapshot());
//    btnSelect.addActionListener(e -> selectSnapshot());
//    btnNext.addActionListener(e -> nextSnapshot());
    btnQuit.addActionListener(e -> quit());

    // Add the control panel to the bottom of the frame
    add(controlPanel, BorderLayout.SOUTH);


    setVisible(true);
  }

  private void drawShapes(Graphics g) {
    for (IShape shape : shapesToDraw) {
      if (shape instanceof Rectangle) {
        drawRectangle(g, (Rectangle) shape);
      } else if (shape instanceof Oval) {
        drawOval(g, (Oval) shape);
      }

    }
  }

  private void drawRectangle(Graphics g, Rectangle rect) {
    g.setColor(rect.getColor().toAwtColor());
    // Fills the rectangle with the set color
    g.fillRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
  }

  private void drawOval(Graphics g, Oval oval) {
    g.setColor(oval.getColor().toAwtColor());
    g.drawOval((int) oval.getX(), (int) oval.getY(), (int) oval.getRadiusX(), (int) oval.getRadiusY());
    // Use fillOval instead of drawOval to fill the oval with color
  }

  public void quit() {
    System.exit(0);
  }


  @Override
  public void refreshView() {
    // Redraw or revalidate the necessary components.
    drawingPanel.revalidate();
    drawingPanel.repaint();
  }

  @Override
  public void displayError(String errorMessage) {
    // Display the error message in a dialog.
    JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
  }


  @Override
  public void closeView() {
    // Clean up resources and close the frame.
    frame.dispose();
  }



}

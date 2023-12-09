package view;

import model.*;
import model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphicalView extends JFrame implements IShapeView {
  private JFrame frame;
  private JLabel label;
  private ShapeAlbum album;

  //current index of album
  private int index;
  private JPanel drawingPanel;
  JPopupMenu popupMenu;


  public GraphicalView(int viewWidth, int viewHeight, ShapeAlbum album) {
    this.album = album;
    this.index = 0;

    initializeView(viewWidth, viewHeight);


    //set up popup menu
    popupMenu = new JPopupMenu();
    for(int i = 0;i < album.getSnapshotsSize();i++){
      JMenuItem item = new JMenuItem(album.getCurrentSnapshotDesc(i));
      int finalI = i;
      item.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

          paintComponents(drawingPanel.getGraphics());
          drawShapes(drawingPanel.getGraphics(), finalI);
          index = finalI;
        }
      });
      popupMenu.add(item);
    }
  }

  @Override
  public void initializeView(int width, int height) {
    // Setting up the frame
    setTitle("Shapes Photo Album");
    setSize(width, height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());


    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    this.label = new JLabel("Welcome", JLabel.CENTER);
    topPanel.add(label);
    this.add(topPanel,BorderLayout.NORTH);

    // Create and add panels
    drawingPanel = new JPanel();
    add(drawingPanel, BorderLayout.CENTER);
    System.out.println(drawingPanel.getGraphics());


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
    btnPrevious.addActionListener(e -> previousnapshot());
    btnSelect.addActionListener(e -> selectSnapshot());
    btnNext.addActionListener(e -> nextSnapshot());
    btnQuit.addActionListener(e -> quit());

    // Add the control panel to the bottom of the frame
    add(controlPanel, BorderLayout.SOUTH);
    setVisible(true);
    paintComponents(drawingPanel.getGraphics());
    drawShapes(drawingPanel.getGraphics(),index);
  }

  private void selectSnapshot() {
    popupMenu.show(this, getWidth()/2,getHeight()/2);
  }

  private void previousnapshot() {
    index--;
    index = Math.max(index, 0);
    paintComponents(drawingPanel.getGraphics());
    drawShapes(drawingPanel.getGraphics(),index);
  }

  private void nextSnapshot() {
    index++;
    index = Math.min(index,album.getSnapshotsSize()-1);
    paintComponents(drawingPanel.getGraphics());
    drawShapes(drawingPanel.getGraphics(),index);
  }

  private void drawShapes(Graphics g,int index) {
    List<IShape> shapesToDraw = album.getIndexShape(index);
    this.label.setText(album.getCurrentSnapshotDesc(index));
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
    g.fillOval((int) oval.getX(), (int) oval.getY(), (int) oval.getRadiusX(), (int) oval.getRadiusY());
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

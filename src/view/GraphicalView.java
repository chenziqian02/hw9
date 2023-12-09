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
  private DrawingPanel drawingPanel;
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

          setUpLabel(finalI);
          setUpDrawingPanel(finalI);
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

    //Setting up toPanel for label
    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    this.label = new JLabel("Welcome", JLabel.CENTER);
    topPanel.add(label);
    this.add(topPanel,BorderLayout.NORTH);

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
    setUpLabel(index);
    setUpDrawingPanel(index);
    setVisible(true);

  }

  /**
   * update label text when jumping to a new snapshot
   * @param index
   */
  private void setUpLabel(int index){
    this.label.setText(album.getCurrentSnapshotDesc(index));
  }

  /**
   * update drawing panel when jumping to a new snapshot
   * @param index
   */
  private void setUpDrawingPanel(int index){
    drawingPanel = new DrawingPanel(album.getIndexShape(index));
    add(drawingPanel, BorderLayout.CENTER);
    refreshView();
  }

  private void selectSnapshot() {
    popupMenu.show(this, getWidth()/2,getHeight()/2);
  }

  private void previousnapshot() {
    index--;
    index = Math.max(index, 0);
    setUpLabel(index);
    setUpDrawingPanel(index);
  }

  private void nextSnapshot() {
    index++;
    index = Math.min(index,album.getSnapshotsSize()-1);
    setUpLabel(index);
    setUpDrawingPanel(index);
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

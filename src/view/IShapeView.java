package view;

import java.awt.*;

/**
 * Interface representing a view in the Shapes Photo Album application.
 */
public interface IShapeView {

  void initializeView(int width, int height);

//  void paintComponent(Graphics g);

  /**
   * Refreshes or updates the view.
   */
  void refreshView();

  /**
   * Displays an error message to the user.
   * @param errorMessage The error message to be displayed.
   */
  void displayError(String errorMessage);


  /**
   * Closes the view and releases any resources associated with it. This is particularly relevant for graphical views.
   */
  void closeView();
}

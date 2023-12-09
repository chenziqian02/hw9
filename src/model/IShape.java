package model;
/**
 * removed changeColor and move, since they are overrided by AbstractShape
 * and they are same for all shapes.
 */

import java.awt.*;

/**
 * Interface for defining basic functionalities of shapes.
 */
public interface IShape{
  /**
   * Resizes the shape by the specified scale factor.
   */
//  void resize(double x, double y);
  void resize(double... paras);

  IShape deepClone();


}

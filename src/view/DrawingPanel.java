package view;

import model.IShape;
import model.Oval;
import model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DrawingPanel extends JPanel {

    List<IShape> shapesToDraw;

    public DrawingPanel(List<IShape> shapesToDraw){
        this.shapesToDraw = shapesToDraw;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        drawShapes(g,shapesToDraw);
    }
    private void drawShapes(Graphics g,List<IShape> shapesToDraw) {

        for (IShape shape : shapesToDraw) {
            if (shape instanceof model.Rectangle) {
                drawRectangle(g, (model.Rectangle) shape);
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
}

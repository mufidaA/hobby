import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.*;

class DrawPanel extends JPanel {

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        Point2D.Double pt1 = new Point2D.Double(100, 10);
        Point2D.Double pt2 = new Point2D.Double(125, 75);
        Point2D.Double pt3 = new Point2D.Double(200, 85);
        Point2D.Double pt4 = new Point2D.Double(150, 125);
        Point2D.Double pt5 = new Point2D.Double(160, 190);
        Point2D.Double pt6 = new Point2D.Double(100, 150);
        Point2D.Double pt7 = new Point2D.Double(40, 190);
        Point2D.Double pt8 = new Point2D.Double(50, 125);
        Point2D.Double pt9 = new Point2D.Double(0, 85);
        Point2D.Double pt10 = new Point2D.Double(70, 75);
        double b = 1.1;

        for (int i = 0; i < 60; i++) {
            double P1y = pt1.getY() + b;
            double P2y = pt2.getY() + b;
            double P3y = pt3.getY() + b;
            double P4y = pt4.getY() + b;
            double P5y = pt5.getY() + b;
            double P6y = pt6.getY() + b;
            double P7y = pt7.getY() + b;
            double P8y = pt8.getY() + b;
            double P9y = pt9.getY() + b;
            double P10y = pt10.getY() + b;
            pt1 = new Point2D.Double(100, P1y);
            pt2 = new Point2D.Double(125,P2y);
            pt3 = new Point2D.Double(200, P3y);
            pt4 = new Point2D.Double(150, P4y);
            pt5 = new Point2D.Double(160, P5y);
            pt6 = new Point2D.Double(100, P6y);
            pt7 = new Point2D.Double(40, P7y);
            pt8 = new Point2D.Double(50,P8y);
            pt9 = new Point2D.Double(0, P9y);
            pt10 = new Point2D.Double(70, P10y);
            Line2D.Double ln1 = new Line2D.Double(pt1, pt2);
            Line2D.Double ln2 = new Line2D.Double(pt2, pt3);
            Line2D.Double ln3 = new Line2D.Double(pt3, pt4);
            Line2D.Double ln4 = new Line2D.Double(pt4, pt5);
            Line2D.Double ln5 = new Line2D.Double(pt5, pt6);
            Line2D.Double ln6 = new Line2D.Double(pt6, pt7);
            Line2D.Double ln7 = new Line2D.Double(pt7, pt8);
            Line2D.Double ln8 = new Line2D.Double(pt8, pt9);
            Line2D.Double ln9 = new Line2D.Double(pt9, pt10);
            Line2D.Double ln10 = new Line2D.Double(pt10, pt1);

            g2.setColor(Color.RED);

            g2.draw(ln1);
            g2.draw(ln2);
            g2.draw(ln3);
            g2.draw(ln4);
            g2.draw(ln5);
            g2.draw(ln6);
            g2.draw(ln7);
            g2.draw(ln8);
            g2.draw(ln9);
            g2.draw(ln10);

        }
    }
}

public class StarClass {

    static JFrame frame;

    public static void main(String[] args) {

        DrawPanel panel = new DrawPanel();

        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);

        frame.setSize(400, 400);
        frame.setTitle("Star");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
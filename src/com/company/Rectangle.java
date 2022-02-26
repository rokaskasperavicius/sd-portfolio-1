package com.company;

// Same as the Java Point class but accepts double values
import java.awt.geom.Point2D;
import java.awt.Point;

public class Rectangle extends Shape {
  final private int width;
  final private int height;

  final private Point bottomLeftPoint;

  public Rectangle(int width, int height, Point point) {
    this.width = width;
    this.height = height;

    this.bottomLeftPoint = point;
  }

  public Point2D getCenter() {
    // Calculate center coordinates with added bottom left point offset
    double x = (double)this.width / 2 + this.bottomLeftPoint.getX();
    double y = (double)this.height / 2 + this.bottomLeftPoint.getY();

    return new Point2D.Double(x, y);
  }

  public double getArea() {
    return this.width * this.height;
  }

  public double getCircumference() {
    return this.width * 2 + this.height * 2;
  }

  public boolean isPointInside(Point point) {
    int x = point.x;
    int y = point.y;

    int shapeX = this.bottomLeftPoint.x;
    int shapeY = this.bottomLeftPoint.y;

    return (x >= shapeX && y >= shapeY && x <= this.width + shapeX && y <= this.height + shapeY);
  }
}

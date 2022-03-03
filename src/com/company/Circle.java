package com.company;

// Same as the Java Point class but accepts double values
import java.awt.geom.Point2D;
import java.awt.Point;

public class Circle extends Shape {
  final private Point center;
  final private int radius;

  public Circle(Point center, int radius) {
    this.center = center;
    this.radius = radius;
  }

  @Override
  public Point2D getCenter() {
    return this.center;
  }

  @Override
  public double getArea() {
    return Math.pow(this.radius, 2) * Math.PI;
  }

  @Override
  public double getCircumference() {
    return 2 * this.radius * Math.PI;
  }

  // https://stackoverflow.com/questions/481144/equation-for-testing-if-a-point-is-inside-a-circle
  @Override
  public boolean isPointInside(Point point) {
    return Math.pow(point.x - center.x, 2) + Math.pow(point.y - center.y, 2)  <= radius * radius;
  }
}


package com.company;

import java.awt.Point;

// Same as the Java Point class but accepts double values
import java.awt.geom.Point2D;

public abstract class Shape {
  public abstract Point2D getCenter();
  public abstract double getArea();
  public abstract double getCircumference();

  // Point inside means that the point can also be on the border of the shape
  public abstract boolean isPointInside(Point point);

  // Using https://docs.oracle.com/javase/7/docs/api/java/awt/geom/Point2D.html#distance(java.awt.geom.Point2D)
  public double getEuclideanDistance(Shape shape) {
    return this.getCenter().distance(shape.getCenter());
  }
}

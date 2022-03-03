package com.company;

// Same as the Java Point class but accepts double values
import java.awt.geom.Point2D;
import java.awt.Point;

public class Triangle extends Shape {
  final private Point aPoint; // left point
  final private Point bPoint; // top point
  final private Point cPoint; // right point

  public Triangle(Point aPoint, Point bPoint, Point cPoint) {
    double bottomSide = aPoint.distance(cPoint);
    double leftSide = aPoint.distance(bPoint);
    double rightSide = cPoint.distance(bPoint);

    System.out.println(bottomSide);
    System.out.println(leftSide);
    System.out.println(rightSide);

    this.aPoint = aPoint;
    this.bPoint = bPoint;
    this.cPoint = cPoint;
  }

  // https://www.cuemath.com/centroid-formula/
  @Override
  public Point2D getCenter() {
    double centerX = (double)(this.aPoint.x + this.bPoint.x + this.cPoint.x) / 3;
    double centerY = (double)(this.aPoint.y + this.bPoint.y + this.cPoint.y) / 3;

    return new Point2D.Double(centerX, centerY);
  }

  // https://www.cuemath.com/measurement/area-of-triangle/
  @Override
  public double getArea() {
    return calculateArea(this.aPoint, this.bPoint, this.cPoint);
  }

  public double calculateArea(Point a, Point b, Point c) {
    double bottomSide = a.distance(c);
    double leftSide = a.distance(b);
    double rightSide = c.distance(b);

    double s = (bottomSide + leftSide + rightSide) / 2;

    return Math.sqrt(s * (s - bottomSide) * (s - leftSide) * (s - rightSide));
  }

  @Override
  public double getCircumference() {
    double bottomSide = this.aPoint.distance(this.cPoint);
    double leftSide = this.aPoint.distance(this.bPoint);
    double rightSide = this.cPoint.distance(this.bPoint);

    return (bottomSide + leftSide + rightSide);
  }

  // https://discuss.codechef.com/t/best-way-to-check-if-a-point-lies-inside-a-triangle-or-not/13528
  @Override
  public boolean isPointInside(Point point) {
    double area = getArea();

    double area1 = calculateArea(point, this.bPoint, this.cPoint);
    double area2 = calculateArea(this.aPoint, point, this.cPoint);
    double area3 = calculateArea(this.aPoint, this.bPoint, point);

    // This is not the right fix but sometimes some areas have 0.0000000000000067 more than needed
    // This is because Math functions with double  are not precise when dividing
    // I found a fix with BigDecimals which is more precises but could not figure how to implement
    return Math.abs(area - (area1 + area2 + area3)) < 0.00000000001;
  }
}


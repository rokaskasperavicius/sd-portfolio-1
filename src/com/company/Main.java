package com.company;

import java.awt.Point;

public class Main {

    public static void main(String[] args) {
      System.out.println("Rectangle:");
      Rectangle rectangle = new Rectangle(2, 4, new Point(0, 0));

      System.out.println(rectangle.getCenter());
      System.out.println(rectangle.getArea());
      System.out.println(rectangle.getCircumference());
      System.out.println(rectangle.isPointInside(new Point(1, 2)));
      System.out.println(rectangle.getEuclideanDistance(rectangle));

      System.out.println("Triangle:");
      Triangle triangle = new Triangle(new Point(), new Point(3, 9), new Point(6, 0));

      System.out.println(triangle.getCenter());
      System.out.println(triangle.getArea());
      System.out.println(triangle.getCircumference());
      System.out.println(triangle.isPointInside(new Point(3, 1)));;
      System.out.println(triangle.getEuclideanDistance(triangle));

      System.out.println("Circle:");
      Circle circle = new Circle(new Point(), 5);

      System.out.println(circle.getCenter());
      System.out.println(circle.getArea());
      System.out.println(circle.getCircumference());
      System.out.println(circle.isPointInside(new Point(-1, -2)));
      System.out.println(circle.getEuclideanDistance(rectangle));
    }
}

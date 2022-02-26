package com.company;

import java.awt.Point;

public class Main {

    public static void main(String[] args) {
      Rectangle rectangle = new Rectangle(2, 4, new Point(0, 0));

      System.out.println(rectangle.getCenter());
      System.out.println(rectangle.getArea());
      System.out.println(rectangle.getCircumference());
      System.out.println(rectangle.isPointInside(new Point(1, 2)));
      System.out.println(rectangle.getEuclideanDistance(rectangle));
    }
}

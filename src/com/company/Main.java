package com.company;

import java.awt.Point;

public class Main {
    public static void main(String[] args) {
      Rectangle rectangle = new Rectangle(2, 4, new Point(0, 0));
      Triangle triangle = new Triangle(new Point(), new Point(3, 9), new Point(6, 0));
      Circle circle = new Circle(new Point(), 5);
    }
}

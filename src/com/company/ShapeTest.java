package com.company;

import java.awt.Point;
import java.awt.geom.Point2D;

// Testing
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {
  // Defining class objects for testing rectangle class
  Rectangle rectangle = new Rectangle(5, 10, new Point(0, 0));
  Rectangle rectangleOffset = new Rectangle(5, 10, new Point(1, 2));
  Rectangle rectangleMoved = new Rectangle(5, 10, new Point(5, 0));

  // Defining class objects for testing triangle class
  Triangle triangle = new Triangle(new Point(), new Point(3, 9), new Point(6, 0));

  // Defining class objects for testing circle class
  Circle circle = new Circle(new Point(), 5);

  @Test
  public void testGetCenter() {
    // Rectangle
    assertEquals(rectangle.getCenter(), new Point2D.Double(2.5, 5));
    assertEquals(rectangleOffset.getCenter(), new Point2D.Double(3.5, 7));

    // Triangle
    assertEquals(triangle.getCenter(), new Point2D.Double(3.0, 3.0));

    // Circle
    assertEquals(circle.getCenter(), new Point2D.Double(0.0, 0.0));
  }

  @Test
  public void testGetArea() {
    // Rectangle
    assertEquals(rectangle.getArea(), 50);
    assertEquals(rectangleOffset.getArea(), 50);

    // Triangle
    assertEquals(triangle.getArea(), 27);

    // Circle
    assertEquals(circle.getArea(), 78.53981633974483);
  }

  @Test
  public void testGetCircumference() {
    // Rectangle
    assertEquals(rectangle.getCircumference(), 30);
    assertEquals(rectangleOffset.getCircumference(), 30);

    // Triangle
    assertEquals(triangle.getCircumference(), 24.973665961010276);

    // Circle
    assertEquals(circle.getCircumference(), 31.41592653589793);
  }

  @Test
  public void testIsPointInside() {
    // Rectangle
    assertFalse(rectangleOffset.isPointInside(new Point(0, 0)));
    assertFalse(rectangleOffset.isPointInside(new Point(20, 5)));
    assertFalse(rectangleOffset.isPointInside(new Point(-5, 0)));
    assertFalse(rectangleOffset.isPointInside(new Point(7, -5)));

    // Testing corners
    assertTrue(rectangleOffset.isPointInside(new Point(1, 2)));
    assertTrue(rectangleOffset.isPointInside(new Point(6, 2)));
    assertTrue(rectangleOffset.isPointInside(new Point(1, 12)));
    assertTrue(rectangleOffset.isPointInside(new Point(6, 12)));

    // Triangle
    assertTrue(triangle.isPointInside(new Point(3, 4)));
    assertTrue(triangle.isPointInside(new Point(0, 0)));
    assertTrue(triangle.isPointInside(new Point(3, 9)));

    assertFalse(triangle.isPointInside(new Point(7, 0)));
    assertFalse(triangle.isPointInside(new Point(1, 4)));

    // Circle
    assertTrue(circle.isPointInside(new Point(-1, -3)));
    assertTrue(circle.isPointInside(new Point(-5, 0)));
    assertTrue(circle.isPointInside(new Point(3, 2)));

    assertFalse(circle.isPointInside(new Point(6, 0)));
    assertFalse(circle.isPointInside(new Point(-5, 4)));
  }

  @Test
  // Euclidean distance is calculated using Java Point2D class method, therefore, there is no need for in-depth testing
  public void testGetEuclideanDistance() {
    // Rectangle
    assertEquals(rectangle.getEuclideanDistance(rectangleMoved), 5.0);
    assertEquals(rectangle.getEuclideanDistance(rectangleOffset), 2.23606797749979);

    // Triangle
    assertEquals(triangle.getEuclideanDistance(triangle), 0.0);

    // Circle
    assertEquals(circle.getEuclideanDistance(rectangle), 5.5901699437494745);
    assertEquals(circle.getEuclideanDistance(circle), 0.0);
  }
}

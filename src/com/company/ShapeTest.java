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

  @Test
  public void testGetCenter() {
    assertEquals(rectangle.getCenter(), new Point2D.Double(2.5, 5));
    assertEquals(rectangleOffset.getCenter(), new Point2D.Double(3.5, 7));
  }

  @Test
  public void testGetArea() {
    assertEquals(rectangle.getArea(), 50);
    assertEquals(rectangleOffset.getArea(), 50);
  }

  @Test
  public void testGetCircumference() {
    assertEquals(rectangle.getCircumference(), 30);
    assertEquals(rectangleOffset.getCircumference(), 30);
  }

  @Test
  public void testIsPointInside() {
    assertFalse(rectangleOffset.isPointInside(new Point(0, 0)));
    assertFalse(rectangleOffset.isPointInside(new Point(20, 5)));
    assertFalse(rectangleOffset.isPointInside(new Point(-5, 0)));
    assertFalse(rectangleOffset.isPointInside(new Point(7, -5)));

    // Testing corners
    assertTrue(rectangleOffset.isPointInside(new Point(1, 2)));
    assertTrue(rectangleOffset.isPointInside(new Point(6, 2)));
    assertTrue(rectangleOffset.isPointInside(new Point(1, 12)));
    assertTrue(rectangleOffset.isPointInside(new Point(6, 12)));
  }

  @Test
  // Euclidean distance is calculated using Java Point2D class method, therefore, there is no need for in-depth testing
  public void testGetEuclideanDistance() {
    assertEquals(rectangle.getEuclideanDistance(rectangleMoved), 5);
    assertEquals(rectangle.getEuclideanDistance(rectangleOffset), 2.23606797749979);
  }
}

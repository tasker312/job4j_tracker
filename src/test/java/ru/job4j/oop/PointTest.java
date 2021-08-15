package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void distance3d() {
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(3, 3, 3);
        double result = p1.distance3d(p2);
        double exp = 3 * Math.sqrt(3);
        assertEquals(exp, result, 0.01);
    }
}
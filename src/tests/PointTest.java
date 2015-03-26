package tests;

import static org.junit.Assert.*;

import intervals.Point;
import intervals.PointType;

import org.junit.Test;

public class PointTest {

    @Test
    public void test() {
        Point p1 = Point.create(1, PointType.OPENED);

        Point p2 = Point.create(10, PointType.OPENED);
        
        Point p8 = Point.create(10, PointType.CLOSED);
        
        Point p9 = Point.create(1, PointType.CLOSED);
        
        assertFalse(p9.isSmallerThan(p1));
        
        assertFalse(p8.isSmallerThan(p2));
        
        assertTrue(p1.isSmallerThan(p2));
        
        assertFalse(p1.isBiggerThan(p2));
        
        assertFalse(p1.isSmallerThan(p1));
        
        assertFalse(p1.isBiggerThan(p1));
        
        assertTrue(p2.isBiggerThan(p8));
        
        assertTrue(p2.isSmallerThan(p8));
        
        assertTrue(p1.isBiggerThan(p9));
        
        assertFalse(p1.isBiggerThan(p8));
        
        assertTrue(p1.isSmallerThan(p9));
        
        assertFalse(p9.isBiggerThan(p1));
        
        assertTrue(p8.isBiggerThan(p1));
        
        Point p3 = Point.create(5, PointType.CLOSED);
        Point p4 = Point.create(4, PointType.CLOSED);
        
        assertFalse(p3.isBiggerThan(p3));
        
        assertFalse(p3.isSmallerThan(p3));
        
        assertTrue(p3.isBiggerThan(p4));
        
        assertTrue(p4.isSmallerThan(p3));
        
    }

}

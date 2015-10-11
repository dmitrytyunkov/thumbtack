package net.thumbtack.tyunkov.secondLesson;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 11.10.15.
 */
public class RectangleTest {

    @Test
    public void testFindAreaIntersection() {
        int area = 0;
        Rectangle[] rectangles = new Rectangle[5];
        rectangles[0] = new Rectangle(1,1,3,3);
        rectangles[1] = new Rectangle(0,0,2,2);
        rectangles[2] = new Rectangle(2,2,7,7);
        rectangles[3] = new Rectangle(1,4,5,8);
        rectangles[4] = new Rectangle(2,0,4,2);
        for(int i = 0; i < rectangles.length - 1 ; i++) {
            for(int j = i + 1; j < rectangles.length; j++) {
                area += rectangles[i].findAreaIntersection(rectangles[j]);
            }
        }
        assertEquals(area, 12);
    }
}
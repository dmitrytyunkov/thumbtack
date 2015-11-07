package net.thumbtack.tyunkov.lessons.fifth;

import net.thumbtack.tyunkov.lessons.fourth.Color;
import net.thumbtack.tyunkov.lessons.third.cars.Car;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 01.11.15.
 */
public class FirstTest {

    @Test
    public void testColorException() {
        Car car = new Car("Ford", 2000, 200, "BLUE");
        assertEquals(Color.BLUE, car.getColor());
    }
}

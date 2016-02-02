package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.fifth.Trainee;
import net.thumbtack.tyunkov.lessons.fifth.TraineeException;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 22.11.15.
 */
public class QueueTest {
    private Queue<Trainee> traineeQueue = new PriorityQueue<>();

    private void createTraineeQueue() {
        traineeQueue.clear();
        try {
            traineeQueue.add(new Trainee("Richard", "Castle", 5));
            traineeQueue.add(new Trainee("Dimitry", "Ivanov", 3));
            traineeQueue.add(new Trainee("Alexander", "Ral", 4));
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testQueue() {
        createTraineeQueue();
        while (!traineeQueue.isEmpty())
            traineeQueue.poll();
        assertTrue(traineeQueue.isEmpty());
    }
}

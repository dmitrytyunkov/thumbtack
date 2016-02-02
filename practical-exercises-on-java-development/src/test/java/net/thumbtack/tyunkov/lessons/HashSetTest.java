package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.fifth.Trainee;
import net.thumbtack.tyunkov.lessons.fifth.TraineeException;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 22.11.15.
 */
public class HashSetTest {
    private Set<Trainee> traineeSet = new java.util.HashSet<>();

    private void createTraineeHashSet() {
        traineeSet.clear();
        try {
            traineeSet.add(new Trainee("Richard", "Castle", 5));
            traineeSet.add(new Trainee("Dimitry", "Ivanov", 3));
            traineeSet.add(new Trainee("Alexander", "Ral", 4));
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testHashSet() {
        Trainee trainee = null;
        try {
            trainee = new Trainee("Richard", "Castle", 5);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        createTraineeHashSet();
        assertTrue(traineeSet.contains(trainee));

        for (Trainee t : traineeSet)
            System.out.println(t);
    }
}

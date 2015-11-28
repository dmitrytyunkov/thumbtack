package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.fifth.Trainee;
import net.thumbtack.tyunkov.lessons.fifth.TraineeException;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by dmitry on 22.11.15.
 */
public class TreeSetTest {
    private Set<Trainee> traineeSet = new java.util.TreeSet<>((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

    private void createTraineeTreeSet() {
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
    public void testTreeSet() {
        Trainee trainee = null;
        try {
            trainee = new Trainee("Richard", "Castle", 5);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        createTraineeTreeSet();
        assertTrue(traineeSet.contains(trainee));
        for (Trainee t : traineeSet)
            System.out.println(t);
    }

    @Test
    public void testTreeSetFail() {
        Trainee trainee = null;
        try {
            trainee = new Trainee("Ric", "Castle", 5);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        createTraineeTreeSet();
        assertTrue(traineeSet.contains(trainee));
        System.out.println();
        for (Trainee t : traineeSet)
            System.out.println(t);
    }
}

package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.fifth.Trainee;
import net.thumbtack.tyunkov.lessons.fifth.TraineeException;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by dmitry on 15.11.15.
 */
public class LinkedListTest {
    private List<Trainee> traineeList = new LinkedList<>();

    private void createTraineeList() {
        traineeList.clear();
        try {
            traineeList.add(new Trainee("Richard", "Castle", 5));
            traineeList.add(new Trainee("Dimitry", "Ivanov", 3));
            traineeList.add(new Trainee("Alexander", "Ral", 4));
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testReverse() {
        createTraineeList();
        List<Trainee> traineeList1 = new ArrayList<>();
        try {
            traineeList1.add(new Trainee("Alexander", "Ral", 4));
            traineeList1.add(new Trainee("Dimitry", "Ivanov", 3));
            traineeList1.add(new Trainee("Richard", "Castle", 5));
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        Collections.reverse(traineeList);
        // traineeList.removeAll(traineeList1);
        // assertTrue(traineeList.isEmpty());
        assertArrayEquals(traineeList1.toArray(), traineeList.toArray());
    }

    @Test
    public void testRotate() {
        createTraineeList();
        List<Trainee> traineeList1 = new ArrayList<>();
        try {
            // traineeList1.add(new Trainee("Dimitry", "Ivanov", 3));
            traineeList1.add(new Trainee("Alexander", "Ral", 4));
            traineeList1.add(new Trainee("Richard", "Castle", 5));
            traineeList1.add(new Trainee("Dimitry", "Ivanov", 3));
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        Collections.rotate(traineeList, -2);
        // traineeList.removeAll(traineeList1);
        // assertTrue(traineeList.isEmpty());
        assertArrayEquals(traineeList1.toArray(),traineeList.toArray());
    }

    @Test
    public void testShuffle() {
        createTraineeList();
        List<Trainee> traineeList1 = new ArrayList<>();
        try {
            // traineeList1.add(new Trainee("Dimitry", "Ivanov", 3));
            traineeList1.add(new Trainee("Alexander", "Ral", 4));
            traineeList1.add(new Trainee("Richard", "Castle", 5));
            traineeList1.add(new Trainee("Dimitry", "Ivanov", 3));
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        Collections.shuffle(traineeList, new Random());
        traineeList.removeAll(traineeList1);
        assertTrue(traineeList.isEmpty());
    }

    @Test
    public void testSortByMark() {
        createTraineeList();
        List<Trainee> traineeList1 = new ArrayList<>();
        try {
            traineeList1.add(new Trainee("Richard", "Castle", 5));
            traineeList1.add(new Trainee("Alexander", "Ral", 4));
            traineeList1.add(new Trainee("Dimitry", "Ivanov", 3));
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        Collections.sort(traineeList, ((p1, p2) -> -(p1.getMark() - p2.getMark())));
        assertArrayEquals(traineeList1.toArray(), traineeList.toArray());
    }

    @Test
    public void testSearch() {
        createTraineeList();
        List<Trainee> traineeList1 = new ArrayList<>();
        try {
            traineeList1.add(new Trainee("Richard", "Castle", 5));
            traineeList1.add(new Trainee("Alexander", "Ral", 4));
            traineeList1.add(new Trainee("Dimitry", "Ivanov", 3));
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        Collections.sort(traineeList, ((p1, p2) -> -(p1.getMark() - p2.getMark())));
        assertArrayEquals(traineeList1.toArray(), traineeList.toArray());
    }

    @Test
    public void testSortByName() {
        createTraineeList();
        List<Trainee> traineeList1 = new ArrayList<>();
        try {
            traineeList1.add(new Trainee("Alexander", "Ral", 4));
            traineeList1.add(new Trainee("Dimitry", "Ivanov", 3));
            traineeList1.add(new Trainee("Richard", "Castle", 5));
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        Collections.sort(traineeList);
        assertArrayEquals(traineeList1.toArray(), traineeList.toArray());
    }

    @Test
    public void testMaxMark() {
        createTraineeList();
        Trainee traineeExpected = null;
        Trainee traineeActual = Collections.max(traineeList, ((p1, p2) -> (p1.getMark() - p2.getMark())));
        try {
            traineeExpected = new Trainee("Richard", "Castle", 5);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        assertEquals(traineeExpected, traineeActual);
    }

    @Test
    public void testSearchByName() {
        createTraineeList();
        Trainee traineeExpected = null;
        Trainee traineeActual = Collections.max(traineeList, ((p1, p2) -> (p1.getMark() - p2.getMark())));
        try {
            traineeExpected = new Trainee("Richard", "Castle", 5);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        int index = -1;
        for (int i = 0; i < traineeList.size(); i++)
            if(traineeList.get(i).getName().compareTo("Richard") == 0)
                traineeActual = traineeList.get(i);

        assertEquals(traineeExpected, traineeActual);
    }
}

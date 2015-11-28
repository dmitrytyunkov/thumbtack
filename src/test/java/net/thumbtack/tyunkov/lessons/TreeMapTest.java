package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.exceptions.InstituteException;
import net.thumbtack.tyunkov.lessons.fifth.Trainee;
import net.thumbtack.tyunkov.lessons.fifth.TraineeException;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by dmitry on 22.11.15.
 */
public class TreeMapTest {
    private Map<Trainee, Institute> traineeInstituteMap = new TreeMap<>((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

    private void createTraineeInstituteTreeMap() {
        traineeInstituteMap.clear();
        try {
            traineeInstituteMap.put(new Trainee("Richard", "Castle", 5), new Institute("OmSU", "Omsk"));
            traineeInstituteMap.put(new Trainee("Dimitry", "Ivanov", 3), new Institute("OmSTU", "Omsk"));
            traineeInstituteMap.put(new Trainee("Alexander", "Ral", 4), new Institute("TUSUR", "Tomsk"));
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        } catch (InstituteException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testSearchTrainee() {
        Trainee trainee = null;
        Institute institute = null;
        try {
            trainee = new Trainee("Richard", "Castle", 5);
            institute = new Institute("OmSU", "Omsk");
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        } catch (InstituteException ex) {
            fail(ex.getMessage());
        }
        createTraineeInstituteTreeMap();
        assertEquals(traineeInstituteMap.get(trainee), institute);

        for (Trainee t : traineeInstituteMap.keySet())
            System.out.println(t);

        System.out.println();
        for (Trainee t : traineeInstituteMap.keySet())
            System.out.println(t + ". Institute: " + traineeInstituteMap.get(t));
    }

    @Test
    public void testTreeMap() {
        Trainee trainee = null;
        Institute institute = null;
        try {
            trainee = new Trainee("Ric", "Castle", 5);
            institute = new Institute("OmSU", "Omsk");
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        } catch (InstituteException ex) {
            fail(ex.getMessage());
        }
        createTraineeInstituteTreeMap();
        assertEquals(traineeInstituteMap.get(trainee), institute);

        System.out.println();
        for (Trainee t : traineeInstituteMap.keySet())
            System.out.println(t);

        System.out.println();
        for (Trainee t : traineeInstituteMap.keySet())
            System.out.println(t + ". Institute: " + traineeInstituteMap.get(t));
    }
}

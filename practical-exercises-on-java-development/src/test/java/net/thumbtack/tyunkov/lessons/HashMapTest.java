package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.exceptions.InstituteException;
import net.thumbtack.tyunkov.lessons.fifth.Trainee;
import net.thumbtack.tyunkov.lessons.fifth.TraineeException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by dmitry on 22.11.15.
 */
public class HashMapTest {
    private Map<Trainee, Institute> traineeInstituteMap = new HashMap<>();

    private void createTraineeInstituteHashMap() {
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
        createTraineeInstituteHashMap();
        assertEquals(traineeInstituteMap.get(trainee), institute);

        for (Trainee t : traineeInstituteMap.keySet())
            System.out.println(t);
    }
}

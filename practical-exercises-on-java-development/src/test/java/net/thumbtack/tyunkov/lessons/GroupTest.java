package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.errorCodes.GroupErrorCode;
import net.thumbtack.tyunkov.lessons.exceptions.GroupException;
import net.thumbtack.tyunkov.lessons.fifth.Trainee;
import net.thumbtack.tyunkov.lessons.fifth.TraineeException;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 15.11.15.
 */
public class GroupTest {
    public Trainee[] trainees = null;

    @Test(expected = TraineeException.class)
    public void testCreateIncorrectTrainee() throws TraineeException {
        Trainee trainee = new Trainee("", "", 0);
    }

    @Test
    public void testCreateTrainee() {
        trainees = new Trainee[3];
        try {
            trainees[0] = new Trainee("Richard", "Castle", 5);
            trainees[1] = new Trainee("Dimitry", "Ivanov", 3);
            trainees[2] = new Trainee("Alexander", "Ral", 4);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        assertEquals(3, trainees.length);
    }

    @Test(expected = GroupException.class)
    public void testIncorrectCreateGroup() throws GroupException {
        Group group = new Group("", trainees);
    }

    @Test
    public void testCreateGroup() {
        if (trainees == null)
            testCreateTrainee();
        Group group = null;
        try {
            group = new Group("IVT", trainees);
        } catch (GroupException ex) {
            fail(ex.getMessage());
        }
        assertNotNull(group);
    }

    @Test
    public void testSortByMark() {
        if (trainees == null)
            testCreateTrainee();
        Group group = null;
        try {
            group = new Group("IVT", trainees);
        } catch (GroupException ex) {
            fail(ex.getMessage());
        }
        Arrays.sort(group.getTrainees(), ((p1, p2) -> -(p1.getMark()-p2.getMark())));
        Trainee[] trainees1 = new Trainee[3];
        try {
            trainees1[0] = new Trainee("Richard", "Castle", 5);
            trainees1[1] = new Trainee("Alexander", "Ral", 4);
            trainees1[2] = new Trainee("Dimitry", "Ivanov", 3);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        assertArrayEquals(trainees1, group.getTrainees());
    }

    @Test
    public void testSortByName() {
        if (trainees == null)
            testCreateTrainee();
        Group group = null;
        try {
            group = new Group("IVT", trainees);
        } catch (GroupException ex) {
            fail(ex.getMessage());
        }
        Arrays.sort(group.getTrainees());
        Trainee[] trainees1 = new Trainee[3];
        try {
            trainees1[2] = new Trainee("Richard", "Castle", 5);
            trainees1[0] = new Trainee("Alexander", "Ral", 4);
            trainees1[1] = new Trainee("Dimitry", "Ivanov", 3);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        assertArrayEquals(trainees1, group.getTrainees());
    }

    @Test
    public void testSearchByName() {
        if (trainees == null)
            testCreateTrainee();
        Group group = null;
        try {
            group = new Group("IVT", trainees);
        } catch (GroupException ex) {
            fail(ex.getMessage());
        }
        int index = -1;
        for (int i = 0; i < group.getTrainees().length; i++)
            if(group.getTrainees()[i].getName().compareTo("Alexander") == 0)
                index = i;

        Trainee[] trainees1 = new Trainee[3];
        try {
            trainees1[2] = new Trainee("Richard", "Castle", 5);
            trainees1[0] = new Trainee("Alexander", "Ral", 4);
            trainees1[1] = new Trainee("Dimitry", "Ivanov", 3);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        assertEquals(trainees1[0], group.getTrainees()[index]);
    }
}

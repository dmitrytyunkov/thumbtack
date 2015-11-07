package net.thumbtack.tyunkov.lessons.fifth;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by dmitry on 01.11.15.
 */
public class TraineeTest {
    @Test
    public void testConstructorCorrect() {
        try {
            Trainee trainee = new Trainee("Dmitry", "Tyunkov", 4);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testConstructorIncorrectName() {
       try {
           Trainee trainee = new Trainee(null, "Tyunkov", 3);
       } catch (TraineeException ex) {
           assertThat(ex.getMessage(), is("Name incorrect"));
       }
    }

    @Test
    public void testConstructorIncorrectLastName() {
        try {
            Trainee trainee = new Trainee("Dmitry", "", 3);
        } catch (TraineeException ex) {
            assertThat(ex.getMessage(), is("Last name incorrect"));
        }
    }

    @Test
    public void testConstructorIncorrectRating() {
        try {
            Trainee trainee = new Trainee("Dmitry", "Tyunkov", 6);
        } catch (TraineeException ex) {
            assertThat(ex.getMessage(), is("Mark incorrect"));
        }
    }

    @Test
    public void testConstructorIncorrectNameAndRating() {
        try {
            Trainee trainee = new Trainee("", "Tyunkov", 6);
        } catch (TraineeException ex) {
            assertThat(ex.getMessage(), is("Name incorrect"));
        }
    }

    @Test
    public void testSetNameIncorrect() {
        try {
            Trainee trainee = new Trainee("Dmitry", "Tyunkov", 4);
            try {
                trainee.setName(null);
            } catch (TraineeException ex) {
                assertThat(ex.getMessage(), is("Name incorrect"));
            }
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testSetLastNameIncorrect() {
        try {
            Trainee trainee = new Trainee("Dmitry", "Tyunkov", 3);
            try {
                trainee.setLastName("");
            } catch (TraineeException ex) {
                assertThat(ex.getMessage(), is("Last name incorrect"));
            }
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testSetRatingIncorrect() {
        try {
            Trainee trainee = new Trainee("Dmitry", "Tyunkov", 4);
            try {
                trainee.setMark(0);
            } catch (TraineeException ex) {
                assertThat(ex.getMessage(), is("Mark incorrect"));
            }
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
    }
}

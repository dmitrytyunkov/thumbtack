package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.fifth.*;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 08.11.15.
 */
public class TextIOTest {

    @Test
    public void testFileWriter() {
        Trainee trainee = null;
        File file = new File("trainee.txt");
        if(file.exists())
            file.delete();
        try {
            trainee = new Trainee("Dmitry", "Александров", 4);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write("Name: " + trainee.getName() + "\n");
            bufferedWriter.write("Last name: " + trainee.getLastName() + "\n");
            bufferedWriter.write("Mark: " + trainee.getMark());
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        assertTrue(file.exists());
    }

    @Test
    public void testStreamWriter() {
        Trainee trainee = null;
        File file = new File("traineeUTF-16.txt");
        if(file.exists())
            file.delete();
        try {
            trainee = new Trainee("Dmitry", "Александров", 4);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-16")) {
            outputStreamWriter.write("Name: " + trainee.getName() + "\n");
            outputStreamWriter.write("Last name: " + trainee.getLastName() + "\n");
            outputStreamWriter.write("Mark: " + trainee.getMark());
        } catch (FileNotFoundException ex) {
            fail(ex.getMessage());
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        assertTrue(file.exists());
    }

    @Test
    public void testFileReader(){
        Trainee trainee = null;
        File file = new File("trainee.txt");
        String[] strings = new String[3];
        if(!file.exists())
            testFileWriter();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            strings[0] = bufferedReader.readLine();
            strings[1] = bufferedReader.readLine();
            strings[2] = bufferedReader.readLine();
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        try {
            trainee = new Trainee(strings[0].split(": ")[1], strings[1].split(": ")[1], Integer.parseInt(strings[2].split(": ")[1]));
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        try {
            assertEquals(new Trainee("Dmitry", "Александров", 4), trainee);
        } catch (TraineeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStreamReader() {
        Trainee trainee = null;
        File file = new File("traineeUTF-16.txt");
        if(!file.exists())
            testStreamWriter();
        char[] chars = new char[(int)file.length()];
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),"UTF-16")) {
            inputStreamReader.read(chars);
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        String string = new String(chars).trim();
        String[] strings = string.split("\n");
        try {
            trainee = new Trainee(strings[0].split(": ")[1], strings[1].split(": ")[1], Integer.parseInt(strings[2].split(": ")[1]));
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        try {
            assertEquals(new Trainee("Dmitry", "Александров", 4), trainee);
        } catch (TraineeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileWriterSingleStr() {
        Trainee trainee = null;
        File file = new File("traineeSingleStr.txt");
        if(file.exists())
            file.delete();
        try {
            trainee = new Trainee("Dmitry", "Александров", 4);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-16")) {
            outputStreamWriter.write(trainee.getName() + "\t");
            outputStreamWriter.write(trainee.getLastName() + "\t");
            outputStreamWriter.write(String.valueOf(trainee.getMark()));
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        assertTrue(file.exists());
    }

    @Test
    public void testFileReaderSingleStr(){
        Trainee trainee = null;
        File file = new File("traineeSingleStr.txt");
        char[] chars = new char[(int)file.length()];
        if(!file.exists())
            testFileWriterSingleStr();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),"UTF-16")) {
            inputStreamReader.read(chars);
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        String string = new String(chars).trim();
        String[] strings = string.split("\t");
        try {
            trainee = new Trainee(strings[0], strings[1], Integer.parseInt(strings[2]));
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        try {
            assertEquals(new Trainee("Dmitry", "Александров", 4), trainee);
        } catch (TraineeException e) {
            e.printStackTrace();
        }
    }
}

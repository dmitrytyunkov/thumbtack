package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.fifth.Trainee;
import net.thumbtack.tyunkov.lessons.fifth.TraineeException;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 08.11.15.
 */
public class SerializeTest {

    @Test
    public void testSerialize(){
        File file = new File("serializeTrainee.dat");
        if(file.exists())
            file.delete();
        Trainee trainee = null;
        try {
            trainee = new Trainee("Dmitry", "Александров", 4);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(trainee);
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        assertTrue(file.exists());
    }

    @Test
    public void testDeserialize(){
        File file = new File("serializeTrainee.dat");
        if(!file.exists())
            testSerialize();
        Trainee trainee = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            trainee = (Trainee)objectInputStream.readObject();
        } catch (IOException ex) {
            fail(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            fail(ex.getMessage());
        }
        try {
            assertEquals(new Trainee("Dmitry", "Александров", 4), trainee);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testSerializeInByteArray() {
        Trainee trainee = null;
        Trainee trainee1 = null;
        try {
            trainee = new Trainee("Dmitry", "Александров", 4);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(trainee);
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        byte[] bytes = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            trainee1 = (Trainee)objectInputStream.readObject();
        } catch (IOException ex) {
            fail(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            fail(ex.getMessage());
        }
        assertEquals(trainee1, trainee);
    }

    @Test
    public void testSerializeInByteBuffer() {
        Trainee trainee = null;
        Trainee trainee1;
        try {
            trainee = new Trainee("Dmitry", "Александров", 4);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        ByteBuffer byteBuffer;
        byteBuffer = ByteBuffer.wrap(SerializationUtils.serialize(trainee));
        byte[] bytes = new byte[byteBuffer.capacity()];
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            bytes[i] = byteBuffer.get();
        }
        trainee1 = (Trainee) SerializationUtils.deserialize(bytes);
        assertEquals(trainee1, trainee);
    }
}

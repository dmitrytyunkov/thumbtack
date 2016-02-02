package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.fifth.Trainee;
import net.thumbtack.tyunkov.lessons.fifth.TraineeException;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 08.11.15.
 */
public class ByteBufferTest {

    @Test
    public void testByteBuffer() {
        Trainee trainee = null;
        File file = new File("traineeSingleStr.txt");
        if (!file.exists()) {
            TextIOTest textIOTest = new TextIOTest();
            textIOTest.testFileWriterSingleStr();
        }
        try (FileChannel channel = new FileInputStream(file).getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
            channel.read(byteBuffer);
            byteBuffer.position(2);
            char[] chars = new char[byteBuffer.capacity()];
            for (int i = 0; i < byteBuffer.capacity() / 2 - 1; i++)
                chars[i] = byteBuffer.getChar();
            String string = new String(chars).trim();
            String[] strings = string.split("\t");
            Integer integer = Integer.valueOf(strings[2]);
            trainee = new Trainee(strings[0], strings[1], integer);
        } catch (FileNotFoundException ex) {
            fail(ex.getMessage());
        } catch (IOException ex) {
            fail(ex.getMessage());
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        try {
            assertEquals(new Trainee("Dmitry", "Александров", 4) ,trainee);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testMappedByteBufferRead() {
        Trainee trainee = null;
        File file = new File("traineeSingleStr.txt");
        if (!file.exists()) {
            TextIOTest textIOTest = new TextIOTest();
            textIOTest.testFileWriterSingleStr();
        }
        try (FileChannel channel = new RandomAccessFile(file, "rw").getChannel()) {
            MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, file.length());
            char[] chars = new char[mappedByteBuffer.capacity()];
            mappedByteBuffer.position(2);
            for(int i = 0; i < mappedByteBuffer.capacity() / 2 - 1; i++)
                chars[i] = mappedByteBuffer.getChar();
            String string = new String(chars).trim();
            String[] strings = string.split("\t");
            Integer integer = Integer.valueOf(strings[2]);
            trainee = new Trainee(strings[0], strings[1], integer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
        try {
            assertEquals(new Trainee("Dmitry", "Александров", 4) ,trainee);
        } catch (TraineeException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testMappedByteBufferWrite() {
        final int SIZE = 100;
        byte[] bytes = new byte[SIZE];
        byte[] bytes1 = new byte[SIZE];
        File file = new File("sequence.dat");
        if (file.exists()) {
            file.delete();
        }
        try (FileChannel channel = new RandomAccessFile(file, "rw").getChannel()) {
            MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, SIZE);
            for(byte i = 0; i < SIZE; i++) {
                mappedByteBuffer.put(i);
                bytes[i] = i;
                mappedByteBuffer.position(i);
                bytes1[i] = mappedByteBuffer.get();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertArrayEquals(bytes ,bytes1);
    }
}

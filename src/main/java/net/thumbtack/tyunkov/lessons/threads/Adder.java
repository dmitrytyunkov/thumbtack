package net.thumbtack.tyunkov.lessons.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dmitry on 29.11.15.
 */
public class Adder implements Runnable {
    List<Integer> list;
    Thread thread;

    public Adder(ArrayList<Integer> list) {
        this.list = list;
        thread = new Thread();
        thread.start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000; i++)
            synchronized (list) {
                list.add(new Random().nextInt(50));
            }
    }
}

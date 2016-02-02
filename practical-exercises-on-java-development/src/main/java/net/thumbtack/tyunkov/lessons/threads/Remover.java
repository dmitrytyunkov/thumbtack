package net.thumbtack.tyunkov.lessons.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dmitry on 29.11.15.
 */
public class Remover implements Runnable {
    List<Integer> list;
    Thread thread;

    public Remover(List<Integer> list) {
        this.list = list;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++)
            synchronized (list) {
                if (list.size() > 0)
                    list.remove(new Random().nextInt(list.size()));
                else
                    i--;
            }
    }

    public Thread getThread() {
        return thread;
    }
}

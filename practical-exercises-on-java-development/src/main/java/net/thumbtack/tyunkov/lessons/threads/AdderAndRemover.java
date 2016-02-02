package net.thumbtack.tyunkov.lessons.threads;

import java.util.List;
import java.util.Random;

/**
 * Created by dmitry on 29.11.15.
 */
public class AdderAndRemover implements Runnable {
    List<Integer> list;
    Thread thread;

    public AdderAndRemover(List<Integer> list) {
        this.list = list;
        thread = new Thread(this);
        thread.start();

    }

    synchronized private void add(List<Integer> list, Integer element) {
        list.add(element);
    }

    synchronized private void remove(List<Integer> list, Integer index) {
        list.remove(index);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++)
            add(list, new Random().nextInt(50));
        for (int i = 0; i < 10000; i++)
            if (list.size() > 0)
                remove(list, new Random().nextInt(list.size()));
            else
                i--;
    }

    public Thread getThread() {
        return thread;
    }
}

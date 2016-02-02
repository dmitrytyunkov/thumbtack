package net.thumbtack.tyunkov.lessons.threads;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by dmitry on 29.11.15.
 */
class AdderAndRemover implements Runnable {
    List<Integer> list;
    Thread thread;

    public AdderAndRemover(List<Integer> list) {
        this.list = list;
        thread = new Thread(this);
        thread.start();
    }

    synchronized private void add(int element) {
        list.add(element);
    }

    synchronized private void remove(int index) {
        list.remove(index);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
            Collections.synchronizedList(list).add(new Random().nextInt(50));
        for (int j = 0; j < 10; j++)
            if (list.size() > 0) {
                Collections.synchronizedList(list).remove(new Random().nextInt(list.size()));
            }
            else
                j--;
    }

    public Thread getThread() {
        return thread;
    }
}

public class AddAndRemov {

}

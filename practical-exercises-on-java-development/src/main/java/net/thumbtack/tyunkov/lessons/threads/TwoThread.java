package net.thumbtack.tyunkov.lessons.threads;

/**
 * Created by dmitry on 29.11.15.
 */
public class TwoThread implements Runnable {
    String name;
    Thread thread;

    public TwoThread(String name) {
        this.name = name;
        thread = new Thread(this, this.name);
        System.out.println("Create new thread: " + thread);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Start thread: " + thread);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End thread: " + thread);
    }

    public Thread getThread() {
        return thread;
    }
}

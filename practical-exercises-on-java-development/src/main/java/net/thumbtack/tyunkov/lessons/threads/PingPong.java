package net.thumbtack.tyunkov.lessons.threads;

import java.util.concurrent.Semaphore;

/**
 * Created by dmitry on 29.11.15.
 */
    class Monitor {
        static Semaphore semPong = new Semaphore(0);
        static Semaphore semPing = new Semaphore(1);

        void pong() {
            try {
                semPong.acquire();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
            
            System.out.println("pong");
            semPing.release();
        }

        void ping() {
            try {
                semPing.acquire();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }

            System.out.println("ping");
            semPong.release();
        }
    }

    class Ping implements Runnable {
        Monitor monitor;

        Ping(Monitor q) {
            this.monitor = q;
            new Thread(this, "Ping").start();
        }

        public void run() {
            while (true)
                monitor.ping();
        }
    }

    class Pong implements Runnable {
        Monitor q;

        Pong(Monitor q) {
            this.q = q;
            new Thread(this, "Pong").start();
        }

        public void run() {
            while (true)
                q.pong();
        }
    }

    public class PingPong {
        public static void main(String args[]) {
            Monitor q = new Monitor();
            new Ping(q);
            new Pong(q);
        }
    }

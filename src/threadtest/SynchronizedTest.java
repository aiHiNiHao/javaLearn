package threadtest;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

public class SynchronizedTest {
    public static byte[] b1 = new byte[1];
    public static byte[] b2 = new byte[1];
    public static void main(String[] args) {
//        new Thread1().start();
//        System.out.println("********");
//        new Thread2().start();
//        System.out.println("********");


        new Thread3("333").start();
        new Thread4("444").start();

    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (SynchronizedTest.class) {
                for (int i = 0; i < 10; i++) {
                    try {
                        sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread111");
                }
            }
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (SynchronizedTest.class) {
                System.out.println("thread222");
            }
        }
    }

    private static class Thread3 extends Thread {
        public Thread3(String s) {
            super(s);
        }

        @Override
        public void run() {
            synchronized (b1) {
                for (int i = 0; i < 100; i++) {
                    try {
                        b1.notify();
                        b1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread333");
                }
            }
        }
    }

    private static class Thread4 extends Thread {
        public Thread4(String s) {
            super(s);
        }
        @Override
        public void run() {
            synchronized (b1) {
                for (int i = 0; i < 100; i++) {
                    b1.notify();
                    try {
                        b1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread444");
                }
            }
        }
    }
}

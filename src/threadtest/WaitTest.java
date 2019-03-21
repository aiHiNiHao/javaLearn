package threadtest;

public class WaitTest {
    public static void main(String[] args) {
        new Thread1().start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread2().start();
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (WaitTest.class) {
                System.out.println("thread1 run");

                try {
                    WaitTest.class.wait();//挂起线程

                    System.out.println("thread1 over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (WaitTest.class) {
                System.out.println("thread2 run");

                WaitTest.class.notify();

                System.out.println("thread2 over");

            }
        }
    }
}

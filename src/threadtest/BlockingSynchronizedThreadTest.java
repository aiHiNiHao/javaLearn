package threadtest;

import java.util.concurrent.LinkedBlockingQueue;

public class BlockingSynchronizedThreadTest {
    int size = 10;
    LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue(size);
    int flag = 0;

    private class BlockingRunnable implements Runnable {

        @Override
        public void run() {
            if (flag++ == 0) {
                for (int i = 0; i < size * 2; i++) {
                    try {
                        queue.put(queue.size());
                        System.out.println("生产了==" + queue.size());
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            } else {

                for (int i = 0; i < size * 2; i++) {
                    try {
                        queue.put(queue.size());
                        System.out.println("---生产了==" + queue.size());
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

//                while (true) {
//                    try {
//                        Integer take = queue.take();
//                        System.out.println("------得到了==" + take);
//                        Thread.sleep(150);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingSynchronizedThreadTest bst = new BlockingSynchronizedThreadTest();
        BlockingRunnable runnable = bst.new BlockingRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}

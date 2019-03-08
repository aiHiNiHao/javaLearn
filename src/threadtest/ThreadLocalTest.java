package threadtest;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalTest {
    static int count = 0;
    public static void main(String[] args){
        SaveCount saveCount = new SaveCount();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (Thread.currentThread().getName().equals("111")){
                        saveCount.saveAdd();
                    }else{
                        saveCount.saveMinus();
                    }

                    System.out.println("count = "+saveCount.getCount()+"---" + Thread.currentThread());
                }

            }
        };
        new Thread(runnable, "111").start();
        new Thread(runnable, "222").start();
    }

    static class SaveCount{
        ReentrantLock lock = new ReentrantLock(true);
        public void saveAdd(){
            lock.lock();
            try {
                count ++;
                count ++;
            }finally {
                lock.unlock();
            }
        }

        public void saveMinus(){
            lock.lock();
            try {
                count --;
                count --;
            }finally {
                lock.unlock();
            }
        }

        public int getCount(){
            return count;
        }
    }
}

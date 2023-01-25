package synchronizers.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    private static List<Integer> list = new ArrayList<>();
    private static Semaphore semaphore;

    public static void main(String[] args) throws InterruptedException {
        semaphore = new Semaphore(2, true);
        Thread thread1 = new Thread(new RunnableImpl());
        Thread thread2 = new Thread(new RunnableImpl());
        Thread thread3 = new Thread(new RunnableImpl());
        Thread thread4 = new Thread(new RunnableImpl());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        while (list.size() < 3) {
            Thread.sleep(300);
            System.out.println(list.size());
            System.out.println(thread1.getState());
            System.out.println(thread2.getState());
            System.out.println(thread3.getState());
            System.out.println(thread4.getState());
        }
        Thread.sleep(2000);
        System.out.println("---");
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
        System.out.println(thread3.getState());
        System.out.println(thread4.getState());
    }

    static class RunnableImpl implements Runnable {

        @Override
        public void run() {
            try {
                semaphore.acquire();
                list.add(1);
                Thread.sleep(2000);
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

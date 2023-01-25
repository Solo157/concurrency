package synchronizers.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    private static CyclicBarrier barrier = new CyclicBarrier(3, () -> {
        System.out.println("Поехали!");
    });
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new RunnableImpl());
        Thread thread2 = new Thread(new RunnableImpl());
        Thread thread3 = new Thread(new RunnableImpl());
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        Thread.sleep(2000);
        thread3.start();
    }

    static class RunnableImpl implements Runnable {

        @Override
        public void run() {
            try {
                barrier.await();
                System.out.println(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

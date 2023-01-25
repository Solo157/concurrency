package synchronizers.countdownlatch;

import ch.qos.logback.core.joran.conditional.ThenAction;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Thread thread1 = new Thread(() -> {
            try {
                latch.await();
                System.out.println("Let's go 1!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                latch.await();
                System.out.println("Let's go 2!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
        thread1.join(100);
        thread2.join(100);
        for (int i = 1; i < 3; i++) {
            Thread.sleep(500);
            System.out.println(i);
            latch.countDown();
        }

    }
}

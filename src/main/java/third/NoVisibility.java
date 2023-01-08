package third;

import java.util.concurrent.atomic.AtomicInteger;

public class NoVisibility {

    static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) {
        new Writer().start();
        new Reader().start();
    }

    static class Writer extends Thread {
        @Override
        public void run() {
            while (i.intValue() < 5) {
                System.out.println("inc: " + i.incrementAndGet());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Reader extends Thread {
        @Override
        public void run() {
            int localInt = i.get();
            while (localInt < 5) {
                localInt = i.get();
                if (localInt != i.get()) {
                    System.out.println(localInt);
                }
            }
        }
    }
}

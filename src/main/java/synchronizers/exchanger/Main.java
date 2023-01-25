package synchronizers.exchanger;

import java.util.concurrent.Exchanger;

public class Main {
    private static Exchanger exchanger;
    public static void main(String[] args) {
        exchanger = new Exchanger();
        Thread thread1 = new Thread(new RunnableImpl());
        Thread thread2 = new Thread(new RunnableImpl2());
        thread1.start();
        thread2.start();
    }

    static class RunnableImpl implements Runnable {

        @Override
        public void run() {
            try {
                Integer number = (Integer) exchanger.exchange(100);
                System.out.println("Thread1 "+ number);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class RunnableImpl2 implements Runnable {

        @Override
        public void run() {
            try {
                Integer number = (Integer) exchanger.exchange(200);
                System.out.println("Thread2 "+ number);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

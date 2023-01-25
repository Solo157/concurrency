package interrupted;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TaskRunnable());
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.isInterrupted());
    }
}


class TaskRunnable implements Runnable {

    public void run() {
        try {
            System.out.println(Thread.currentThread());
            throw new InterruptedException();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
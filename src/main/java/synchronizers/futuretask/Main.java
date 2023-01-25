package synchronizers.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            {
                return 157000 * 2;
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();


        try {
            System.out.println(futureTask.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

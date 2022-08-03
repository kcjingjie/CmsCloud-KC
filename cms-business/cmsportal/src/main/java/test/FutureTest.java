package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * callable thread
 */
public class FutureTest {

    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> myCallableFuture = new FutureTask<>(myCallable);
        Thread thread1 = new Thread(myCallableFuture);
        thread1.start();

        try {
            String s = myCallableFuture.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
class MyCallable implements Callable<String> {


    @Override
    public String call() throws Exception {
        return "test"+Thread.currentThread().getName();
    }
}


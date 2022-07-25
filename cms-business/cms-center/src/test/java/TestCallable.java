import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 */
public class TestCallable {
    public static void main(String[] args) {
        ExecutorService e= Executors.newFixedThreadPool(10);
        Future f1=e.submit(new MyCallableA());
        Future f2=e.submit(new MyCallableA());
        Future f3=e.submit(new MyCallableA());
        System.out.println("--Future.get()....");
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        }

        e.shutdown();

    }


}

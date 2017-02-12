import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 12.02.2017.
 */
public class Main {

    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();
        Object monitor = new Object();


        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < args.length; i++) {
            Thread thread = new Parser(args[i],dictionary, monitor);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }

        }

    }
}

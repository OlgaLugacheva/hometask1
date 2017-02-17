import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 16.02.2017.
 */
public class MainTest {

    @Test
    void checkResources() {
        String[] resource1 = {"C:\test2.txt"};

        Object monitor = new Object();

        Dictionary dictionary = new Dictionary();

        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < resource1.length; i++) {
            Thread thread = new Parser(resource1[i], dictionary, monitor);
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

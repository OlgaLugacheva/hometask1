package semaphor;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Olga on 17.02.2017.
 */
public class Main {

    public static final int SIMPLE = 1;
    public static final int QUAD = 2;
    public static final int CUBE = 3;

    public static void main(String[] args) {

        int[] massInt = { 1, 2, 3, 4};
        List<Thread> threads = new ArrayList();
        Consumer consumer1 = new Consumer(new Semaphor());
        Thread cube = new Thread(new Cubator(massInt, consumer1));
        Thread cube2 = new Thread(new Cubator(massInt, consumer1));
        Thread pros = new Thread(new Prostator(massInt, consumer1));
        Thread pros2 = new Thread(new Prostator(massInt, consumer1));
        Thread qudro = new Thread(new Quadrator(massInt, consumer1));
        Thread qudro2 = new Thread(new Quadrator(massInt, consumer1));
        threads.add(cube);
        threads.add(cube2);
        threads.add(pros);
        threads.add(pros2);
        threads.add(qudro);
        threads.add(qudro2);

        for (Thread thread: threads){
            thread.start();
        }
        for (Thread thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(consumer1.getSum());
    }
}
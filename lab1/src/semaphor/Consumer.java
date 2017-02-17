package semaphor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Olga on 17.02.2017.
 */
public class Consumer {
    private AtomicInteger sum = new AtomicInteger(0);
    Semaphor semaphor = null;

    public Consumer(Semaphor semaf) {
        semaphor = semaf;
    }

    public void message(int cuba, int quad, int pros){

        if(cuba > 0){
            semaphor.enter(0);
        } else if (quad > 0){
            semaphor.enter(1);
        } else {
            semaphor.enter(2);
        }
        int current = sum.addAndGet(cuba + quad + pros);
        System.out.println("Current : " + current);
    }

    public int getSum() {
        return sum.get();
    }
}

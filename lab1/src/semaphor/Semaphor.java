package semaphor;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Olga on 17.02.2017.
 */
public class Semaphor {

    private AtomicBoolean lockCub = new AtomicBoolean(false);
    private AtomicBoolean lockQuad = new AtomicBoolean(false);
    private AtomicBoolean lockSimp = new AtomicBoolean(false);

    Semaphor() {

    }

    public void enter(int lock){
        if (lock == 0){
            set(lockCub);
        } else if (lock == 1){
            set(lockQuad);
        } else {
            set(lockSimp);
        }
    }

    private void set(AtomicBoolean lock){
        while (!lock.compareAndSet(false, true)){
            Thread.yield();
        }
        lock.set(false);
    }
        }

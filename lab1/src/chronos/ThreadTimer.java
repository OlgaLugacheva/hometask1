package chronos;

/**
 * Created by Olga on 08.02.2017.
 */
public class ThreadTimer extends Thread {

    private final Time time;

    public ThreadTimer(Time time) {
        this.time = time;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            try {
                Thread.sleep(1000);
                this.time.increment();
                System.out.printf("Time is %d second \n", this.time.getTime());
                synchronized (this.time) {
                    this.time.notifyAll();
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

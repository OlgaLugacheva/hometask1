package semaphor;

/**
 * Created by Olga on 17.02.2017.
 */
public class Quadrator implements Runnable{
    int[] intsLocal;
    Consumer consumer;


    public Quadrator(int[] ints, Consumer cons) {
        intsLocal = ints;
        consumer = cons;
    }

    @Override
    public void run() {
        for (int i : intsLocal){
            consumer.message(0,i*i, 0);
        }
    }
}

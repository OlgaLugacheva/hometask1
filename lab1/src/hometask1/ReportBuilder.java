package hometask1;

import org.apache.log4j.Logger;

import java.util.Arrays;
/**
 * Created by Olga on 12.02.2017.
 */
public class ReportBuilder extends Thread {

    private static Logger log = Logger.getLogger(ReportBuilder.class);
    private Dictionary dictionary;
    static Object monitor;


    public ReportBuilder(Dictionary dictionary, Object monitor) {
        this.dictionary = dictionary;
        this.monitor = monitor;
        setDaemon(true);
    }



    @Override
    public void run() {
        while (!isInterrupted()){
            synchronized (monitor) {
                try {
                    monitor.wait();
                    System.out.println("Count is");
                    printResult();
                } catch (InterruptedException e) {
                    log.error("Unexpected error", e);
                }
            }
        }
    }

    /**
     * Выводит отчёт по найденным словам
     */
    public void printResult(){

       log.info(Arrays.asList(dictionary.getWordDictionary()).toString());

    }
}

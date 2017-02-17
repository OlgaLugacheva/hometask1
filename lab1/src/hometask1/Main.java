package hometask1;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 12.02.2017.
 */
public class Main {
    private static Logger log = Logger.getLogger(Main.class);


    public static void main(String[] args) {

        log.info("Program run");

        Object monitor = new Object();
        Dictionary dictionary = new Dictionary();
        ReportBuilder report = new ReportBuilder(dictionary, monitor);
        report.start();

        List<InputStream> resources = new ArrayList<>();
        File[] files = new File(String.format("%s/homework1/temp", System.getProperties().get("user.dir"))).listFiles();
        for (File file : files) {
            try {
                InputStream resource = new FileInputStream(file);
                resources.add(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        report.printResult();

        Sum sum = new Sum();
        for (InputStream resource : resources) {
            new Thread(new Parser(sum, resource, dictionary, monitor)).start();
        }
    }
}

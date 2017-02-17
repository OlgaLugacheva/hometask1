package hometask1;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Olga on 12.02.2017.
 */
public class Parser extends Thread {

    String path;
    Dictionary Dictionary;
    Object monitor;
    private final Sum sum ;
    private final InputStream resource;

    public static volatile boolean isStop = false;

    public Parser(Sum sum, InputStream resource, Dictionary dictionary, Object monitor) {
        this.path = path;
        this.Dictionary = dictionary;
        this.monitor = monitor;
        this.sum = sum;
        this.resource = resource;
    }

    @Override
    public void run() {
        Scanner scanner = null;
        //            scanner = new Scanner(getSource(path));
        scanner = new Scanner(resource);
        try {
            parse(scanner);
        } catch (InterruptedException e) {
        }
    }


    /**
     * Ищет слова в ресурсе
     * @param scanner
     */
    private void parse(Scanner scanner) throws InterruptedException {
        scanner.useDelimiter(Symbols.PUNCTUATION_MARKS);
        while (scanner.hasNext() && !isStop) {

            String token = scanner.next();

            if (!(token==null)) {
                try {
                    if (verify(token, Symbols.SYMBOLS)) {
                        Dictionary.add(token, monitor);
                    }
                } catch (SymbolException invalidSymbolExeption) {
                    isStop = true;
                    invalidSymbolExeption.printStackTrace();
                    throw new InterruptedException();
                }
            }

        }
    }

    private static boolean verify(String token, String pattern) throws SymbolException {
        if (token.matches(pattern)) {
            return true;
        } else {
            throw new SymbolException("invalid symbol : " + token);
        }
    }


    private InputStream getSource(String source) throws IOException {

        if (source.startsWith("http:") || source.startsWith("ftp:") ||
                source.startsWith("file:")) {
            URL url = new URL(source);

            return url.openStream();
        } else if (new File(source).isFile()) {

            return new FileInputStream(source);

        } else {

            return new ByteArrayInputStream(source.getBytes());

        }

    }
}

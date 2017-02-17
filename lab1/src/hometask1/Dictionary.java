package hometask1;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

/**
 * Created by Olga on 12.02.2017.
 */
public class Dictionary {
    private Map<String, Integer> wordDictionary = new ConcurrentHashMap<String, Integer>();

    /**
     * Добавление слова
     * @param word -  слово
     * @param monitor - монитор для синхронизации потоков
     */
    public void add(String word, Object monitor) {

        word = word.toLowerCase();

        synchronized (monitor) {
            if (!wordDictionary.containsKey(word)) {
                wordDictionary.put(word, 1);
            } else {
                int count = wordDictionary.get(word);
                wordDictionary.put(word, ++count);
            }
            monitor.notifyAll();//
        }

    }

    @Test
    public void checkWordAddition() {
        add("word", new Object());
        assertEquals(wordDictionary.size(), 1);
        assertNotEquals(wordDictionary.size(), 0);
        add("СЛОВО", new Object());
        assertEquals(wordDictionary.size(), 1);
    }



    public Map<String, Integer> getWordDictionary() {
        return wordDictionary;
    }
}

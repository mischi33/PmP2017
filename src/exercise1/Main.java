package exercise1;

import exercise1.filters.CircularShifts;
import exercise1.filters.LinesToWords;
import exercise1.filters.TextSourceA;
import exercise1.filters.TextSourceB;
import pmp.pipes.SimplePipe;

import java.io.StreamCorruptedException;
import java.util.List;

/**
 * Created by Michelle on 23.10.2017.
 */
public class Main {
    public static void main(String[] args) {
//        TextSourceA textSource = new TextSourceA("path");
//        SimplePipe<List<String>> pipe = new SimplePipe<>(textSource);
//        try {
//            pipe.read();
//        } catch (StreamCorruptedException e) {
//            e.printStackTrace();
//        }

        TextSourceA testSource = new TextSourceA("test.txt");
        try {
            List<String> testLines = testSource.read();
           for (String s : testLines) {
                System.out.println(s);
            }
            LinesToWords testLinesToWords = new LinesToWords(testSource);
            List<List<String>> testWords = testLinesToWords.process(testLines);
            CircularShifts testCircularShifts = new CircularShifts(testLinesToWords);
            List<List<String>>testci=testCircularShifts.process(testWords);
            for (List<String> line : testci) {
                
                System.out.println(line);

            }
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        }
    }
}

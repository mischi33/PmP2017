package exercise1;

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
        TextSourceA textSource = new TextSourceA("path");
        SimplePipe<List<String>> pipe = new SimplePipe<>(textSource);
        try {
            pipe.read();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        }
    }
}

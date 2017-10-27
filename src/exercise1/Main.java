package exercise1;

import exercise1.filters.TextSourceB;
import pmp.pipes.SimplePipe;

import java.io.StreamCorruptedException;

/**
 * Created by Michelle on 23.10.2017.
 */
public class Main {
    public static void main(String[] args) {
        TextSourceB<String> textSource = new TextSourceB<>("path");
        SimplePipe<String> pipe = new SimplePipe<>(textSource);
        try {
            pipe.read();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        }
    }
}

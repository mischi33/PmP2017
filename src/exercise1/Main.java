package exercise1;

import exercise1.filters.*;
import pmp.pipes.SimplePipe;

import java.io.StreamCorruptedException;
import java.util.List;

/**
 * Created by Michelle on 23.10.2017.
 */
public class Main {
    public static void main(String[] args) {
        TextSourceA textSourceA = new TextSourceA("test.txt");
        SimplePipe<List<String>> simplePipe = new SimplePipe<>(textSourceA);

        RemoveSpecialChars removeSpecialChars = new RemoveSpecialChars(textSourceA);
        LinesToWords linesToWords = new LinesToWords(removeSpecialChars);
        CircularShifts circularShifts = new CircularShifts(linesToWords);
        UselessWordsFilter uselessWordsFilter = new UselessWordsFilter(circularShifts);
        SortFilter sortFilter = new SortFilter(uselessWordsFilter);

    }
}

package exercise1;

import exercise1.filters.*;
import pmp.filter.Sink;
import pmp.filter.Source;
import pmp.interfaces.Writeable;
import pmp.pipes.SimplePipe;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.StreamCorruptedException;
import java.util.List;

/**
 * Created by Michelle on 23.10.2017.
 */
public class Main {
    public static void main(String[] args) {
       // String targetFilePath = args[0];
        Sink writeToFileSink = new WriteToFileSink("index.txt");
        SimplePipe pipe_1 = new SimplePipe(writeToFileSink);
        SortFilter sortFilter = new SortFilter(pipe_1);
        SimplePipe pipe_2 = new SimplePipe((Writeable) sortFilter);
        WordsToLines wordsToLines = new WordsToLines(pipe_2);
        SimplePipe pipe_3 = new SimplePipe((Writeable) wordsToLines);
        UselessWordsFilter uselessWordsFilter = new UselessWordsFilter(pipe_3);
        SimplePipe pipe_4 = new SimplePipe((Writeable) uselessWordsFilter);
        CircularShifts circularShifts = new CircularShifts(pipe_4);
        SimplePipe pipe_5 = new SimplePipe((Writeable) circularShifts);
        LinesToWords linesToWords = new LinesToWords(pipe_5);
        SimplePipe pipe_6 = new SimplePipe((Writeable) linesToWords);
        RemoveSpecialChars removeSpecialChars = new RemoveSpecialChars(pipe_6);
        SimplePipe pipe_7 = new SimplePipe((Writeable) removeSpecialChars);
        Source source = new TextSourceA(pipe_7, "test.txt");
        source.run();



    }
}

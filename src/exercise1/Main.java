package exercise1;

import exercise1.filters.*;
import pmp.filter.Sink;
import pmp.filter.Source;
import pmp.interfaces.Writeable;
import pmp.pipes.SimplePipe;

/**
 * Created by Michelle on 23.10.2017.
 */
public class Main {
    public static void main(String[] args) {
       // String targetFilePath = args[0];
        exerciseA("");
        exerciseB("");


    }

    private static void exerciseA(String path) {
        Sink writeToFileSink = new WriteToFileSink(path + "indexA.txt");
        SimplePipe pipe_1 = new SimplePipe(writeToFileSink);
        SortWordsFilter sortFilter = new SortWordsFilter(pipe_1);
        SimplePipe pipe_2 = new SimplePipe((Writeable) sortFilter);
        WordsToLines wordsToLines = new WordsToLines(pipe_2);
        SimplePipe pipe_3 = new SimplePipe((Writeable) wordsToLines);
        UselessWordsFilter uselessWordsFilter = new UselessWordsFilter(pipe_3);
        SimplePipe pipe_4 = new SimplePipe((Writeable) uselessWordsFilter);
        CircularShift circularShifts = new CircularShift(pipe_4);
        SimplePipe pipe_5 = new SimplePipe((Writeable) circularShifts);
        LineToWords linesToWords = new LineToWords(pipe_5);
        SimplePipe pipe_6 = new SimplePipe((Writeable) linesToWords);
        RemoveSpecialChars removeSpecialChars = new RemoveSpecialChars(pipe_6);
        SimplePipe pipe_7 = new SimplePipe((Writeable) removeSpecialChars);
        Source source = new TextSourceA(pipe_7, "aliceInWonderland.txt");
        source.run();
    }

    private static void exerciseB(String s) {
        TextSourceB textSourceB=new TextSourceB("test.txt");

    }

}

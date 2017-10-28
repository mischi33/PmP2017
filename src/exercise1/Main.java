package exercise1;

import exercise1.filters.*;
import exercise1.pipes.DoubleExitPipe;
import pmp.filter.Sink;
import pmp.filter.Source;
import pmp.interfaces.Writeable;
import pmp.pipes.SimplePipe;

/**
 * Created by Michelle on 23.10.2017.
 */
public class Main {
    public static void main(String[] args) {
        String alignment = "center";
        int lineLength = 15;
        String path = "";

        if (args.length > 0) {
            if (args[0].equals("-h")) {
                System.out.println("HELP for Exercise1 Pipes&Filters");
                System.out.println("First Parameter: Alignment -> alignment of the result files.");
                System.out.println("Second Parameter: Line Length -> line length of each line in the index file and the newly created source file.");
                System.out.println("Third Parameter: Path -> choose the directory where the result files should be stored (existing Directory).");
                System.out.println("Example: java -jar PipesAndFilters.jar center 60 C:\\John\\Documents\\");
                System.exit(0);
            }

            alignment = args[0];
            lineLength = Integer.valueOf(args[1]);
            path = args[2];
        }

        if (alignment == null || alignment.isEmpty() || (!"right".equalsIgnoreCase(alignment) && !"left".equalsIgnoreCase(alignment) && !"center".equalsIgnoreCase(alignment))) {
            System.out.println("Unknown alignment-option, default value [left] will be used.");
            alignment = "left";
        }
        if (path == null || path.isEmpty()) {
            path = "";
        }
        if (lineLength == 0) {
            lineLength = 60;
        }
        exerciseA(path);
        exerciseB(path, alignment, lineLength);


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
        RemoveSpecialChars removeSpecialChars = new RemoveSpecialChars(pipe_5);
        SimplePipe pipe_6 = new SimplePipe((Writeable) removeSpecialChars);
        LineToWords linesToWords = new LineToWords(pipe_6);
        SimplePipe pipe_7 = new SimplePipe((Writeable) linesToWords);
        Source source = new TextSourceA(pipe_7, "aliceInWonderland.txt");
        source.run();
    }

    private static void exerciseB(String path, String alignment, int lineLength) {
        Sink indexSink = new WriteToFileSink(path + "indexB.txt");
        Sink storySink = new WriteNewTextToFileSink(path + "aliceInWonderlandNew.txt");
        SimplePipe pipe_1 = new SimplePipe(indexSink);
        SortWordsFilter sortWordsFilter = new SortWordsFilter(pipe_1);
        SimplePipe pipe_2 = new SimplePipe((Writeable) sortWordsFilter);
        AlignmentFilter alignmentFilter1 = new AlignmentFilter(pipe_2, lineLength, alignment);
        SimplePipe pipe_a = new SimplePipe((Writeable) alignmentFilter1);
        WordsToLines wordsToLines = new WordsToLines(pipe_a);
        SimplePipe pipe_3 = new SimplePipe((Writeable) wordsToLines);
        UselessWordsFilter uselessWordsFilter = new UselessWordsFilter(pipe_3);
        SimplePipe pipe_4 = new SimplePipe((Writeable) uselessWordsFilter);
        CircularShift circularShift = new CircularShift(pipe_4);
        SimplePipe pipe_5 = new SimplePipe(storySink);
        AlignmentFilter alignmentFilter = new AlignmentFilter(pipe_5, lineLength, alignment);
        DoubleExitPipe doubleExitPipe = new DoubleExitPipe(alignmentFilter, circularShift);
        ComposeLineFilter composeLineFilter = new ComposeLineFilter(doubleExitPipe, lineLength);
        SimplePipe pipe_6 = new SimplePipe((Writeable) composeLineFilter);
        ComposeWordFilter composeWordFilter = new ComposeWordFilter(pipe_6);
        SimplePipe pipe_7 = new SimplePipe((Writeable) composeWordFilter);
        Source source = new TextSourceB(pipe_7, "test.txt");
        source.run();
    }

}

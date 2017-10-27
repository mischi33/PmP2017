package exercise1.filters;

import pmp.filter.Sink;
import pmp.interfaces.Readable;

import java.io.*;
import java.util.List;

/**
 * Created by Michelle on 27.10.2017.
 */
public class WriteToFileSink extends Sink<List<String>> {
    private String _file;

    public WriteToFileSink(Readable<List<String>> input, String file) {
        super(input);
        _file = file;
    }

    @Override
    public void write(List<String> value) throws StreamCorruptedException {
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(_file), "UTF-8"));
                for (String line : value) {
                    writer.write(line);
                    writer.write(System.getProperty("line.separator"));
                }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

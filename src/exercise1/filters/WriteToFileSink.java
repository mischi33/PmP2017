package exercise1.filters;

import pmp.filter.Sink;

import java.io.*;
import java.util.List;

/**
 * Created by Michelle on 27.10.2017.
 */
public class WriteToFileSink extends Sink<List<List<String>>> {
    private String _file;

    public WriteToFileSink(String file) {
        _file = file;
    }

    @Override
    public void write(List<List<String>> value) throws StreamCorruptedException {
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(_file), "UTF-8"));
            for (List<String> line : value) {
                for (String word : line) {
                    writer.write(word + " ");
                }
                writer.write(System.getProperty("line.separator"));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

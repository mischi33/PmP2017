package exercise1.filters;

import pmp.filter.Sink;

import java.io.*;
import java.util.List;

/**
 * Created by Flo on 28.10.17.
 */
public class WriteNewTextToFileSink extends Sink<List<String>> {
    private String _file;
    private BufferedWriter _writer;


    public WriteNewTextToFileSink(String file) {
        _file = file;
        try {
            _writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(_file), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(List<String> value) throws StreamCorruptedException {
        if (value != null) {
            try {
                for (String line : value) {
                    _writer.write(line);
                }
                _writer.write(System.getProperty("line.separator"));
                _writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

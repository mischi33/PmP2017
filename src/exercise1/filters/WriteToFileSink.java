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
    private BufferedWriter _writer;

    public WriteToFileSink(Readable<List<String>> input, String file) {
        super(input);
        _file = file;
        try {
            _writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(_file), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public WriteToFileSink(String file) {
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
                    _writer.write(System.getProperty("line.separator"));
                }
                _writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

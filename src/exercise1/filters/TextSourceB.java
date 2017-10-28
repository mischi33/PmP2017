package exercise1.filters;

import pmp.filter.Source;
import pmp.interfaces.Writeable;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class TextSourceB extends Source<Character> {
    private String _filename;
    private BufferedReader _br;

    public TextSourceB(Writeable<Character> output, String filename) {
        super(output);
        _filename = filename;
        try {
            _br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(_filename))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Character read() throws StreamCorruptedException {
        try {
            int charVal;
            if ((charVal = _br.read()) != -1) {
                return (char) charVal;
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

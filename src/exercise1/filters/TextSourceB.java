package exercise1.filters;

import pmp.filter.Source;
import pmp.interfaces.Writeable;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class TextSourceB<T extends List<Character>> extends Source {
    String _filename;

    public TextSourceB(String filename) {
        super();
        _filename = filename;
    }

    @Override
    public List<Character> read() throws StreamCorruptedException {
        List<Character> characters = new ArrayList<>();
        try {
            Charset encoding = Charset.forName("UTF-8");
            InputStream in = new FileInputStream(_filename);
            Reader reader = new InputStreamReader(in, encoding);
            Reader buffer = new BufferedReader(reader);

            int c;
            while ((c = buffer.read()) != -1) {
                characters.add((char) c);
            }

            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}

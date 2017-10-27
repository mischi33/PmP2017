package exercise1.filters;

import pmp.filter.Source;
import pmp.interfaces.Writeable;

import java.io.*;

/**
 * Created by Michelle on 27.10.2017.
 */
public class TextSourceA extends Source<String> {
    private String _filename;
    private BufferedReader _br;

    public TextSourceA(Writeable<String> output, String filename) {
        super(output);
        _filename = filename;
        try {
            _br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(_filename))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read() throws StreamCorruptedException {
        try {
            String line = _br.readLine();
            while (line != null && line.isEmpty()) {
                line = _br.readLine();
            }
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package exercise1.filters;

import pmp.filter.Source;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michelle on 27.10.2017.
 */
public class TextSourceA extends Source<List<String[]>> {
    String _filename;

    @Override
    public List<String[]> read() throws StreamCorruptedException {
        List<String[]> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(_filename))));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                lines.add(words);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

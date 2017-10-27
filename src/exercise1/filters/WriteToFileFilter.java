package exercise1.filters;

import pmp.filter.DataTransformationFilter1;
import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by Michelle on 27.10.2017.
 */
public class WriteToFileFilter extends DataTransformationFilter1<List<List<String>>> {
    private String _file;

    public WriteToFileFilter(Readable<List<List<String>>> input) throws InvalidParameterException {
        super(input);
        _file = "index.txt";
    }

    @Override
    public void process(List<List<String>> entity) {
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(_file), "UTF-8"));
            for (List<String> line : entity) {
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

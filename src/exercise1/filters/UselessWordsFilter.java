package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Michelle on 27.10.2017.
 */
public class UselessWordsFilter extends DataTransformationFilter2<List<List<String>>, List<List<String>>>{
    private List<String> _uselessWords;

    public UselessWordsFilter(Writeable<List<List<String>>> input) throws InvalidParameterException {
        super(input);
        List<String> uselessWords = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("frequentWords.txt"))));
            String line;
            while ((line = br.readLine()) != null) {
                uselessWords.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        _uselessWords = uselessWords;
    }

    @Override
    public List<List<String>> process(List<List<String>> entity) {
        Iterator<List<String>> lineIterator = entity.iterator();
        while (lineIterator.hasNext()) {
            List<String> line = lineIterator.next();
            for (String uselessWord : _uselessWords) {
                if (line.get(0).equalsIgnoreCase(uselessWord)) {
                    lineIterator.remove();
                    break;
                }
            }
        }
        return entity;
    }
}

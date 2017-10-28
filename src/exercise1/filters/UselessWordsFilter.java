package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Writeable;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Michelle on 27.10.2017.
 */
public class UselessWordsFilter extends DataTransformationFilter2<List<List<String>>, List<List<String>>> {
    private Map<String, String> _uselessWords;

    public UselessWordsFilter(Writeable<List<List<String>>> input) throws InvalidParameterException {
        super(input);
        Map<String, String> uselessWords = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("frequentWords.txt"))));
            String line;
            while ((line = br.readLine()) != null) {
                uselessWords.put(line.toUpperCase(), line.toUpperCase());
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
            if (_uselessWords.containsKey(line.get(0).toUpperCase()) || line.get(0).equals("")) {
                lineIterator.remove();
            }

        }
        return entity;
    }
}

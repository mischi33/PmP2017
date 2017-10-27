package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michelle on 27.10.2017.
 */
public class LinesToWords extends DataTransformationFilter2<List<String>, List<String[]>> {

    public LinesToWords(Readable<List<String>> input) throws InvalidParameterException {
        super(input);
    }

    @Override
    protected List<String[]> process(List<String> entity) {
        List<String[]> words = new ArrayList<>();
        for (String s : entity) {
            words.add(s.split(" "));
        }
        return words;
    }
}
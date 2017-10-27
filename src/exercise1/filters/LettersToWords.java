package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michelle on 23.10.2017.
 */
public class LettersToWords<T extends List<Character>,S extends List<String>> extends DataTransformationFilter2<T, S> {


    public LettersToWords(Readable<T> input) throws InvalidParameterException {
        super(input);
    }

    @Override
    protected S process(T entity) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Character c : entity) {
            sb.append(c);
            if (c.equals(' ')) {
                words.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return words;
    }

}

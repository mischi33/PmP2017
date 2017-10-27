package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michelle on 23.10.2017.
 */
public class LettersToWords extends DataTransformationFilter2<List<Character>, List<String>> {


    public LettersToWords(Writeable<List<String>> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected List<String> process(List<Character> entity) {
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

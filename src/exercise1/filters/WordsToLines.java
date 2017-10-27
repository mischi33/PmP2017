package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flo on 27.10.17.
 */
public class WordsToLines extends DataTransformationFilter2<List<List<String>>, List<String>> {

    public WordsToLines(Readable<List<List<String>>> input) throws InvalidParameterException {
        super(input);
    }

    @Override
    protected List<String> process(List<List<String>> entity) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < entity.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < entity.get(i).size(); i++) {
                sb.append(entity.get(i).get(j));
            }
            result.add(sb.toString());
        }
        return result;
    }
}

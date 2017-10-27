package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flo on 27.10.17.
 */
public class WordsToLines extends DataTransformationFilter2<List<List<String>>, List<String>> {


    public WordsToLines(Writeable<List<String>> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected List<String> process(List<List<String>> entity) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < entity.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < entity.get(i).size(); j++) {
                sb.append(entity.get(i).get(j) + " ");
            }
            result.add(sb.toString());
        }
        return result;
    }
}

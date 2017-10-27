package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Michelle on 27.10.2017.
 */
public class LineToWords extends DataTransformationFilter2<String, List<String>> {


    public LineToWords(Writeable<List<String>> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    public List<String> process(String entity) {
        List<String> words = Arrays.asList(entity.split(" "));
        return words;
    }
}

package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by Michelle on 27.10.2017.
 */
public class UselessWordsFilter extends DataTransformationFilter2<List<List<String>>, List<String>>{

    public UselessWordsFilter(Readable<List<List<String>>> input) throws InvalidParameterException {
        super(input);
    }

    @Override
    protected List<String> process(List<List<String>> entity) {
        return null;
    }
}

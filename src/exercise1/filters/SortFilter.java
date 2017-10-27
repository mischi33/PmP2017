package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Michelle on 27.10.2017.
 */
public class SortFilter extends DataTransformationFilter2 <List<String>, List<String>>{


    public SortFilter(Writeable<List<String>> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected List<String> process(List<String> entity) {
       Collections.sort(entity);
       return entity;
    }
}

package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flo on 27.10.17.
 */
public class RemoveSpecialChars extends DataTransformationFilter2<List<String>, List<String>> {


    public RemoveSpecialChars(Readable<List<String>> input) throws InvalidParameterException {
        super(input);
    }

    @Override
    public List<String> process(List<String> entity) {

        List<String>result= new ArrayList<String>();

        for (int i = 0; i < entity.size(); i++) {
           result.add(entity.get(i).replaceAll("[^\\w\\s]",""));
        }

        return result;
    }
}

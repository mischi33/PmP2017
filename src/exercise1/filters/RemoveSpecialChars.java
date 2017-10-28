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
public class RemoveSpecialChars extends DataTransformationFilter2<String, String> {


    public RemoveSpecialChars(Writeable<String> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected String process(String entity) {
        /**
         * "[^\w\s]" removes all special characters (except "_")
         * "  +" removes all empty lines that appear more than once
         * ^\s+ removes all whitespace characters at the beginning of a line
         * "_" removes underscore since this does not work with the first regex
         */
        return entity.replaceAll("[^\\w\\s]","").replaceAll("  +", "").replaceAll("^\\s+","").replaceAll("_", "");
    }
}

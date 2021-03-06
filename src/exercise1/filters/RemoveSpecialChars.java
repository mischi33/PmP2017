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
public class RemoveSpecialChars extends DataTransformationFilter2<List<String>, List<String>> {
    public RemoveSpecialChars(Writeable<List<String>> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected List<String> process(List<String> entity) {
        List<String> newEntity = new ArrayList<>();

        for (String s : entity) {
            /**
             * "[^\w\s]" removes all special characters from the whole text (except "_" "-" and "'")
             * "^[\\W]+" removes all special chars at the beginning of a sentence.
             * "_" removes underscore since this does not work with the first regex
             * "^[0-9]+" removes numbers at the beginning of a line.
             */
            newEntity.add(s.replaceAll("[^\\w\\s-']", "").replaceAll("^[\\W]+", "").replaceAll("_", "").replaceAll("^[0-9]+", ""));

        }
        return newEntity;
    }
}


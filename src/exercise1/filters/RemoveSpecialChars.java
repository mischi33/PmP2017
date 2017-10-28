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
             * "[^\w\s]" removes all special characters (except "_")
             * "_" removes underscore since this does not work with the first regex
             * "-" "--" replaces this with a space since some words would be unnecessarily concatenated.
             */
            newEntity.add(s.replaceAll("-", " ").replaceAll("--", " ").replaceAll("[^\\w\\s]", "").replaceAll("_", ""));

        }
        return newEntity;
    }
}


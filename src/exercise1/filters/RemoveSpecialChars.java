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
        String newEntity = entity.replaceAll("[^\\w\\s]","");
        newEntity = newEntity.replaceAll("  +", "");
        newEntity = newEntity.replaceAll("^\\s+","");
        return newEntity;
    }
}

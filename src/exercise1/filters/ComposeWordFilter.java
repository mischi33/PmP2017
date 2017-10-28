package exercise1.filters;

import pmp.filter.DataCompositionFilter;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;

/**
 * Created by Michelle on 27.10.2017.
 */
public class ComposeWordFilter extends DataCompositionFilter<Character, String> {


    public ComposeWordFilter(Writeable<String> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected boolean fillEntity(Character nextVal, String entity) {
        if (nextVal != null && nextVal != ' ' && nextVal != '\n' && nextVal != '\r' && nextVal != '\t') {
            entity=entity+nextVal;
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected String getNewEntityObject() {
        return new String();
    }
}

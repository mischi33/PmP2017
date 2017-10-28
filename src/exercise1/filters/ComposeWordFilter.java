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
        StringBuilder sb= new StringBuilder();
        sb.append(entity);
        if (nextVal != ' ' && nextVal != '\n' && nextVal != '\t') {
            sb.append(nextVal);
            entity=sb.toString();
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

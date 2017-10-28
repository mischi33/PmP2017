package exercise1.filters;

import pmp.filter.DataCompositionFilter;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;

/**
 * Created by Michelle on 27.10.2017.
 */
public class ComposeWordFilter extends DataCompositionFilter<Character, StringBuilder> {


    public ComposeWordFilter(Writeable<StringBuilder> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected boolean fillEntity(Character nextVal, StringBuilder entity) {

        if (nextVal!=null && !(nextVal == ' ' || nextVal =='\n' || nextVal =='\t' || nextVal=='\r' )) {
            entity.append(nextVal);

            return false;
        } else {
            return true;
        }
    }

    @Override
    protected StringBuilder getNewEntityObject() {
        return new StringBuilder();
    }
}

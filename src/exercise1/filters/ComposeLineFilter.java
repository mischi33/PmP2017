package exercise1.filters;

import pmp.filter.DataCompositionFilter;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flo on 28.10.17.
 */
public class ComposeLineFilter extends DataCompositionFilter<StringBuilder, List<String>> {
    private int _linelength = 0;
    private int neededLength;
    private StringBuilder lostValue;

    public ComposeLineFilter(Writeable<List<String>> output, int lineLength) throws InvalidParameterException {
        super(output);
        neededLength = lineLength;
    }


    @Override
    protected boolean fillEntity(StringBuilder nextVal, List<String> entity) {
        if (lostValue != null) {
            entity.add(lostValue.toString());
            lostValue = null;
        }
        if (nextVal != null && (_linelength + nextVal.length() + 1) <= neededLength) {
            entity.add(nextVal.toString());
            entity.add(" ");
            return false;
        }
        if (nextVal != null)
            lostValue = nextVal.toString();
        _linelength = 0;
        return true;
    }

    @Override
    protected List<String> getNewEntityObject() {
        return new ArrayList<>();
    }
}

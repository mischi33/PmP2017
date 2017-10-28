package exercise1.filters;

import pmp.filter.DataCompositionFilter;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flo on 28.10.17.
 */
public class ComposeLineFilter extends DataCompositionFilter<String, List<String>> {
    private int _linelength = 0;
    private int neededLength;
    private String lostValue;

    public ComposeLineFilter(Writeable<List<String>> output, int lineLenth) throws InvalidParameterException {
        super(output);
        neededLength = lineLenth;
    }

    @Override
    protected boolean fillEntity(String nextVal, List<String> entity) {
        if (lostValue != null) {
            entity.add(lostValue);
            lostValue = null;
        }
        if (nextVal != null && (_linelength + nextVal.length() + 1) <= neededLength) {
            entity.add(nextVal);
            entity.add(" ");
            return false;
        }
        lostValue = nextVal;
        _linelength = 0;
        return true;
    }

    @Override
    protected List<String> getNewEntityObject() {
        return new ArrayList<>();
    }
}

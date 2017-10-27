package exercise1.filters;

import pmp.filter.DataCompositionFilter;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Michelle on 27.10.2017.
 */
public class SortWordsFilter extends DataCompositionFilter<List<String>, List<String>> {
    public SortWordsFilter(Writeable<List<String>> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected boolean fillEntity(List<String> nextVal, List<String> entity) {
        if (nextVal != null) {
            for (String s : nextVal) {
                entity.add(s);
            }
            return false;
        } else {
            Collections.sort(entity, String.CASE_INSENSITIVE_ORDER);
            return true;
        }
    }

    @Override
    protected List<String> getNewEntityObject() {
        return new ArrayList<>();
    }
}

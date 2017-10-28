package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michelle on 28.10.2017.
 */
public class AddSpaceFilter extends DataTransformationFilter2<List<String>, List<String>> {

    public AddSpaceFilter(Writeable<List<String>> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected List<String> process(List<String> entity) {
        List<String> newEntity = new ArrayList<>();
        newEntity.add(entity.get(0));
        for (int i = 1; i < entity.size(); i++) {
            if (!entity.get(i).isEmpty()) {
                newEntity.add(" ");
                newEntity.add(entity.get(i));
            }
        }
        return newEntity;
    }
}

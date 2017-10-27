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
public class CircularShift extends DataTransformationFilter2<List<String>, List<List<String>>> {


    public CircularShift(Writeable<List<List<String>>> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected List<List<String>> process(List<String> entity) {
        List<List<String>> result = new ArrayList<>();
        int shift = 0;
        List<String> line = new ArrayList<>();
        line.addAll(entity);
        ArrayList<String> resultLine = new ArrayList<>();
        while (shift < line.size()) {
            for (int j = 0; j < line.size(); j++) {
                resultLine.add(line.get(j));
            }
            result.add(resultLine);
            resultLine= new ArrayList<>();
            String tmp = line.get(0);
            line.remove(0);
            line.add(tmp);
            shift++;

        }
        return result;
    }


}

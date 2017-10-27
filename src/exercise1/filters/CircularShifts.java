package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flo on 27.10.17.
 */
public class CircularShifts extends DataTransformationFilter2<List<ArrayList<String>>, List<ArrayList<String>>> {

    List<ArrayList<String>> result = new ArrayList<>();

    public CircularShifts(Readable<List<ArrayList<String>>> input) throws InvalidParameterException {
        super(input);
    }


    @Override
    protected List<ArrayList<String>> process(List<ArrayList<String>> entity) {
        for (int i = 0; entity.size() < i; i++) {
            int shift = 0;
            ArrayList<String> line = entity.get(i);
            ArrayList<String> resultLine = new ArrayList<>();
            while (shift < line.size()) {
                for (int j = 0; j < line.size(); j++) {
                    resultLine.clear();
                    resultLine.add(line.get(j));
                }
                result.add(resultLine);
                String tmp = line.get(0);
                line.remove(0);
                line.add(tmp);
                shift++;
            }

        }
        return result;
    }


}

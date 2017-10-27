package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flo on 27.10.17.
 */
public class CircularShifts extends DataTransformationFilter2<List<List<String>>, List<List<String>>> {

    List<List<String>> result = new ArrayList<>();

    public CircularShifts(Readable<List<List<String>>> input) throws InvalidParameterException {
        super(input);
    }

    @Override
    protected List<List<String>> process(List<List<String>> entity) {
        for (int i = 0; i < entity.size(); i++) {
            int shift = 0;
            List<String> line = new ArrayList<>();
            line.addAll(entity.get(i));
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

        }
        return result;
    }


}

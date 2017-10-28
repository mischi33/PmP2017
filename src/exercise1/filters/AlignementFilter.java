package exercise1.filters;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flo on 28.10.17.
 */
public class AlignementFilter extends DataTransformationFilter2<List<String>, List<String>> {

    private int _lineLength;
    private String _align;

    public AlignementFilter(Writeable<List<String>> output, int lineLength, String align) throws InvalidParameterException {
        super(output);
        _lineLength = lineLength;
        _align = align;
    }

    @Override
    protected List<String> process(List<String> entity) {

        return align(entity, _align);
    }

    public List<String> align(List<String> list, String align) {
        String listString = "";
        for (String s : list) {
            listString += s;
        }
        int neededSpaces = _lineLength - listString.length();
        List<String> alignList = new ArrayList<>();
        if (align.equals("right")) {
            for (int i = neededSpaces; 0 < i; i--) {
                alignList.add(" ");
            }
        }
        if (align.equals("centre")) {
            for (int i = neededSpaces / 2; 0 < i; i--) {
                alignList.add(" ");
            }
        }

        alignList.addAll(list);

        return alignList;
    }

}

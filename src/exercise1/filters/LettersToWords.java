package exercise1.filters;

import pmp.filter.DataCompositionFilter;
import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michelle on 23.10.2017.
 */
public class LettersToWords extends DataCompositionFilter<Character, String> {

    private StringBuilder sb= new StringBuilder();

    public LettersToWords(Writeable<String> output) throws InvalidParameterException {
        super(output);
    }


    @Override
    protected boolean fillEntity(Character nextVal, String entity) {
       
        if(entity.equals(' ')){

            return true;
        }
        sb.append(entity);
        return false;
    }

    @Override
    protected String getNewEntityObject() {
        return null;
    }
}

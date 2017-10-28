package exercise1.pipes;

import pmp.interfaces.IOable;
import pmp.interfaces.Writeable;

import java.io.StreamCorruptedException;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by Michelle on 28.10.2017.
 */
public class DoubleExitPipe implements IOable<List<String>, List<String>>{
    private Writeable<List<String>> output_1;
    private Writeable<List<String>> output_2;

    public DoubleExitPipe(Writeable<List<String>> output_1, Writeable<List<String>> output_2) {
        this.output_1 = output_1;
        this.output_2 = output_2;

    }

    @Override
    public List<String> read() throws StreamCorruptedException {
        return null;
    }

    @Override
    public void write(List<String> value) throws StreamCorruptedException {
        if (output_1 == null || output_2 == null) {
            throw new InvalidParameterException("output filter can't be null!");
        }
        output_1.write(value);
        output_2.write(value);
    }
}

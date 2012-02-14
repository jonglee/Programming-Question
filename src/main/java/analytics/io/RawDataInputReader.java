package analytics.io;

import analytics.core.WordProcessor;

import java.io.File;
import java.io.IOException;

/**
 * Reader API to parse the input
 */
public interface RawDataInputReader {

    void parse(File f, WordProcessor processor) throws IOException;

}

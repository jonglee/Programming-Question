package analytics.io;

import analytics.core.Word;

import java.io.IOException;

/**
 * Writer API to for the results
 */
public interface AnalyzedResultsWriter {

    void writeOrderedWords(Word[] orderedWords) throws IOException;
}


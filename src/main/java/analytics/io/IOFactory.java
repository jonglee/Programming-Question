package analytics.io;

import analytics.core.Word;
import analytics.core.WordProcessor;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Observable;
import java.util.StringTokenizer;

/**
 * Factory to get the reader and writer
 */
public final class IOFactory {

    public static RawDataInputReader getReader() {
        return new RawDataInputReaderImpl();
    }

    public static AnalyzedResultsWriter getWriter() {
        return new AnalyzedResultsToConsole();
    }


    //reader impl using RandomAccessFile and StringTokenizer to parse the input
    private static class RawDataInputReaderImpl extends Observable implements RawDataInputReader {

        @Override
        public void parse(File f, WordProcessor processor) throws IOException {
            //use the observer pattern here
            //advantage is not to have another collection/array and ask the process to loop on that
            //we can process the Word one by one while reading the file
            addObserver(processor);

            RandomAccessFile raf = new RandomAccessFile(f, "r");
            try {
                String line;

                while ((line = raf.readLine()) != null) {

                    //from the sample output, it seems we need to ignore punctuation character in addition to whitespaces
                    StringTokenizer st = new StringTokenizer(line, " \t,;.!?", false);
                    while (st.hasMoreTokens()) {
                        fireEvent(st.nextToken());
                    }
                }
            } finally {
                raf.close();
            }
        }

        private void fireEvent(String s) {
            setChanged();
            notifyObservers(s);
            clearChanged();
        }
    }

    //the results will go to console
    private static class AnalyzedResultsToConsole implements AnalyzedResultsWriter {

        @Override
        public void writeOrderedWords(Word[] orderedWords) throws IOException {
            for (Word word : orderedWords) {
                System.out.println(word);
            }
        }
    }
}

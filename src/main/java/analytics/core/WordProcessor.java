package analytics.core;

import java.util.Observer;

/**
 * API to process a document
 */
public interface WordProcessor extends Observer {

    /**
     * Get the ordered list of Words
     */
    Word[] getOrderedWords();

    //other interesting analytics functions, such as getMostOccured() etc...

}

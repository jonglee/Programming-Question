package analytics.core;

/**
 * Factory to get a Word Processor
 */
public final class WordProcessorFactory {

    public static WordProcessor getProcessor() {
        return new WordProcessorImpl();
    }
    
}

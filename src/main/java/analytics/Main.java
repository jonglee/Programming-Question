package analytics;

import analytics.core.WordProcessor;
import analytics.core.WordProcessorFactory;
import analytics.io.IOFactory;

import java.io.File;
import java.io.IOException;

/**
 * Program Entry point
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            printUsage();
        }

        WordProcessor processor = WordProcessorFactory.getProcessor();
        IOFactory.getReader().parse(new File(args[0]), processor);
        IOFactory.getWriter().writeOrderedWords(processor.getOrderedWords());
    }

    private static void printUsage() {
        System.out.println("Usage: java analytics.Main [input file]");
        System.exit(0);
    }
}

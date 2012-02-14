package analytics.io;

import analytics.TestingUtil;
import analytics.core.Word;
import analytics.core.WordProcessor;
import analytics.core.WordProcessorFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class IOFactoryTest {
    private WordProcessor processor;
    private RawDataInputReader reader;
    private AnalyzedResultsWriter writer;

    @Before
    public void init() {
        processor = WordProcessorFactory.getProcessor();
        reader = IOFactory.getReader();
        writer = IOFactory.getWriter();
    }

    @Test
    public void testSampleInput() throws IOException {
        reader.parse(TestingUtil.getTestFile("SampleInput.txt"), processor);
        Word[] orderedWords = processor.getOrderedWords();
        TestingUtil.assertOrderedWordResults(
                newWordsArray(new Word("The", 1),
                        new Word("fox", 1), new Word("the", 1), new Word("back", 1), new Word("lazy", 1),
                        new Word("over", 1), new Word("brown", 2), new Word("dog's", 1),
                        new Word("quick", 1), new Word("jumped", 1)), orderedWords);
        writer.writeOrderedWords(orderedWords);
    }

    @Test
    public void testEmpty() throws IOException {
        reader.parse(TestingUtil.getTestFile("Empty.txt"), processor);
        TestingUtil.assertOrderedWordResults(new Word[0], processor.getOrderedWords());
    }

    @Test
    public void testMultiLines() throws IOException {
        reader.parse(TestingUtil.getTestFile("MultiLines.txt"), processor);
        TestingUtil.assertOrderedWordResults(
                newWordsArray(new Word("\"", 2), new Word("foo", 1),
                        new Word("`%skipping", 1), new Word("multi-tabs", 1)), processor.getOrderedWords());
        writer.writeOrderedWords(processor.getOrderedWords());
    }

    public static Word[] newWordsArray(Word... words) {
        Word[] wordArray = new Word[words.length];
        int i = 0;
        for (Word word : words) {
            wordArray[i++] = word;
        }

        return wordArray;
    }
}

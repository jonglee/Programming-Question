package analytics.core;

import analytics.TestingUtil;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

public class WordProcessorTest {
    private WordProcessor processor;

    @Before
    public void init() {
        processor = WordProcessorFactory.getProcessor();
    }


    @Test
    public void testRepeatedSingleItem() {
        runTestScenario(ImmutableList.of("a", "a"), new Word[]{ newWord("a", 2) });
    }

    @Test
    public void testSimpleList() {
        runTestScenario(ImmutableList.of("This", "is", "a", "test"),
                new Word[] {
                        newWord("a", 1),
                        newWord("is", 1),
                        newWord("This", 1),
                        newWord("test", 1)});
    }

    @Test
    public void testRepeatedMultiItems() {
        runTestScenario(ImmutableList.of("Foobar", "foobar", "foo", "bar", "foobar", "foobar", "Foobar"),
                new Word[]{
                        newWord("bar", 1),
                        newWord("foo", 1),
                        newWord("Foobar", 2),
                        newWord("foobar", 3)});
    }

    private void runTestScenario(ImmutableList<String> inputList, Word[] expectedSortedItems) {
        for (String s : inputList) {
            processor.update(null, s);
        }

        TestingUtil.assertOrderedWordResults(expectedSortedItems, processor.getOrderedWords());
    }

    private static Word newWord(String value, int count) {
        Word word = new Word();
        word.setValue(value);
        word.setNumOccurred(count);
        return word;
    }
}

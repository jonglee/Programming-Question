package analytics;

import analytics.core.Word;
import junit.framework.Assert;

import java.io.File;
import java.util.Arrays;

/**
 * util class for testing
 */
public class TestingUtil {

    /**
     * load Test file from test/testdata directory
     * @param fileName   file to load
     * @return           File
     */
    public static File getTestFile(String fileName) {
        return new File(new File("src/test/testdata"), fileName);
    }

    /**
     * Assert both Word arrays are equal
     * @param expected   expected result
     * @param actual     actual result
     */
    public static void assertOrderedWordResults(Word[] expected, Word[] actual) {
        Assert.assertTrue("Expected same ordered list", Arrays.equals(expected, actual));
    }
}

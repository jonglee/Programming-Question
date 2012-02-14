package analytics.core;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class WordComparatorTest {
    private static WordComparator comparator;

    @BeforeClass
    public static void setUp() {
        comparator = new WordComparator();
    }

    @Test
    public void testFirstNull() {
        Assert.assertEquals("First arg NULL", -1, comparator.compare(null, "foo"));
    }

    @Test
    public void testSecondNull() {
        Assert.assertEquals("Second arg NULL", 1, comparator.compare("foo", null));
    }

    @Test
    public void testAllNulls() {
        Assert.assertEquals("All NULLs", -1, comparator.compare(null, null));
    }


    @Test
    public void testFirstEmpty() {
        Assert.assertEquals("First arg empty", -1, comparator.compare("", "foo"));
    }

    @Test
    public void testSecondEmpty() {
        Assert.assertEquals("Second arg NULL", 1, comparator.compare("foo", ""));
    }

    @Test
    public void testAllEmpty() {
        Assert.assertEquals("All empty", -1, comparator.compare("", ""));
    }

    @Test
    public void testNullSameAsEmpty() {
        Assert.assertEquals("Null same as empty", -1, comparator.compare("", null));
        Assert.assertEquals("Null same as empty", -1, comparator.compare(null, ""));
    }

    @Test
    public void testDifferentLengthFirstArg() {
        Assert.assertEquals("Expect shorter len first arg", -1, comparator.compare("f", "ab"));
    }

    @Test
    public void testDifferentLengthSecondArg() {
        Assert.assertEquals("Expect shorter len second arg", 1, comparator.compare("ab", "f"));
    }

    @Test
    public void testLessFirstArg() {
        Assert.assertTrue("Expect first arg less", comparator.compare("The", "the") < 0);
    }

    @Test
    public void testLessSecondArg() {
        Assert.assertTrue("Expect second arg less", comparator.compare("a", "`") > 0);
    }
}

package analytics.core;

/**
 * A POJO to represent each word in a sentence 
 */
public class Word {

    private String value;
    private int numOccurred;

    public Word() { }

    public Word(String value, int numOccurred) {
        this.value = value;
        this.numOccurred = numOccurred;
    }

    public int getNumOccurred() {
        return numOccurred;
    }

    public void setNumOccurred(int numOccurred) {
        this.numOccurred = numOccurred;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word item = (Word) o;

        if (numOccurred != item.numOccurred) return false;
        if (value != null ? !value.equals(item.value) : item.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numOccurred;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return numOccurred + " " + value;
    }

}

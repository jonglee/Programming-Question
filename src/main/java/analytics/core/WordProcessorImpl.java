package analytics.core;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

import java.util.Iterator;
import java.util.Observable;
import java.util.Set;

/**
 * An impl using Google collection to handle the count and sorting
 * should look into building own data structure if have time...
 */
class WordProcessorImpl implements WordProcessor {

    private final Multiset<String> set = TreeMultiset.create(new WordComparator());


    @Override
    public void update(Observable observable, Object o) {
        set.add((String) o);
    }

    @Override
    public Word[] getOrderedWords() {

        //look at the elements set which is already sorted
        Set<String> elements = set.elementSet();
        int size = elements.size();

        Word[] items = new Word[size];

        Iterator<String> iter = elements.iterator();
        int i = 0;
        while(iter.hasNext()) {
            String value = iter.next();
            items[i++] = new Word(value, set.count(value));
        }

        return items;

    }

}


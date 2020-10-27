import java.util.ArrayList;

public class WordBucket3 {
    private ArrayList<Word> list;
    private int word_count;

    public WordBucket3() {
        list = new ArrayList<>();
        word_count = 0;
    }

    // Worst case: O(N)
    // Best case : O(1)
    public void add(String word) {
        add(word, 1);
    }

    // Worst case: O(N)
    // Best case : O(1)
    public void add(String word, int count) {
        int index = findWord(word);
        if ( index == -1 ) {
            list.add( new Word(word, count) );
            index = list.size()-1;
        } else {
            list.get(index).incCount( count );
        }

        // Move it to its right place
        while ( index > 0 && list.get(index).getCount() > list.get(index-1).getCount() ) {
            list.add( index-1, list.get(index) );
            list.remove( index+1 );
            index--;
        }

        // Update word_count
        word_count += count;
    }

    // Worst case: O(N)
    // Best case : O(N)
    private int findWord(String word) {
        for (int i = 0; i < list.size(); i++) {
            if ( list.get(i).getWord().equals( word ) ) {
                return i;
            }
        }
        return -1;
    }


    // Worst case: O(1)
    // Best case : O(1)
    public int size() {
        return word_count;
    }

    // Worst case: O(N)
    // Best case : O(N)
    public int getCountOf(String word) {
        int index = findWord(word);
        if ( index == -1 ) {
            return 0;
        } else {
            return list.get(index).getCount();
        }
    }

    // Worst case: O(1)
    // Best case : O(1)
    public String getMostFreq() {
        return list.get(0).getWord();
    }

    // Worst case: O(N)
    // Best case : O(1)
    public String[] getNMostFreq(int num) {
        if ( num > list.size() || num < 1 ) {
            num = list.size();
        }
        String[] out = new String[num];

        for (int i = 0; i < num; i++) {
            out[i] = list.get(i).getWord();
        }
        return out;
    }


    // Worst case: O(1)
    // Best case : O(1)
    public int getNumUnique() {
        return list.size();
    }

    public void clear() {
        list = new ArrayList<>();
    }

    public String toString() {
        String out = "";
        for (Word W : list) {
            out += W.getWord() + "(" + W.getCount() + ") ";
        }
        return out;
    }
}
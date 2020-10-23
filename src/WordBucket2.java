import java.util.ArrayList;

public class WordBucket2 {
    private ArrayList<Word> list;

    public WordBucket2() {
        list = new ArrayList<>();
    }

    // Worst case: O(N)
    // Best case: O(1)
    public void add(String word) {
        int index = findWord(word);
        if ( index == -1 ) {
            list.add( new Word(word) );
        } else {
            list.get(index).incCount(1);
        }
    }

    // Worst case: O(N)
    // Best case: O(N)
    private int findWord(String word) {
        for (int i = 0; i < list.size(); i++) {
            if ( list.get(i).getWord().equals( word ) ) {
                    return i;
            }
        }
        return -1;
    }


    // Worst case: O(N)
    // Best case: O(1)
    public void add(String word, int count ) {
        int index = findWord(word);
        if ( index == -1 ) {
            list.add( new Word(word, count) );
        } else {
            list.get(index).incCount( count );
        }
    }

    // Worst case: O(N)
    // Best case: O(N)
    public int size() {
        int count = 0;
        for (Word w : list) {
            count += w.getCount();
        }
        return count;
    }

    // Worst case: O(N)
    // Best case: O(N)
    public int getCountOf(String word) {
        for (Word w : list) {
            if ( w.getWord().equals( word ) ) {
                return w.getCount();
            }
        }
        return 0;
    }

    // Worst case: O(N^2)
    // Best case: O(N)
    public String getMostFreq() {
        String most_freq_word = "";
        int most_freq_num = 0;
        for (Word w : list) {
            if ( w.getCount() > most_freq_num) {
                most_freq_num  = w.getCount();
                most_freq_word = w.getWord();
            }
        }
        return most_freq_word;
    }

    // Worst case: O(N^2)
    // Best case: O(N)
    public int getNumUnique() {
        ArrayList<String> unique = new ArrayList<>();
        list : for (Word w : list) {
            if (unique.contains(w.getWord())) {
                continue list;
            }
            unique.add( w.getWord() );
        }
        return unique.size();
    }
}
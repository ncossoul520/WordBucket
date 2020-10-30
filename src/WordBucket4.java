import java.util.HashMap;

public class WordBucket4 {
    private HashMap<String, Integer> counts;
    private int word_count;

    public WordBucket4() {
        counts = new HashMap<String, Integer>();
        word_count = 0;
    }

    // Worst case: O(1)
    // Best case : O(1)
    public void add(String word) {
        add(word, 1);
    }

    // Worst case: O(1)
    // Best case : O(1)
    public void add(String val, int count) {
        if ( counts.get(val) != null ){
            count = counts.get(val);
            counts.put(val, count+1);
        } else {
            counts.put(val, count);
        }

        // Update word_count
        word_count += count;
    }

    // Worst case: O(1)
    // Best case : O(1)
    public int size() {
        return word_count;
    }

    // Worst case: O(1)
    // Best case : O(1)
    public int getCountOf(String word) {
        if ( counts.get(word) == null ) {
            return 0;
        } else {
            return counts.get(word);
        }
    }

    // Worst case: O(N)
    // Best case : O(1)
    public String getMostFreq() {
        String most_freq_word = "";
        int most_freq_num = 0;
        for (String w : counts.keySet()) {
            int count = counts.get(w);
            if ( count > most_freq_num) {
                most_freq_num  = count;
                most_freq_word = w;
            }
        }
        return most_freq_word;
    }

    // Worst case: NA
    // Best case : NA
    public String[] getNMostFreq(int num) {
        String[] out = new String[] { getMostFreq() };
        return out;
    }

    // Worst case: O(1)
    // Best case : O(1)
    public int getNumUnique() {
        return counts.size();
    }

    public void clear() {
        counts = new HashMap<>();
    }

    public String toString() {
        String out = "";
        for (String w : counts.keySet()) {
            out += w + "(" + counts.get(w) + ") ";
        }
        return out;
    }
}
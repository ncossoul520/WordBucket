import java.util.ArrayList;

public class WordBucket {
    private ArrayList<String> list;

    public WordBucket() {
        list = new ArrayList<>();
    }

    // Worst case: O(1)
    // Best case: O(1)
    public void add(String word) {
        list.add(word);
    }

    // Worst case: O(1)
    // Best case: O(1)
    public void add(String word, int occurrence) {
        for (int i = 0; i < occurrence; i++) {
            list.add(word);
        }
    }

    // Worst case: O(1)
    // Best case: O(1)
    public int size() {
        return list.size();
    }

    // Worst case: O(N)
    // Best case: O(N)
    public int getCountOf(String word) {
        int count = 0;
        for (String w : list) {
            if ( w.equals( word ) ) {
                count++;
            }
        }
        return count;
    }

    // Worst case: O(N)
    // Best case: O(N)
    public String getMostFreq() {
        String most_freq_word = "";
        int most_freq_num = 0;
        for (String w : list) {
            int count = getCountOf(w);
            if (count > most_freq_num) {
                most_freq_num = count;
                most_freq_word = w;
            }
        }
        return most_freq_word;
    }

    public String[] getNMostFreq(int num) {
        return new String[] {"not implemented"};
    }

    // Worst case: O(N^2)
    // Best case: O(N)
    public int getNumUnique() {
        ArrayList<String> unique = new ArrayList<>();
        list : for (String w : list) {
            for (String u : unique) {
                if ( u.equals(w) ) {
                    continue list;
                }
            }
            unique.add(w);
        }
        return unique.size();
    }

    public void clear() {
        list = new ArrayList<>();
    }

    public String toString() {
        String out = "";
        for (String w : list) {
            out += w + " ";
        }
        return out;
    }
}

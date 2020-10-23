public class Word {
    private String word;
    private int count;

    public Word(String word) {
        this.word  = word;
        this.count = 1;
    }

    public Word(String word, int count) {
        this.word  = word;
        this.count = count;
    }

    public void incCount(int num) {
        count += num;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }
}

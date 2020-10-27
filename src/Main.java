import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        WordBucket bucket = new WordBucket();
//        WordBucket2 bucket = new WordBucket2();
        WordBucket3 bucket = new WordBucket3();

        bucket.add("a", 2);
        bucket.add("c");
        bucket.add("b");
        bucket.add("z", 100); // adds 100 z's

        System.out.println( bucket.getMostFreq() );   // returns "z"
        System.out.println( bucket.size() );          // returns 104
        System.out.println( bucket.getNumUnique() );  // returns 4 (only 4 different items)
        System.out.println( bucket.getCountOf("a") ); // returns 2

        bucket.clear();
        bucket.add("a", 4); // a4
        bucket.add("b", 2); // a4 b2
        bucket.add("c", 3); // a4 c3 b2
        bucket.add("d", 5); // d5 a4 c3 b2
        bucket.add("e");    // d5 a4 c3 b2 e1

        System.out.println( bucket.toString() );   // returns "d5 a4 c3 b2 e1"
        System.out.println( Arrays.toString( bucket.getNMostFreq(2) ));   // returns "d a4 c3 b2 e1"
    }
}

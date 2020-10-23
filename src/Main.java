public class Main {
    public static void main(String[] args) {
//        WordBucket bucket = new WordBucket();
        WordBucket2 bucket = new WordBucket2();

        bucket.add("a"); bucket.add("a"); bucket.add("c"); bucket.add("b"); bucket.add("z", 100); // adds 100 z's

        System.out.println(bucket.getMostFreq());   // returns "z"
        System.out.println(bucket.size());          // returns 104
        System.out.println(bucket.getNumUnique());  // returns 4 (only 4 different items)
        System.out.println(bucket.getCountOf("a")); // returns 2
    }
}

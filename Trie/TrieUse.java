public class TrieUse {
    public static void main(String[] args) {
        Tries t = new Tries();

        t.add("NOTE");
        t.add("NOT");
        t.add("ADD");

        System.out.println(t.search("NOT"));
        System.out.println(t.search("NO"));
        System.out.println(t.search("NOTES"));
        System.out.println(t.search("ADD"));
        System.out.println(t.search("ADDS"));
        
    }
}

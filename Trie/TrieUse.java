public class TrieUse {
    public static void main(String[] args) {
        Tries t = new Tries();

        t.add("NOTE");
        t.add("NOT");
        t.countWords();  // Output : 2  for two words added

        t.add("ADD");
        t.countWords(); // Output : 3   for third word added
        

        System.out.println("NOT Exist ? --> " + t.search("NOT"));  // Output : True
        System.out.println(t.search("NO")); // Output : False
        System.out.println(t.search("NOTES"));  // Output : False


        System.out.println("NOD Exist ? --> " + t.search("NOD"));  // Output : NOD Exist ? --> true
        
        t.remove("NOT");
        System.out.println("NOT Exist ? --> " + t.search("NOT")); // NOT Exist ? --> true

        t.remove("NOD");  // Output : Word Does Not Exist.

        System.out.println("NOD Exist ? --> " + t.search("NOD")); // Output : NOD Exist ? --> False

        t.countWords();  // Output : Number of Words --> 1   NOT was removed at Line:20 in code

        
    }
}

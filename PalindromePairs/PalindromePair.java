package PalindromePairs;
import java.util.*;

public class PalindromePair {

    public static boolean isPalindromePair(ArrayList<String> words) {

        Trie t = new Trie();

        for(String word : words){
            t.add(reverseString(word));
        }


        for(String word: words){
            if(findPair(t, word)){
                return true;
            }
        }

        return false;
	}

    public static boolean findPair(Trie t, String word){

        return t.search(word);
    }

    public static String reverseString(String s){
        StringBuilder sb = new StringBuilder("");
        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        
        ArrayList<String> words = new ArrayList<>();
        words.add("geeks");
        words.add("keeg");
        words.add("geekff");
        words.add("fkeeg");
        words.add("abccba");

        System.out.println(isPalindromePair(words));


    }
}

import java.util.HashMap;

public class checkAnagrams {

    public static String anagram(String ip1, String ip2) {
        if (ip1.length() != ip2.length()) {
            return "Not Anagrams";
        }
        ip1 = ip1.toLowerCase();
        ip2 = ip2.toLowerCase();
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char c : ip1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : ip2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if (map1.equals(map2)) {
            return "Anagrams";
        }
        return "not anagrams";
    }

    public static void main(String[] args) {
        String input1 = "race";
        String input2 = "aceR";
        System.out.println(anagram(input1, input2));
        ;
    }

}

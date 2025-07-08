import java.util.HashMap;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t){

        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Character> st = new HashMap<>();
        HashMap<Character, Character> ts = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if(st.containsKey(cs)){
                if(st.get(cs) != ct) return false;
            } else{
                st.put(cs, ct);
            }
            if(ts.containsKey(ct)){
                if(st.get(ct) != cs) return false;
            } else{
                st.put(ct, cs);
            }

        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));     // true
        System.out.println(isIsomorphic("foo", "bar"));     // false
        System.out.println(isIsomorphic("paper", "title")); // true
    }
}

public class removeDuplicates {

    public static void removeDup(String str, int i, StringBuilder newStr, boolean map[]) {
        if(i == str.length()){
            System.out.println(newStr.toString());
            return;
        }
        
        char currChar = str.charAt(i);

        if(currChar == ' '){
            newStr.append(currChar);
            removeDup(str, i+1, newStr, map);
        } else {
            if(map[currChar-'a'] == true){
                removeDup(str, i+1, newStr, map);
            } else{
                map[currChar-'a'] = true;
                removeDup(str, i+1, newStr.append(currChar), map);
            }
        }
    }
    public static void main(String[] args){
        String str = "abhijeet dutta";
        StringBuilder sb = new StringBuilder("");
        removeDup(str, 0, sb, new boolean[26]);
    }

}
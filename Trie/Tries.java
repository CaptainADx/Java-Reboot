
public class Tries {
    
    // ================CREATING ROOT FOR TRIE==================

    private TrieNode root;
    public int numberOfWords;

    public Tries(){
        root = new TrieNode('\0');
        numberOfWords = 0 ;

    }

    // ===============ADD METHOD IN TRIE=======================

    public void helperAdd(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminal = true;
            return;
        }

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];

        if(child == null){
            root.children[childIndex] = new TrieNode(word.charAt(0));
            root.childCount++;

        }

        helperAdd(child, word.substring(1));
    }

    public void add(String s){
        helperAdd(root, s);
        numberOfWords++;
    }

    //====================SEARCH METHOD IN TRIE======================

    public boolean helperSearch(TrieNode root, String word){
        if(word.length() == 0){
            return root.isTerminal;
        }
        
        int childIndex = word.charAt(0) - 'A';
        if(root.children[childIndex] == null) return false;

        return helperSearch(root.children[childIndex], word.substring(1));

        
    }

    public boolean search(String s){
        return helperSearch(root, s);
    }


    //====================REMOVE METHOD IN TRIE=======================
    public void helperRemove(TrieNode root, String word){
        if(word.length() == 0) {
            root.isTerminal = false;
            return;
        }

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
 
        if(child == null) {
            System.out.println("Word Does Not Exist");
            return;
        }

        helperRemove(child, word.substring(1));

        if(!child.isTerminal && child.childCount == 0){
            root.children[childIndex] = null;
            root.childCount--;
        }
    }

    public void remove(String s){
        helperRemove(root, s);
        numberOfWords--;
    }

    // ================COUNT NUMBER OF TERMINAL NODES IN TRIE=================
    public void countWords(){
        System.out.println("Number of words --> " + numberOfWords);
    }


}

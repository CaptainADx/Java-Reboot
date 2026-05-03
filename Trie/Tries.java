
public class Tries {
    
    private TrieNode root;

    public Tries(){
        root = new TrieNode('\0');
    }

    public void helperAdd(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminal = true;
            return;
        }
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];

        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
        }

        helperAdd(child, word.substring(1));

    }

    public void add(String s){
        helperAdd(root, s); 
    }

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



    public void remove(String s){

    }


}

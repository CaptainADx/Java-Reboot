package PalindromePair;

public class Trie {

    TrieNode root;
    int numberOfWords;
    
    Trie(){
        root = new TrieNode('\0');
        numberOfWords = 0;
    }


    //================ADD in Trie======================

    private void addHelper(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminal = true;
            return;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
        }

        addHelper(child, word.substring(1));
        
    }

    public void add(String word){
        addHelper(root, word);
        numberOfWords++;
    }


    //==================Search In Trie====================
    private boolean searchHelper(TrieNode root, String word){
        if(word.length() == 0){
            return root.isTerminal;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if(child == null){
            return false;
        }

        return searchHelper(child, word.substring(1));
    }

    public boolean search(String word){
        return searchHelper(root, word);
    }


}

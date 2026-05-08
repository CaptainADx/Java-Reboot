package PalindromePair;

public class TrieNode {
    char data;
    TrieNode[] children;
    boolean isTerminal;

    TrieNode(char data){
        this.data = data;
        children = new TrieNode[26];
        isTerminal = false;
    }
}

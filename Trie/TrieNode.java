public class TrieNode {
    char data;
    boolean isTerminal;
    TrieNode children[];

    public TrieNode(char c) {
        data = c;
        isTerminal = false;
        children = new TrieNode[26];
    }
    
}


class PrefixTree {
    // Use the TrieNode class to maintain structure
    private TrieNode head;
    public PrefixTree() {
        this.head = new TrieNode();
    }

    public void insert(String word) {
        // Check from the head, looping through all the letters in the key
        TrieNode x = head;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            // If there isn't a TrieNode at the index/char, make a new one, then move to it
            if (x.children[index] == null) {
                x.children[index] = new TrieNode();
            }
            x = x.children[index];
        }

        // Set this point to be the end of a word
        x.endOfWord = true;
    }
    
    public boolean search(String word) {
        // Check from the head, looping through all the letters in the key
        TrieNode x = head;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            // If the next character isn't already in the structure, the key isn't in the structure
            if (x.children[index] == null) return false;
            // Otherwise move onto the next TrieNode
            else x = x.children[index];
        }

        // Return whether or not it's the end of a word
        return x.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        // Check from the head, looping through all the letters in the key
        TrieNode x = head;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';

            // If the next character isn't already in the structure, the key isn't in the structure
            if (x.children[index] == null) return false;
            // Otherwise move onto the next TrieNode
            else x = x.children[index];
        }

        // Return true since the starting part is there
        return true;
    }
}
class TrieNode {
    TrieNode[] children;
    boolean endOfWord;
    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
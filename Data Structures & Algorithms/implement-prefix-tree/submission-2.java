class PrefixTree {
    // Maintain structure
    private PrefixTree[] children;
    boolean endOfWord;
    public PrefixTree() {
        children = new PrefixTree[26];
        endOfWord = false;
    }

    public void insert(String word) {
        // Check from the head, looping through all the letters in the key
        PrefixTree x = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';

            // If there isn't a TrieNode at the index/char, make a new one, then move to it
            if (x.children[index] == null) {
                x.children[index] = new PrefixTree();
            }
            x = x.children[index];
        }

        // Set this point to be the end of a word
        x.endOfWord = true;
    }
    
    public boolean search(String word) {
        // Check from the head, looping through all the letters in the key
        PrefixTree x = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';

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
        PrefixTree x = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';

            // If the next character isn't already in the structure, the key isn't in the structure
            if (x.children[index] == null) return false;
            // Otherwise move onto the next TrieNode
            else x = x.children[index];
        }

        // Return true since the starting part is there
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
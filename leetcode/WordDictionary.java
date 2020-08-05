class WordDictionary {

    /** Initialize your data structure here. */
    // Alphabet size (# of symbols) 
    final int ALPHABET_SIZE = 26; 
    int lvl = 0;
    class TrieNode 
    { 
        TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
       
        // isEndOfWord is true if the node represents 
        // end of a word 
        boolean isEndOfWord; 
          
        TrieNode(){ 
            isEndOfWord = false; 
            for (int i = 0; i < ALPHABET_SIZE; i++) 
                children[i] = null; 
        } 
    }; 

    // trie node 
    TrieNode root;  

    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String key) {
        if(key == "" || key == " ") return;
        int level; 
        int length = key.length(); 
        int index; 
       
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.charAt(level) - 'a'; 
            if (pCrawl.children[index] == null) 
            {   pCrawl.children[index] = new TrieNode(); 
                lvl++;
            }
            pCrawl = pCrawl.children[index]; 
        } 
       
        // mark last node as leaf 
        pCrawl.isEndOfWord = true; 
    }
    public boolean lookup(String key, int index, TrieNode curr)
    {
        if(index == key.length()) return curr.isEndOfWord;

        char ch = key.charAt(index);

        if(ch == '.')
        {
            for(int i = 0; i<ALPHABET_SIZE; i++)
            {
                if(curr.children[i]!=null && lookup(key, index+1, curr.children[i]))
                    return true;
            }
            return false;
        }
        else{
            if(curr.children[ch - 'a']!=null)
                return lookup(key, index+1, curr.children[ch - 'a']);
            return false;
        }
    }
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String key) {
        if(lvl<key.length()) return false;
        return lookup(key, 0, root);
    }
// [[],["a"],["a"],["."],["a"],["aa"],["a"],[".a"],["a."]]
/*
["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
[[],["at"],["and"],["an"],
["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
*/
    public static void main(String []args)
    {
        WordDictionary d = new WordDictionary();
        String []words = {"", "at", "and","an"};
        String []look = {"add", "a", ".at", "bat", ".at", "an.", "a.d.", "b.", "a.d","."};
        for(String s : words)
            d.addWord(s);
        
        for(String s: look)
            System.out.println(d.search(s));
    }
}


class TrieNode{
    HashMap<Character, TrieNode> kids;
    boolean isWord;
    
    public TrieNode(){
        this.kids = new HashMap<Character, TrieNode>();
        this.isWord = false;
    }
}

class WordDictionary {
    TrieNode dictionary;
    public WordDictionary() {
        this.dictionary = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = this.dictionary;
        
        for(char ch : word.toCharArray()){
            if(!curr.kids.containsKey(ch)){
                curr.kids.put(ch, new TrieNode());  
            }
            curr = curr.kids.get(ch);
        }
        curr.isWord = true;
    }
    public boolean DFS(char []word, TrieNode node, int start){
        for(int i= start; i<word.length; i++){
            char ch = word[i];
            if(!node.kids.containsKey(ch)){
                if(ch == '.'){
                    for(char k : node.kids.keySet()){
                        TrieNode kid = node.kids.get(k);
                        if(DFS(word, kid, i+1))
                            return true;
                    }
                    return false;
                }
                return false;
            }
            else{
                node = node.kids.get(ch);
            }
        }
        return node.isWord;
    }
    public boolean search(String word) {
        TrieNode curr = this.dictionary;
        char []wordChars = word.toCharArray();
        
        for(int i = 0; i<wordChars.length; i++){
            char ch = wordChars[i];
            if(ch == '.'){
                return DFS(wordChars, curr, i);
            }
            else if(curr.kids.containsKey(ch)){
                curr = curr.kids.get(ch);
            }
            else 
                return false;
        }
        return curr.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
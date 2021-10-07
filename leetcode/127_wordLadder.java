class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        boolean isPresent = false;
        for(String tmp :  wordList){
            if(tmp.equals(endWord))
                isPresent = true;
            set.add(tmp);
        }
        if(!isPresent) return 0;
        
        Queue<String> q = new LinkedList<>();
        
        q.add(beginWord);
        
        int level =  1;
        int clevel = level;
        
        while(!q.isEmpty()){
            String word = q.remove();
            //System.out.println(word);
            char []letters = word.toCharArray();
            // iterate for every letter in the word
            for(int i = 0 ; i < letters.length; i++){
                char tmp_ch = letters[i];
                
                for(char ch = 'a'; ch<='z'; ch++){
                    if(ch == tmp_ch) continue;
                    letters[i] = ch;
                    String tmp_str = String.valueOf(letters);
                    if(tmp_str.equals(endWord)) return level+1;
                    if(set.contains(tmp_str)){
                        q.add(tmp_str);
                        set.remove(tmp_str);
                    }
                }
                
                letters[i] = tmp_ch;
                
            }
            clevel--;
            if(clevel <= 0)
            {
                clevel = q.size();
                level++;
            }
            
            
        }
        
       return 0; 
    }
    

}
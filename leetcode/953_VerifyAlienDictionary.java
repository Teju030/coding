class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length <= 1) return true;
        
        int i = 0;
        int j = 1;
        while(j<words.length)
        {
            String first = words[i];
            String sec = words[j];
            
            
            int k =0;
            while(k < first.length() && k < sec.length() && first.charAt(k)== sec.charAt(k)){
                k++;
            }
            if( k < first.length() ) {
                if(k< sec.length()){
                    if(getPos(order, first.charAt(k)) > getPos(order, sec.charAt(k)))
                    {
                        return false;
                    }
                }
                else if( k >= sec.length()){
                    return false;
                }
            }
            

            i++;
            j++;
        }
        return true;
        
    }
    
    public int getPos(String order, char c ){
        int i = 0;
        while(i< order.length() && order.charAt(i) != c) i++;
        //System.out.println(i);
        return i;
        
    }
}
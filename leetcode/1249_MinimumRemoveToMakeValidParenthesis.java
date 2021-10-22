class Solution {
    public String minRemoveToMakeValid(String s) {
        
        char [] char_arr = s.toCharArray();
        
        int opening = 0;
        for(int i = 0; i<char_arr.length; i++){
            char ch = char_arr[i];
            if(ch == '('){
                opening++;
            }
            else if (ch == ')'){
                if(opening == 0){
                    char_arr[i] = '*';
                }
                else
                    opening--;
            }
            
        }
        
        int i = char_arr.length-1;
        while(i>=0 && opening >0){
            if(char_arr[i] == '('){
                char_arr[i] = '*';
                opening--;
            }
            i--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(char ch: char_arr){
            if(ch != '*')
                sb.append(ch);
        }
        
        return sb.toString();
    }
}
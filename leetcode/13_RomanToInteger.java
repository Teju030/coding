class Solution {
// L             50
// C             100
// D             500
// M
    public int romanToInt(String s) {
        int result = 0;
        for(int i = s.length()-1 ; i>= 0; i--){
            char ch = s.charAt(i);
            switch(ch){
                case 'I': 
                    result += 1 * ((result >= 5) ? -1: 1);
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += 10 * ((result >= 50) ? -1: 1);
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += 100 * ((result >= 500) ? -1: 1);
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;      
                    
            }
            
        }
        return result;
    }
}
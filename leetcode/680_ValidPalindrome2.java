class Solution {
    public boolean validPalindrome(String s) {
        
        int left = 0;
        int right = s.length()-1;
        char [] char_arr = s.toCharArray();

        while( left < right && char_arr[left] == char_arr[right]){
            left++;
            right--;
        }
        
        if(left < right){
            int left1 = left + 1;
            int right1 = right;
            while(left1<right && char_arr[left1] == char_arr[right1]){
                left1++;
                right1--;
            }
            if( left1>=right1)
            {
                return true;
            }
            left1 = left;
            right1 = right -1;
            while(left1<right && char_arr[left1] == char_arr[right1]){
                left1++;
                right1--;
            }
            if( left1>=right1)
            {
                return true;
            }
        }
        else{
            return true;
        }
        
        return false;
    }
}
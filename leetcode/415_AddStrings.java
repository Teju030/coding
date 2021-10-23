class Solution {
    public String addStrings(String num1, String num2) {
        
        char []num1_arr = num1.toCharArray();
        char []num2_arr = num2.toCharArray();
        
        int i = num1_arr.length-1; 
        int j = num2_arr.length-1; 
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int res = 0;
        int maxLen = Math.max(num1_arr.length, num2_arr.length);
        
        while(i >=0 || j >=0 ){
            int first = (i >= 0) ?  num1_arr[i] - '0' : 0;
            int second = (j >=0) ?  num2_arr[j] - '0' : 0;
            res =  first + second + carry;
            carry = res /10;
            res %=10;
            sb.append(res);
            i--;
            j--;
        }
        if(carry > 0)
            sb.append(carry);
        
        return sb.reverse().toString();
    }
}
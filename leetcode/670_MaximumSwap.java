class Solution {
    public int maximumSwap(int num) {
        int []bucket = new int[10];
        char[] digits = Integer.toString(num).toCharArray();
        
        for(int i = 0; i<digits.length; i++){
            bucket[digits[i] - '0'] = i;
        }
        
        for(int i = 0; i < digits.length; i++){
            int curr = digits[i] -'0';
            for(int j = 9; j > curr; j--){
                if(i < bucket[j]){
                    // swwp
                    digits[i] = (char)(j +'0');
                    digits[bucket[j]] = (char)(curr+'0'); 
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        return num;
    }
}
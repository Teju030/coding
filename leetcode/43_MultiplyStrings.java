class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int n = n1+n2;
        int res[] = new int[n];
        
        char []cnum1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char []cnum2 = new StringBuilder(num2).reverse().toString().toCharArray();
        
        for(int i = 0; i<n1; i++){
           
            for(int j = 0; j<n2; j++){
                int idx = i + j;
                res[idx] += (cnum1[i]-'0') * (cnum2[j] - '0') ;
                res[idx+1] += res[idx]/10;
                res[idx] = res[idx]%10;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        int idx = n -1;
        while(idx >0 && res[idx] == 0) idx--;
        for(int i = 0 ; i<=idx ; i++){
            ans.append(res[i]);
        }
        return ans.reverse().toString();
    }
   
}
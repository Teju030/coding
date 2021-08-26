class Solution {
    public int climbStairs(int n) {
        int first = 1;
        int sec = 2;
        if( n == 1) return first;
        if( n == 2) return sec;
        int i = 3;
        while(i <= n)
        {
            int res = first + sec ;
            first = sec;
            sec = res;
            i++;
        }
        return sec;
    }
}
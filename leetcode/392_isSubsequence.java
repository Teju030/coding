class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean isValid = true;
        int s_i = 0 ;
        int t_i = 0;
        while(s_i < s.length() && t_i < t.length())
        {
            if(s.charAt(s_i) == t.charAt(t_i))
            {
                s_i++;
                t_i++;
            }
            else
                t_i++;
        }
        if(t_i == t.length() && s_i < s.length())
        {
            isValid = false;
        }
        return isValid;
    }
}
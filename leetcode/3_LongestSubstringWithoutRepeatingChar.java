class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        Character tmp = null;
        int max_len = 0;
        while(j< s.length())
        { 
            tmp = s.charAt(j);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            
            while(Integer.valueOf(map.getOrDefault(tmp, 0)) >1){
                char l = s.charAt(i);
                map.put(l, map.getOrDefault(l, 1) - 1);
                i++;
            }
            
            max_len = Math.max(max_len, j - i + 1);
            j++;
            
        }
        return max_len;
    }
}
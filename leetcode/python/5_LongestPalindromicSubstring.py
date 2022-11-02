class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        max_len = 1
        res = [0,0]
        if n <= 1:
            return s
        
        for i in range(n):
            left = i
            right = i
            while left >= 0 and right < n and s[left] == s[right]:
                # print("left : " + str(left) + " right : "+ str(right))
                if max_len < right - left + 1 :
                    max_len =  right - left + 1
                    res = [left, right]
                left -=1
                right +=1
    
    
        for i in range(n):
            left = i
            right = i + 1
            while left >= 0 and right < n and s[left] == s[right]:
                # print("left : " + str(left) + " right : "+ str(right))
                if max_len < right - left + 1 :
                    max_len =  right - left + 1
                    res = [left, right]
                left -=1
                right +=1
                
        return s[res[0]: res[1] + 1]
    
        
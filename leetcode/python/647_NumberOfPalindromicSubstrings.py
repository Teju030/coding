class Solution:
    def countSubstrings(self, s: str) -> int:
        total = 0
        n = len(s)
        # Odd length palindromic substring 
        for i in range(n):
            total += self.numberOfPalindromicSubstrings(i, i, s)
            
        # Even length Palindromic substrings
        for i in range(0, n-1):
            total += self.numberOfPalindromicSubstrings(i, i+1, s)
        return total

    
    def numberOfPalindromicSubstrings(self, left, right, s):
        res = 0
        n = len(s)
        while left >=0 and right < n and s[left]==s[right]:
            res+=1
            left -=1
            right +=1
        return res
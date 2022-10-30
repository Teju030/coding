class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
    
        hashMap = {}
        left, right = 0, 0 
        n = len(s)
        resLen = 0
        while right < n:
            c = s[right]
            hashMap[s[right]] = 1 + hashMap.get(c, 0)
            if len(hashMap) <= 2:
                resLen = max(resLen, right - left + 1)
        
            while len(hashMap) > 2:
                hashMap[s[left]] -=1 
                if(hashMap[s[left]] == 0):
                    hashMap.pop(s[left])
                left +=1
            
            right +=1 
        return resLen
    
            
            
            
            
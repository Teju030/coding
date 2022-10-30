class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        
        left = 0
        right = 0
        n = len(s)

        haveMap = {}
        needMap = {}
        minLength = float('inf')
        minLeft = -1
        minRight = -1

        for char in t:
            needMap[char] = 1 + needMap.get(char, 0)

        have = 0
        need = len(needMap)
        
        while right < n:
            currChar = s[right]
            
            haveMap[currChar] = 1 + haveMap.get(currChar, 0)

            if currChar in needMap and haveMap[currChar] == needMap[currChar] :
                have +=1
                
            while have == need:
                if right - left + 1 < minLength: 
                    minLength = (right - left + 1)
                    minLeft = left
                    minRight = right
                
                haveMap[s[left]] -= 1
                if s[left] in needMap and haveMap[s[left]] < needMap[s[left]]:
                    have -=1 
                left +=1
    
            right +=1
       
        return s[minLeft: minRight+1] if minLength != float('inf') else ""
        
            
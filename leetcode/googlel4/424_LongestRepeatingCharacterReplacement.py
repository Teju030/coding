class Solution:
    def characterReplacement(self, s: str, k: int) -> int:

        left, right = 0, 0
        hashmap = collections.defaultdict(int)
        maxL = 0
        while right < len(s):
            char = s[right]
            hashmap[char] += 1
            # find the max freq character
            freq = max(hashmap, key = hashmap.get)
            while right - left + 1 - hashmap[freq] > k:
                hashmap[s[left]] -= 1
                left +=1
                freq = max(hashmap, key = hashmap.get)
            maxL = max(maxL, right - left + 1)
            right +=1
        return maxL
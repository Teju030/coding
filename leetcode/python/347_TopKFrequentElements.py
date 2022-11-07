class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hashmap = Counter(nums)
      
        return heapq.nlargest(k, hashmap.keys(), key = hashmap.get)
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:

        maxHeap = []

        for x, y in points:
            dist = x**2 + y**2
            heapq.heappush(maxHeap, (-dist, [x, y]))
            if len(maxHeap) > k:
                heapq.heappop(maxHeap)
        closest = []
        while maxHeap:
            closest.append(heapq.heappop(maxHeap)[1])
        return closest
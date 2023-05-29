class Solution:
    ## logic is correct but solution does produce exact output sometimes due to ceil operation
    
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = min(piles)
        right = max(piles)

        while(left < right): 
            mid = (left + right) // 2
            hours = self.getTotalHours(piles, mid)
            if hours <= h:
                right = mid
            else:
                left = mid + 1
        return right

    def getTotalHours(self, piles, speed):
        total = 0
        for p in piles:
            total += math.ceil(p/speed)
        # print(speed, total)
        return total 
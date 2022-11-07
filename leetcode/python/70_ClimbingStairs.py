class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n 

        prev = 1 
        curr = 2
        steps = 0

        for i in range(3, n+1):
            steps = prev + curr
            prev = curr
            curr = steps
        
        return steps
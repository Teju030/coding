from collections import deque

class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        stack = deque()
        
        cars = []
        for pos, s in zip(position, speed):
            cars.append([pos, s])
        
        cars.sort(reverse = True)
        
        for pos, s in cars:
            
            total_time = (target - pos) / s
            if len(stack) == 0:
                stack.append((pos, total_time))
            elif stack and stack[-1][1] < total_time:
                stack.append((pos, total_time))
            
        return len(stack)
                    
            
        
        
        
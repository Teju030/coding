class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        maxArea = 0
        visit = set()
        m, n = len(grid), len(grid[0])
        directions = [(0,1), (1,0), (-1,0), (0,-1)]

        def dfs(r: int, c: int):
            visit.add((r, c))
            currArea = 0
            for dr, dc in directions:
                tr = dr + r 
                tc = dc + c
                
                # is valid 
                if tr in range(m) and tc in range(n) and grid[tr][tc] and (tr, tc) not in visit:
                    currArea += 1 + dfs(tr, tc)
            return currArea

        for i in range(m):
            for j in range(n):
                if grid[i][j] and (i,j) not in visit:
                    currArea = dfs(i, j)
                    maxArea = max(maxArea, currArea+1)
        return maxArea
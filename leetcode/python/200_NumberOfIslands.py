class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        n = len(grid)
        m = len(grid[0])
        visited = []
        for i in range(n):
            visited.append([False] * m)
        direction = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        
        
        def dfs(i, j):
            q = deque()    
            q.append((i, j))
            
            while(len(q)> 0):
                r, c = q.pop()        
                visited[r][c] = True
                for x, y in direction:
                    nr = r + x
                    nc = c + y
                    if nr < 0 or nr >= n or nc < 0 or nc >= m:
                        continue
                    if not visited[nr][nc] and grid[nr][nc] == "1":
                        q.append((nr, nc))
                        visited[nr][nc] = True
                
        numOfIslands = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == "1" and not visited[i][j]:
                    dfs(i, j)
                    numOfIslands += 1
        return numOfIslands
            
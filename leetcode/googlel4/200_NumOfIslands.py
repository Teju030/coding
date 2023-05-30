class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])

        visited = set()

        directions = [(0,1), (1,0), (-1, 0), (0, -1)]
        
        def dfs(r: int, c: int):
            visited.add((r,c))
            # look for neighbours
            for dx, dy in directions:
                x = r + dx
                y = c + dy
                if 0 <= x and x < rows and 0<= y and y < cols and \
                    grid[x][y] == '1' and (x, y) not in visited:
                    dfs(x, y)
            return 

        numIslands = 0
        for i in range(rows):
            for j in range(cols):
                if (i, j) not in visited and grid[i][j] == '1':
                    dfs(i, j)
                    numIslands +=1
        return numIslands
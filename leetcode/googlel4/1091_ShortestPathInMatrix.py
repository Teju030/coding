class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:

        ROWS, COLS = len(grid), len(grid[0])
        directions = [(1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1,1)]
        queue = collections.deque()
        visited = set()

        if grid[0][0] == 0:
            queue.append((0, 0, 1))
            visited.add((0, 0))
        while len(queue)> 0:
            r, c, path = queue.popleft()
            if r == ROWS-1 and c == COLS-1:
                return path
            
            for dr, dc in directions:
                tr = dr + r
                tc = dc + c
                if min(tr, tc) < 0 or tr >= ROWS or tc >= COLS or grid[tr][tc] == 1 or (tr,tc) in visited:
                    continue
                visited.add((tr, tc))
                queue.append((tr, tc, path + 1))
        return -1
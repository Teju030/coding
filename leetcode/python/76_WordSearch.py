'''
Time Complexity : O(N * 3^L)
Max 3 branches and max level is L 

Space Complexity: O(L)
Where, L = len(word)
M = Number of cells
'''
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m = len(board)
        n = len(board[0])

        dirs = [(0, -1), (-1, 0), (0, 1), (1, 0)]
        visited = set()

        def dfs(start, ptr):
            visited.add(start)
            if ptr >= len(word):
                return True

            for x, y in dirs:
                tx = start[0] + x
                ty = start[1] + y
                # out of bounds
                if tx < 0 or ty < 0 or tx >= m or ty >= n:
                    continue
                
                if board[tx][ty] == word[ptr] and (tx, ty) not in visited:
                    tmp = dfs((tx, ty), ptr + 1)
                    if tmp:
                        return True
                    # print(visited)
                    visited.remove((tx, ty))

            
            return False

        ptr = 0
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[ptr]:
                    tmp = dfs((i, j), ptr+1)
                    if tmp:
                        return True
                    visited.remove((i,j))
        return False

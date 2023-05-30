class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        sets = []
        curr = []
        length = len(candidates)
        candidates = sorted(candidates)

        def dfs(pos: int, target: int): 
            print(pos, target)
            if target == 0:
                sets.append(curr.copy())
                return 

            if pos == length or target < 0:
                return 
            # include pos
            curr.append(candidates[pos])
            dfs(pos, target - candidates[pos])
            curr.pop()
            
            dfs(pos+1, target)
               

        dfs(0, target)

        return sets
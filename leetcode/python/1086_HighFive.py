class Solution:
    def highFive(self, items: List[List[int]]) -> List[List[int]]:
        hashmap = collections.defaultdict(list)
        for item in items:
            heapq.heappush(hashmap[item[0]], item[1])
            if len(hashmap[item[0]]) > 5:
                heapq.heappop(hashmap[item[0]])
        
        res = []

        for key, val in hashmap.items():
            tmp_avg = 0
            for v in val:
                tmp_avg += v
            
            tmp_avg = tmp_avg // 5
            res.append([key, tmp_avg])
        
        return sorted(res)
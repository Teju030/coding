class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        prices = [float('inf')] * n 
        prices[src] = 0
        
        for k in range(k+1):
            tmp_prices = prices.copy()
            for s, d, p in flights:
                
                if prices[s] == float('inf'):
                    continue
                
                if prices[s] + p <= tmp_prices[d]:
                    tmp_prices[d] = prices[s] + p
            prices = tmp_prices
                
        return prices[dst] if prices[dst]!= float('inf') else -1
    
        
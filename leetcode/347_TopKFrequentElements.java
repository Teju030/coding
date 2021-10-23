class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n :  nums)
        {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            queue.add(new int[]{e.getKey(), e.getValue()});
            if(queue.size() > k){
                queue.remove();
            }
        }
        
        int res[] = new int[queue.size()];
        int i = 0;
        
        while(!queue.isEmpty()){
            res[i] = queue.remove()[0];
            i++;
        }
        return res;
    }
}
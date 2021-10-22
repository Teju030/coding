class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return b[2] - a[2];
            }
        });
        
        
        for(int i = 0 ; i<points.length; i++){
            
            int dist = (int)Math.pow(points[i][0], 2) + (int)Math.pow(points[i][1], 2);
            //System.out.println()
            queue.add(new int[]{points[i][0], points[i][1], dist});
            if(queue.size() > k){
                queue.remove();
            }
            
        }
        
        int res[][] = new int[k][2];
        int i = 0;
        while(!queue.isEmpty()){
            int[] tmp = queue.remove();
            
            res[i][0] = tmp[0];
            res[i][1] = tmp[1];
            i++;
            
        }
        return res;
        
    }
}
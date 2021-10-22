class Solution {
    /*
        -------------
        ------
            ---------
                -----
    
    */
    public int minMeetingRooms(int[][] intervals) {
        int maxRooms = 1;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int []a, int[]b){
                return a[0] - b[0];
            }
        });
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int []a, int []b){
                return a[1] - b[1];
            }
        });
        
        
        int []current = intervals[0];

        queue.add(current);
        for(int i = 1; i<intervals.length; i++){
            int []next = intervals[i];  
            while(!queue.isEmpty() && queue.peek()[1] <= next[0])
                queue.remove();
            queue.add(next);
            maxRooms = Math.max(maxRooms, queue.size());
            
        }
        
        return maxRooms;
    }
}
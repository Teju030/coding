class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] != b[0]) return a[0] - b[0];
                else{
                   return a[1] - b[1]; 
                }
                
            }
        });
        
        int l = intervals[0][0];
        int r = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        
        for(int []a: intervals){
           
            if(l <= a[0] && a[0] <= r){
                l = Math.min(l, a[0]);
                r = Math.max(r, a[1]);
            }
            else{
                res.add(new int[] {l,r});
                l = a[0];
                r = a[1];       
            }
        }
        res.add(new int[] {l,r});
        
        return res.toArray(new int[res.size()][]);
    }
}
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        res.add(new ArrayList<Integer>(){
            {add(1);}
        });
        
        List<Integer> old = new ArrayList<Integer>();
        
        for( int i = 1; i<numRows; i++)
        {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            old = res.get(i-1);
            int size = old.size();
            
            for(int j = 0; j< size-1; j++)
            {
                int sum = old.get(j) + old.get(j+1);
                tmp.add(sum);
            }
            tmp.add(1);
            
            res.add(tmp);
        }
        return res;
    }
}
class Solution {
    public int[] findBuildings(int[] heights) {
        int rightMax = -1;
        Stack<Integer> stack = new Stack<>();
        for(int i = heights.length-1; i>=0 ; i--){
            if(heights[i] > rightMax){
                stack.push(i);
                rightMax = heights[i];
            }
        }
        
        int []result = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            result[i] = stack.pop();
            i++;
        }
        
        return result;
    }
}
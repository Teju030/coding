class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int left = 0;
        int right = cols;
        int top = 0;
        int bottom = rows;
        int i = 0;
        int j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        
        while(left < right && top < bottom)
        {
            // left to right
            j = left;
            while(j < right)
            {
                res.add(matrix[top][j]);
                j++;
            }
            top++;
            
            // top to bottom 
            i = top;
            while(i < bottom )
            {
                res.add(matrix[i][right-1]);
                i++;
            }
            right--;
            // right to left 
            if(left < right)
            {
                j = right -1;
                while( j >= left)
                {
                    if(top == bottom ) break;
                    res.add(matrix[bottom -1][j]);
                    j--;
                }
                bottom--;
            }
            // bottom to top 
            if(top < bottom)
            {
                i = bottom -1;
                while( i >= top)
                {
                    if(left == right ) break;
                    res.add(matrix[i][left]);
                    i--;
                }
                left++;
            }
        }
        return res;
    }
}
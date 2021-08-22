import java.util.*;

class Program {
  public static List<Integer> spiralTraverse(int[][] array) {
    // Write your code here.
		ArrayList<Integer> res = new ArrayList<>();
		if(array.length == 0) return res;
		int n = array.length;
		int left = 0;
		int right = array[0].length;
		int top = 0;
		int bottom = array.length;
		while(left < right && top < bottom)
		{
			// row left to right 
			for(int j = left; j < right; j++)
			{
				res.add(array[top][j]);
			}
			top++;
			// col top to bottom
			for( int i = top; i < bottom; i++)
			{
				res.add(array[i][right-1]);
			}
			right--;
			// col right to left
			if(left < right)
			{
				for(int j = right-1; j>=left; j--){
					if(top == bottom ) break;
					res.add(array[bottom-1][j]);
				}
				bottom--;
			}
			// row bottom to top
			if(top < bottom)
			{
				for(int i = bottom-1; i>=top; i--){
					if(left == right) break;
					res.add(array[i][left]);
				}
				left++;
			}
		}
    return res;
  }
}

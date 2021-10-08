import java.util.*;

class Program {

  public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
    // Write your code here.
		ArrayList<Integer> bldgs = new ArrayList<>();
		Stack<Integer> stack = new Stack<Integer>();
		if(direction.equals("WEST")){
			for(int i = 0 ; i< buildings.length; i++){
					int b = buildings[i];
					if(stack.isEmpty() || buildings[stack.peek()]< b )
					{
						stack.push(i);
					}
				}
			}
		else{
				for(int i = buildings.length-1 ; i >=0; i--){
					int b = buildings[i];
					if(stack.isEmpty() || buildings[stack.peek()]< b )
					{
						stack.push(i);
					}
				}
		}
		
		while(!stack.isEmpty()){
			if(direction.equals("WEST"))
				bldgs.add(0,stack.pop());
			else
				bldgs.add(stack.pop());
		}
		return bldgs;
		}
		
}


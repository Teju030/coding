import java.util.*;

class Program {
  public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
    return closest(tree, target);
  }
	
	public static int closest(BST tree, int target){
		if(tree == null ) return -1;
		if(tree.value == target ) return tree.value;
		if( tree.value < target ){
				int val = closest(tree.right, target);
				if( val == -1 ) return tree.value;
				val = (Math.abs(val - target) > Math.abs(tree.value - target)) ? tree.value: val;
				return val;
		}else{
				int val = closest(tree.left, target);
				if( val == -1 ) return tree.value;
				val = (Math.abs(val - target) > Math.abs(tree.value - target)) ? tree.value: val;
				return val;
		}
	}

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}

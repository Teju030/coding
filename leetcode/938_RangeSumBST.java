/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int total = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        getSum(root, low, high);
        return total;
    }
    public int getSum(TreeNode root, int low, int high){
        int val = root.val;
        
        if(low <= val && val <=high){
            total += val;
        }
        
        if(val < low ){
            if(root.right!= null) return getSum(root.right, low, high);
        }
        else if(val > high){
            if(root.left!= null) return getSum(root.left, low, high);
        }
        else {
            if(root.left!= null)  
                getSum(root.left, low, high);
            if(root.right!= null) 
                getSum(root.right, low, high);
        }
        return 0;
    }
}
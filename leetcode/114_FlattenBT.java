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
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        
        while(curr!= null){
            TreeNode leftmost = null;
            if(curr.left!= null){
                leftmost = getLeftMost(curr.left);
                leftmost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
                curr = curr.right;
            }
            else{
                curr = curr.right;
            }
        }
        
    }
    
    public TreeNode getLeftMost(TreeNode root){
        TreeNode curr = root;
        while(curr.right!=null){
            curr = curr.right;
        }
        return curr;
    }
}

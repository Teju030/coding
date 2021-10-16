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
    int max = 0;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        int tmp = maxSum(root);
        return Math.max(tmp, max);
    }
    public int maxSum(TreeNode root){
        if(root == null ) return 0;
        
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        
        int ans =  Math.max(tmp, root.val + left + right);
        max = Math.max(ans, max);
        
        int tmp = Math.max(root.val, root.val + Math.max(left ,right));
        return tmp;
        
    }
}
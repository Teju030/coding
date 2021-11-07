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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        int height = 0;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            height++;
            for(int i = 0 ;i < size; i++){
                TreeNode curr = queue.remove(); 
                if(curr.left == null && curr.right == null) return height;
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                
            }
        }
        return height;
        
    }
}
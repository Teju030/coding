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

// recursive solution 
class Solution {
    List<Integer> rightmost = new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null ) return rightmost;
        util(root, 0);
        return rightmost;
    }
    public void util(TreeNode root, int level){
        if(level == rightmost.size()){
            rightmost.add(root.val);
        }
        if(root.right != null) 
            util(root.right, level+1);
        if(root.left != null)
            util(root.left, level+1);
    }
}
//iterative solution 
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new LinkedList<>();
        if(root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode curr = queue.remove();
                
                if(i==size - 1) result.add(curr.val);
                
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
        }
        return result;
        
    }
}
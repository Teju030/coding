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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null ) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.add(root);
        q.add(null);
        
        
        while(!q.isEmpty())
        {
            ArrayList<Integer> line = new ArrayList<Integer>();
            while(!q.isEmpty())
            {
                TreeNode tmp = q.remove();
                if(tmp == null )
                {
                    if(!q.isEmpty()) q.add(null);
                    break;
                    
                }
                else{
                    line.add(tmp.val);
                    if(tmp.left != null ) q.add(tmp.left);
                    if(tmp.right != null ) q.add(tmp.right);
                }
            }
            res.add(line);
        }
        return res;
        
    }
}
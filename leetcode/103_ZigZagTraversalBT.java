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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        
        if(root == null ) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.add(root);
        int level = 0;
        while(!q.isEmpty())
        {
            LinkedList<Integer> line = new LinkedList<Integer>();
            int n = q.size();
            for(int i = 0; i<n; i++)
            {
                TreeNode tmp = q.remove();
                
                if(level %2 == 0)
                {
                   line.addLast(tmp.val);
                }
                else
                {
                    line.addFirst(tmp.val);   
                }
                if( tmp.left != null ) q.add(tmp.left);
                if( tmp.right != null ) q.add(tmp.right); 
            }
            level++;
            res.add(line);
        }
        
        return res;
        
    }
}
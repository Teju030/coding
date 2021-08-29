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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null && q == null ) return true;
        if (!check(p, q)) return false;
        
        ArrayDeque<TreeNode> stackp = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> stackq = new ArrayDeque<TreeNode>();
        
        stackp.addLast(p);
        stackq.addLast(q);
        while(!stackp.isEmpty())
        {
            p = stackp.removeFirst();
            q = stackq.removeFirst();
            
            if(!check(p, q)) return false;
            
            if(p!= null)
            {
                if(!check(p.left, q.left)) return false;
                if(p.left != null ){
                    stackp.addLast(p.left);
                    stackq.addLast(q.left);
                }
                
                if(!check(p.right, q.right)) return false;
                if(p.right != null ){
                    stackp.addLast(p.right);
                    stackq.addLast(q.right);
                }
                    
            }
        }
        return true;
        
    }
    public boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null ) return true;
        
        if ( p == null || q == null ) return false;
        
        if( p.val != q.val ) return false;
        return true;
    }
}
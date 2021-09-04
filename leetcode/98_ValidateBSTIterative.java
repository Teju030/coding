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
    private Deque<TreeNode> stack = new LinkedList();
    private Deque<Integer> maxQueue = new LinkedList();
    private Deque<Integer> minQueue = new LinkedList();
    
    public boolean isValidBST(TreeNode root) {
       
        
        Integer max = null;
        Integer min = null;
        Integer val = null;
        
        update(root, max, min);
        
        while(!stack.isEmpty())
        {
            TreeNode tmp = stack.poll();
            max = maxQueue.poll();
            min = minQueue.poll();
            
            if(tmp == null ) continue;
            val = tmp.val;
            
            // max in left subtree must be less than root val
            if(max != null && val >= max )
                return false;
            
            // min in right subtree must be less than root val
            if( min!= null && val <= min)
                return false;
            
            update(tmp.left, val, min);
            update(tmp.right, max, val);
        }
        return true;
    }

    public void update(TreeNode root, Integer max, Integer min)
    {
        stack.add(root);
        maxQueue.add(max);
        minQueue.add(min);
    }

}
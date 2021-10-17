/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Iterative solution 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        
        parent.put(root, null);
        
        stack.push(root);
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode curr = stack.pop();
            
            if(curr.left != null)
            {
                parent.put(curr.left, curr);
                stack.push(curr.left);
            }
            if(curr.right != null ){
                parent.put(curr.right, curr);
                stack.push(curr.right);
            }
            
        }
        
        Set<TreeNode> set = new HashSet<TreeNode>();
        while(p!= null){
            set.add(p);
            p = parent.get(p);
        }
        
        while(!set.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}

// recursive

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) return null;
        
        if(root.val == p.val || root.val == q.val) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null) return right;
        else if(right == null ) return left;
        else
            return root;
        
    }
}
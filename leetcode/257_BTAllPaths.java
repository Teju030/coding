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
    List<String> result = new LinkedList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        util(root, new ArrayList<String>());
        return result;
    }
    public void util(TreeNode root, ArrayList<String> st){
        if(root == null ) return ;
        
        st.add(String.valueOf(root.val));
        
        if(root.left==null && root.right==null){
            result.add(String.join("->", st));
        }
        
        if(root.left!=null)
            util(root.left, st);
        if(root.right!= null )
            util(root.right, st);
        
        st.remove(st.size()-1);
    }
}
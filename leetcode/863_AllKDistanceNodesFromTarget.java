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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        // TreeNode TargetNode = findTarget(root);
        HashMap<TreeNode, TreeNode> parent = linkParent(root);
        
        return findKdistanceNodes(target, k, parent);
        
    }
    public HashMap<TreeNode, TreeNode> linkParent(TreeNode root){
        
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        parent.put(root, null);
        
        while(!queue.isEmpty()){
            TreeNode current = queue.remove();
            if(current.left!=null){
                parent.put(current.left, current);
                queue.add(current.left);
            }
            if(current.right!= null){
                parent.put(current.right, current);
                queue.add(current.right);
            }
        }
        
        return parent;
        
    }
    
    public List<Integer> findKdistanceNodes(TreeNode root, int k, HashMap<TreeNode, TreeNode> parent){
        List<Integer> list = new LinkedList<Integer>();
        
        HashSet<TreeNode> visited = new HashSet<>();
        
        if(root == null) return list;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        visited.add(root);
        
        while(!queue.isEmpty()){
            
            if(k==0) break;
            
            int size = queue.size();
            for(int i = 0 ; i<size; i++){
                TreeNode current = queue.remove();
                if(current.left != null && !visited.contains(current.left)){
                    queue.add(current.left);
                    visited.add(current.left);
                }
                if(current.right!= null && !visited.contains(current.right)){
                    queue.add(current.right);
                    visited.add(current.right);
                }
                TreeNode tmpParent = parent.get(current);
                if(tmpParent!=null && !visited.contains(tmpParent)){
                    queue.add(tmpParent);
                    visited.add(tmpParent);
                }
                
            }
            k--; 
        }
        
        while(!queue.isEmpty()){
            list.add(queue.remove().val);
        }
        
        
        return list;
    }
   
}
class Solution {
    int answer = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getValue(root);
        return answer;
    }
    
    public int getValue(TreeNode root){
        if(root == null ) return 0;
        int left = getValue(root.left);
        int right = getValue(root.right);
        answer = Math.max(answer, left + right + root.val);
        return Math.max(0, root.val + Math.max(left, right));
    }
}
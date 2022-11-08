# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if (not p and q) or (p and not q):
            return False
        if not p and not q:
            return True
            
        if (p.val != q.val) or (not p.left and q.left) or (p.left and not q.left) or \
           (not p.right and q.right) or (p.right and not q.right):
            return False
        tmp = self.isSameTree(p.left, q.left)
        if not tmp:
            return False
        tmp = self.isSameTree(p.right, q.right)
        if not tmp:
            return False
        
        return True
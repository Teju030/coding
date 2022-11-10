# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:

        q = collections.deque()
        q.append(root)
        while len(q) > 0:
            curr = q.popleft()
            if curr.val == subRoot.val:
                tmp = self.isSame(curr, subRoot)
                if tmp:
                    return True
            
            if curr.left: q.append(curr.left)
            if curr.right: q.append(curr.right)
        return False
    
    def isSame(self, p, q):
        if not p and not q :
            return True
        if not p or not q:
            return False
        
        if p.val != q.val:
            return False

        return self.isSame(p.left, q.left) and self.isSame(p.right, q.right)

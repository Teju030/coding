# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return root
        
        q = collections.deque()
        q.append(root)
        while len(q)> 0:
           
            current = q.popleft()
            tmp = current.left 
            current.left = current.right 
            current.right = tmp

            if current.left:
                q.append(current.left)
            if current.right:
                q.append(current.right)
            
        return root
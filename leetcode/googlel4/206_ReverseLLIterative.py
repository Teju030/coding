# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        prev, currHead = None, head

        while currHead:
            nextHead = currHead.next
            currHead.next = prev
            prev = currHead
            currHead = nextHead
        return prev
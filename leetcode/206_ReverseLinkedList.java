/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        Stack<ListNode> stack = new Stack<ListNode>();
        
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        
        ListNode start = stack.pop();
        ListNode tmp = start;
        while(!stack.isEmpty()){
            tmp.next = stack.pop();
            tmp = tmp.next;
            if(stack.isEmpty())
                tmp.next = null;
                
        }
        return start;
    }
}
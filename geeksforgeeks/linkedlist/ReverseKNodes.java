class ReverseKNodes
{
    static Node reverseK(Node head, int k)
    {
        if(head == null | head.next == null){
            return head;
        }
        Node prev = null;
        Node curr = head;
        Node next = null;
        int count = 0;

        while( curr != null && count < k)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next!= null)
        {
            Node rhead = reverseK(next, k);
            head.next = rhead;
        }
        return prev;
    }
    public static void main(String args[])
    {
        LinkedListUtil l = new LinkedListUtil();
        l.addAtEnd(11);
        l.addAtEnd(12);
        l.addAtEnd(13);
        l.addAtEnd(14);
        l.addAtEnd(15);
        l.addAtEnd(16);
        l.addAtEnd(17);
        l.addAtEnd(18);
        l.display();

        l.head = reverseK(l.head, 3);
        l.display();
    }
}
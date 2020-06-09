class ReverseLL extends LinkedListUtil
{
    Node reverseLLrecursive(Node head)
    {
        // base case
        if( head == null || head.next == null)
        {
            return head;
        }
        // get head of reversed list excluding head
        Node rhead = reverseLLrecursive(head.next);
        // add head into reversed list
        head.next.next = head;
        head.next = null;
        return rhead;
    }
    
    // iterative solution to reverse a LL 
    Node reverseLLiterative(Node head)
    {   
        Node prev = null;
        Node curr = head;
        Node next = null;

        if(head == null || head.next == null)
        {
            return head;
        }

        while(curr != null )
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String []args)
    {
        ReverseLL l = new ReverseLL();
        l.addAtEnd(10);
        l.addAtEnd(20);
        l.addAtEnd(30);
        l.addAtEnd(40);
        l.addAtEnd(50);
        l.addAtEnd(80);
        l.display();

        l.head = l.reverseLLiterative(l.head);
        l.display();

        l.head = l.reverseLLrecursive(l.head);
        l.display();

    }
}
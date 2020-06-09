// Detect loop in linked list 

class LoopLL
{
    boolean static isLoop(Node node)
    {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if( fast == slow )
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String []args)
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

        System.out.println(isLoop(l.head));
    }
}
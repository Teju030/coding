class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
    }
    Node(int d, Node n)
    {
        data = d;
        next = n;
    }
}

class LinkedListUtil
{

    Node head;

    void addAtEnd(int data)
    {
        Node temp = new Node(data);
        if(head == null)
        {
            head = temp;
            return;
        }
        Node curr = head;
        while(curr.next != null)
        {
            curr = curr.next;
        }
        curr.next = temp;
    }
    void display()
    {
        System.out.println("\n---- Linked List -----");
        for(Node curr = head; curr!=null; curr=curr.next)
        {
            System.out.print(curr.data + "  ");
        }
    }
}

public class LinkedList
{
    public static void main(String[] args)
    {
        LinkedListUtil l = new LinkedListUtil();
        l.addAtEnd(10);
        l.addAtEnd(20);
        l.addAtEnd(30);
        l.addAtEnd(40);
        l.addAtEnd(50);
        l.addAtEnd(60);
        l.display();
    }
}
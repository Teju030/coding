class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
    }
}

class List
{
    Node head;
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
        List l = new List();
        l.addAtEnd(10);
        l.addAtEnd(20);
        l.addAtEnd(30);
        l.addAtEnd(40);
        l.addAtEnd(50);
        l.addAtEnd(60);
        l.display();

        // reverse linked list iterative solution 

        l.head = l.reverseLLiterative(l.head);
        l.display();

        l.head = l.reverseLLrecursive(l.head);
        l.display();
    }
}
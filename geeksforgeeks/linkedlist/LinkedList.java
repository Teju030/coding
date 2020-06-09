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
        l.display();
    }
}
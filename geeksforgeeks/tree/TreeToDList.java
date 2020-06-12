class TreeToDList
{

    Tnode prev = null;
    
    Tnode convertToDoublyLinkedlist( Tnode root )
    {
        if(root == null ) return root;
        Tnode head = convertToDoublyLinkedlist(root.left);
        if( prev == null ) { head = root; }
        else
        {   
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertToDoublyLinkedlist(root.right);
        return head;
    }
    // print doubly linked list
    void printDoublyLinkedlist(Tnode root)
    {
        if(root == null )   return ;

        while(root != null)
        {
            System.out.print( root.data + " ");
            root = root.right;
        }
    }
    public static void main(String []arg)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        t.inorder(root);
        System.out.println("\n convert binary tree to doubly linked list ");
        TreeToDList s = new TreeToDList();
        s.printDoublyLinkedlist(s.convertToDoublyLinkedlist(root));
        System.out.println("\n-----------------------------------------");
        in = new int[] { 3, 8, 5, 20, 12 };
        pre = new int[] { 20, 8, 3, 5, 12 };
        root = t.buildBinaryTree(in, pre, in.length);
        t.inorder(root);
        System.out.println("\n convert binary tree to doubly linked list");
        s.prev = null;
        s.printDoublyLinkedlist(s.convertToDoublyLinkedlist(root));

    }
}
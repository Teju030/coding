class BST
{
    Tnode insert(Tnode root, int key)
    {
        if(root == null )
            return new Tnode(key);
        
        if(root.data > key) 
            root.left = insert(root.left, key);
        if(root.data < key)
            root.right = insert(root.right, key);
        return root;
    }
    Tnode deleteNode(Tnode root, int key)
    {
        if(root == null ) return null;

        if(root.data > key )
            root.left = deleteNode(root.left, key);
        else if( root.data < key )
            root.right = deleteNode(root.right, key);
        else
        {

            if(root.left == null )
                return root.right;
            else if (root.right == null )
                return root.left;
            else
            {
                Tnode succ = getSuccessor(root.right);
                root.data = succ.data;
                root.right = deleteNode(root.right, succ.data);
            }    
        }
        return root;
    }
    Tnode getSuccessor(Tnode root)
    {
            Tnode curr = root;
            while (curr != null && curr.left != null)
            {
                curr = curr.left;
            }
            return curr;
    }
    void inorder(Tnode root)
    {
        if(root == null ) return ;
        inorder( root.left );
        System.out.print(root.data + " ");
        inorder( root.right);
    }

    public static void main(String []args)
    {
        BST t = new BST();
        Tnode root = null;
        root = t.insert(root, 30);
        root = t.insert(root, 10);
        root = t.insert(root, 20);
        root = t.insert(root, 40);
        root = t.insert(root, 12);
        root = t.insert(root, 25);
        //t.inorder(root);
        root = t.deleteNode(root, 30);
        t.inorder(root);
    }
}
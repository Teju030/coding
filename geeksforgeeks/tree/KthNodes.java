class KthNodes
{
    void kthnodes(Tnode root, int k)
    {
        if( root == null )
        {
            return ;
        }

        if(k == 0)
        {
            System.out.print(root.data + " ");
            return;    
        }
        kthnodes(root.left , k-1);
        kthnodes(root.right, k-1);
        
    }
    public static void main(String []args)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Nodes present at k th level in tree are");
        KthNodes s = new KthNodes();
        s.kthnodes(root, 3);
    }
}
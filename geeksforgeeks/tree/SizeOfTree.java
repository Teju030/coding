class SizeOfTree
{
    int sizeoftree(Tnode root)
    {
        if( root == null)
        {
            return 0;
        }
        int size = 1 + sizeoftree(root.left) + sizeoftree(root.right);
        return size;
    }
    public static void main(String []args)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Size of the tree");
        SizeOfTree s = new SizeOfTree();
        System.out.println(s.sizeoftree(root));
    }
}
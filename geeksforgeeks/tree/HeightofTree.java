class HeightofTree
{
    int heightoftree(Tnode root)
    {
        if(root == null )
        {
            return 0;
        }
        int h = 1 + Math.max( heightoftree(root.left) , heightoftree(root.right));
        return h;
    }
    public static void main(String []args)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Size of the tree");
        HeightofTree s = new HeightofTree();
        System.out.println(s.heightoftree(root));
    }
}
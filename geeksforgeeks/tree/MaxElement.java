class MaxElement
{
    int maxoftree(Tnode root)
    {
        if(root == null )
        {
            return Integer.MIN_VALUE;
        }

        int max = Math.max(root.data, Math.max(maxoftree(root.left), maxoftree( root.right)));
        return max;
    }
    public static void main(String []args)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Size of the tree");
        MaxElement s = new MaxElement();
        System.out.println(s.maxoftree(root));
    }
}
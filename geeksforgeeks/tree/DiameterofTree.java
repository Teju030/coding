class DiameterofTree
{
    int maxdiameter = 0;
    int diameteroftree(Tnode root)
    {
        if(root == null ) return 0;

        int lh = diameteroftree(root.left);
        int rh = diameteroftree(root.right);
        maxdiameter = Math.max(maxdiameter, ( lh + rh + 1));

        return Math.max(lh, rh) + 1;
    }
    public static void main(String []args)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Diameter of tree ");
        DiameterofTree s = new DiameterofTree();
        s.diameteroftree(root);
        System.out.println(s.maxdiameter);
        
        in = new int[] { 3, 8, 5, 20, 12 };
        pre = new int[] { 20, 8, 3, 5, 12 };
        root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        s.maxdiameter = 0;
        System.out.println("\n Diameter of tree ");
        s.diameteroftree(root);
        System.out.println(s.maxdiameter);
    }
}
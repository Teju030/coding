class LowestCommonAncestor
{
    
    Tnode lowestcommonancestor(Tnode root, int a, int b)
    {
        if( root == null ) return null;
        if(root.data == a || root.data == b)
            return root;
        Tnode l = lowestcommonancestor(root.left, a, b);
        Tnode r = lowestcommonancestor(root.right, a, b);
        if(l != null && r != null )
            return root;
        if ( l != null ) return l;
        else return r;
    }
    public static void main(String []args)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Lowest Common ancestors ");
        LowestCommonAncestor s = new LowestCommonAncestor();
        Tnode res = s.lowestcommonancestor(root, 11, 17);
        System.out.println("LCA(11, 17) : " +  res.data);
       
    }
}
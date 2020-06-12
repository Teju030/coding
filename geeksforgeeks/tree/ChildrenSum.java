class ChildrenSum
{
    boolean childrensum(Tnode root)
    {
        if( root == null )  return true;
        if( root.left == null && root.right == null ) return true;
        int lres = (root.left != null )? root.left.data: 0;
        int rres = (root.right != null )? root.right.data: 0;
        
        if ( lres + rres != root.data)
            return false;

        return childrensum(root.left) && childrensum(root.right);
    }
    public static void main(String []args)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Check if children sum equals parent node value ");
        ChildrenSum s = new ChildrenSum();
        System.out.println(s.childrensum(root));
        
        in = new int[] { 3, 8, 5, 20, 12 };
        pre = new int[] { 20, 8, 3, 5, 12 };
        root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Check if children sum equals parent node value ");
        System.out.println(s.childrensum(root));
    }
}
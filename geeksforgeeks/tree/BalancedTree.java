class BalancedTree
{
    // Tree is balanced if the abs(height of left subtree - height of right subtree ) <=1
    int isBalanced(Tnode root)
    {
        if(root == null ) return 0;

        int lheight = isBalanced(root.left);
        if(lheight == -1 ) return -1;

        int rheight = isBalanced(root.right);
        if(rheight == -1 ) return -1;

        if(Math.abs(lheight - rheight )>1) return -1;
        else
            return 1 + Math.max(lheight, rheight);
    }

    public static void main(String []args)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Check if tree is balanced or not ");
        BalancedTree s = new BalancedTree();
        System.out.println(s.isBalanced(root));
        
        in = new int[] { 3, 8, 5, 20, 12 };
        pre = new int[] { 20, 8, 3, 5, 12 };
        root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Check if tree is balanced or not ");
        System.out.println(s.isBalanced(root));

        in = new int[] { 13, 12, 14, 8 , 15, 16, 17 };
        pre = new int[] { 8, 12, 13, 14, 15, 16 ,17 };
        root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Check if tree is balanced or not ");
        System.out.println(s.isBalanced(root));

    }
}
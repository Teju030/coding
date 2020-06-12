class BuildTree
{
    int preindex = 0;
    Tnode buildtree( int []in, int []pre, int inS, int inE)
    {   
        if(inS > inE) return null;
        Tnode root = new Tnode(pre[preindex]);
        preindex++;

        int inindex = 0;
        for(int i= inS; i<= inE; i++ )
        {
            if(in[i] == root.data)
            {
                inindex = i;
                break;
            }
        }

        root.left = buildtree(in, pre, inS, inindex-1);
        root.right = buildtree(in, pre, inindex+1, inE);

        return root;

    }
    void inorder(Tnode root)
    {
        if( root == null )  return ;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String []args)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        BuildTree t = new BuildTree();
        Tnode root = t.buildtree(in, pre, 0, in.length-1);
        t.inorder(root);
    }
}
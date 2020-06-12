import java.util.*;
class LeftmostNode
{
    int maxlevel;
    // recursive solution
    void leftmostrecursive(Tnode root, int level)
    {
        if(root == null ) return;

        if(maxlevel < level)
        {
            System.out.print( root.data + " ");
            maxlevel++;
        }
        leftmostrecursive(root.left, level+1);
        leftmostrecursive(root.right, level+1);
    }
    // iterative solution
    void leftmostnode(Tnode root)
    {
        if(root == null )
        {
            return;
        }
        Queue<Tnode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty())
        {
            int count = q.size();
            for(int i = 1; i<=count; i++)
            {
                Tnode curr = q.poll();
                if(i == 1)
                {
                    System.out.print(curr.data + " ");
                }
                if( curr.left != null) q.add(curr.left);
                if( curr.right != null ) q.add(curr.right);
            }
        }
    }
    public static void main(String []args)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Nodes present at k th level in tree are");
        LeftmostNode s = new LeftmostNode();
        s.leftmostnode(root);
        System.out.println();
        s.leftmostrecursive(root, 1);
    }
}
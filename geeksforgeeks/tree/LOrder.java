import java.util.*;

class LOrder
{
    // Print level order traversal line by line 

    void lorder(Tnode root)
    {
        if(root == null) return;
        Queue<Tnode> q = new LinkedList();
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            Tnode curr = q.poll();
            System.out.print(curr.data + " ");
            if(curr == null )
            {
                System.out.println();
                curr = q.poll();
            }
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
            q.add(null);
        }
    }
    public static void main(String []args)
    {
        int []in = { 13, 11, 14, 10, 15, 12};
        int []pre = {10, 11, 13, 14 ,12, 15};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        System.out.println("\n Line by line lever order traversal ");
        LOrder l = new LOrder();
        l.lorder(root);
    }
}
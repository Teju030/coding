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
        while(q.size() > 1)
        {
            Tnode curr = q.poll();
            if(curr == null )
            {
                System.out.println();
                q.add(null);
                continue;
            }
            
            System.out.print(curr.data + " ");
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
    }
    public static void main(String []args)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Line by line lever order traversal ");
        LOrder l = new LOrder();
        l.lorder(root);
    }
}
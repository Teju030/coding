import java.util.*;
class SpiralTraversal
{
    void spiralorder1(Tnode root)
    {
        if(root == null) return ;
        Deque<Tnode> q = new LinkedList();
        q.add(root);
        boolean reverse = false;
        while(!q.isEmpty())
        {
            int size = q.size();
            if(reverse)
            {
                for(int i = 0; i< size; i++)
                {
                    Tnode curr = q.removeLast();
                    System.out.print(curr.data + " ");
                    if(curr.right != null) q.addFirst(curr.right); 
                    if(curr.left != null) q.addFirst(curr.left); 
                }
            }
            else
            {
                for(int i = 0; i< size; i++)
                {
                    Tnode curr = q.removeFirst();
                    System.out.print(curr.data + " ");
                    if(curr.left != null) q.addLast(curr.left);
                    if(curr.right != null) q.addLast(curr.right); 
                }
            }
            reverse = !reverse;
            System.out.println();
        }
    }
    void spiralorder(Tnode root)
    {
        if(root == null ) return ;

        Queue<Tnode> q  = new LinkedList();
        q.add(root);
        Stack<Tnode> stk = new Stack();
        boolean reverse = false;
        while(!q.isEmpty())
        {
            int size = q.size();
            if(reverse)
            {
                for(int i = 0; i< size; i++)
                {
                    Tnode curr = q.poll();
                    if(curr.left != null) q.add(curr.left);
                    if(curr.right != null) q.add(curr.right);
                    stk.push(curr);
                }
                while(!stk.isEmpty())
                {
                    System.out.print(stk.pop().data +  " ");
                }
            }
            else
            {
                for(int i = 0; i< size; i++)
                {
                    Tnode curr = q.poll();
                    if(curr.left != null) q.add(curr.left);
                    if(curr.right != null) q.add(curr.right);
                    System.out.print(curr.data+ " ");
                } 
            }

            reverse = !reverse;
            System.out.println();
        }
    }
    public static void main(String []args)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Spiral traversal of tree ");
        SpiralTraversal s = new SpiralTraversal();
        s.spiralorder1(root);
    }
}
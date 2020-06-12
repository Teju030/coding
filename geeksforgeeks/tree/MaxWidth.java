import java.util.*;
class MaxWidth
{
    int maxWidthofTree(Tnode root)
    {
        if(root == null) return 0;
        Queue<Tnode> q = new LinkedList();
        int max = Integer.MIN_VALUE;
        q.add(root);
        while(!q.isEmpty())
        {
            int cnt = q.size();
            max = (max < cnt )? cnt: max;
            for(int i=1; i<=cnt; i++ )
            {
                Tnode curr = q.poll();
                if(curr.left != null ) q.add(curr.left);
                if(curr.right != null ) q.add(curr.right);
            }
        }
        return max;
    }
    public static void main(String []args)
    {
        int []in = { 17, 13, 11, 14, 10, 15, 12, 16, 18 };
        int []pre = {10, 11, 13, 17, 14 ,12, 15, 16, 18};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Max width of tree ");
        MaxWidth s = new MaxWidth();
        System.out.println(s.maxWidthofTree(root));
        
        in = new int[] { 3, 8, 5, 20, 12 };
        pre = new int[] { 20, 8, 3, 5, 12 };
        root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Max width of tree ");
        System.out.println(s.maxWidthofTree(root));

        in = new int[] { 13, 12, 14, 8 , 15, 16, 17 };
        pre = new int[] { 8, 12, 13, 14, 15, 16 ,17 };
        root = t.buildBinaryTree(in, pre, in.length);
        t.preorder(root);
        System.out.println("\n Max width of tree");
        System.out.println(s.maxWidthofTree(root));
    }
}
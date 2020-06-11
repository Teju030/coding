import java.util.*;
class Tnode
{
    int data;
    Tnode left;
    Tnode right;
    Tnode(int d)
    {
        data = d;
    }
}

class Tree
{
    Tnode buildBinaryTreeHelper(int []in, int []pre, int inS, int inE, int preS, int preE)
    {
        if(inS > inE || preS > preE || inE >= in.length || preE >= pre.length)
        {
            return null;
        }
        // System.out.println((new String()).format("preS: %d , preE : %d , inS : %d , inE : %d", preS, preE, inS, inE));
        // start of pre is root
        Tnode root = new Tnode(pre[preS]);
        int inRootindex = -1;
        // search root in inorder
        for( int i = inS; i<= inE; i++)
        {
            if (in[i]== root.data)
            {
                inRootindex = i;
                break;
            }
        }
        // For left substree indices
        int linS = inS;
        int linE = inRootindex-1;
        int lpreS = preS+1;
        int lpreE = linE - linS + lpreS;
        // For right subtree indices
        int rpreS = lpreE + 1;
        int rpreE = preE;
        int rinS = inRootindex + 1;
        int rinE = inE;

        root.left = buildBinaryTreeHelper(in, pre, linS, linE, lpreS, lpreE);
        root.right = buildBinaryTreeHelper(in, pre, rinS, rinE, rpreS, rpreE);
        return root;

    }
    Tnode buildBinaryTree(int[] in, int []pre, int size)
    {
        return buildBinaryTreeHelper(in, pre, 0, size-1, 0, size -1);
    }
    // Inorder
    void inorder(Tnode root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.data +  " ");
        inorder(root.right);
    }
    // preorder
    void preorder(Tnode root)
    {
        if(root == null )
        {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    // postorder
    void postorder(Tnode root)
    {
        if(root == null )
        {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    // Level order traversal
    void levelorder(Tnode root)
    {
        if(root == null) return;
        Queue<Tnode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty())
        {
            Tnode curr = q.poll();
            System.out.print(curr.data + " ");
            if(curr.left != null)  q.add(curr.left);
            if(curr.right != null)  q.add(curr.right);
        }
    }
    public static void main(String args[])
    {
        
        int []in = { 13, 11, 14, 10, 15, 12};
        int []pre = {10, 11, 13, 14 ,12, 15};
        Tree t = new Tree();
        Tnode root = t.buildBinaryTree(in, pre, in.length);
        System.out.println("\n Inorder traversal");
        t.inorder(root);
        System.out.println("\n Preorder traversal");
        t.preorder(root);
        System.out.println("\n Postorder traversal");
        t.postorder(root);
        System.out.println("\n Level order traversal ");
        t.levelorder(root);
    }
}
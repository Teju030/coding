/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {

        int lp = getDepth(p);
        int lq = getDepth(q);
        //System.out.println("LP : " + lp + " lq : " + lq);
        int diff = Math.abs(lp - lq);
        if( lp > lq) {
            while(diff > 0 ){
                p = p.parent;
                diff--;
            }
        }else{
            while(diff > 0 ){
                q = q.parent;
                diff--;
            }
        }
        
        while(diff > 0 ){
                q = q.parent;
        }
        
        while(p!=q){
            p = p.parent;
            q = q.parent;
        }
        return p;
    }
    
    int getDepth(Node p){
        int level = 0;
        Node tmp = p;
        
        while(tmp!=null){
            level++;
            tmp = tmp.parent;
        }
        return level;
    }
    
    public Node anotherMethod(Node p, Node q){
        Stack<Node> stackp = new Stack<Node>();
        Stack<Node> stackq = new Stack<Node>();
        Node parent = p;
        while(parent!=null){
           // System.out.println(parent.val);
            stackp.push(parent);
            parent = parent.parent;
        }
        parent = q;
        while(parent!=null){
            stackq.push(parent);
            parent = parent.parent;
        }
        
        parent = null;
        while(!stackp.isEmpty() && !stackq.isEmpty() && stackp.peek() == stackq.peek()){
            parent = stackq.peek();
            stackp.pop();
            stackq.pop();
        }
        return parent;
        

        // Node ptrP = p;
        // Node ptrQ = q;
        
        // while (ptrP != ptrQ) {
        //     ptrP = ptrP == null ? q : ptrP.parent;
        //     ptrQ = ptrQ == null ? p : ptrQ.parent;
        // }
        
        // return ptrP;
    }
}
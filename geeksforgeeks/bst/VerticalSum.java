import java.util.*;
class VerticalSum
{
    TreeMap<Integer, Integer> map = new TreeMap();
    void getVerticalSum(Tnode root, int val)
    {
        if(root == null ) return;
        getVerticalSum(root.left, val-1);
        if(map.containsKey(val))
        {
            int tmp = map.get(val);
            tmp += root.data;
            map.put(val, tmp);
        } 
        else{
            map.put(val, root.data);
        }
        getVerticalSum(root.right, val+1);
        return;
    }
    public static void main(String []args)
    {
        BST bt = new BST();
        Tnode root = null;
        root = bt.insert(root, 10);
        bt.insert(root, 15);
        bt.insert(root, 25);
        bt.insert(root, 5);
        bt.insert(root, 4);
        bt.insert(root, 14);
        
        VerticalSum vs = new VerticalSum();
        vs.getVerticalSum(root, 0);
        System.out.println("Vartical Sum : "+ vs.map);
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> OldToNewMap = new HashMap<>();
        if(node == null) return null;
        return DFS(node, OldToNewMap);
    }
    
    public Node DFS(Node root, HashMap<Node, Node> map){
        if(map.containsKey(root)){
            return map.get(root);
        }
        
        Node copy = new Node(root.val);
        map.put(root, copy);
        for(Node kid : root.neighbors){
            Node kidNode = DFS(kid, map);
            copy.neighbors.add(kidNode);
        }
        return map.get(root);
        
    }
}
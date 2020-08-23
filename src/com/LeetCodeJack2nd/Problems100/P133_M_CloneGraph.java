package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P133_M_CloneGraph {
    Map<Integer, Node> visited;
    public Node cloneGraph(Node node) {
        visited = new HashMap<>();
        if(node == null)
            return node;
        helper(node);
        return visited.get(node.val);
    }
    private Node helper(Node node){
        if(!visited.containsKey(node.val)){
            Node root = new Node(node.val, new ArrayList<Node>());
            visited.put(node.val, root);
            for(Node neighbor:node.neighbors){
                if(!visited.containsKey(neighbor.val)){
                    root.neighbors.add(helper(neighbor));
                }else{
                    root.neighbors.add(visited.get(neighbor.val));
                }
            }
        }
        return visited.get(node.val);
    }

    private class Node {
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
}

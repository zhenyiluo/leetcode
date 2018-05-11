/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        if(hm.containsKey(node)){
            return hm.get(node);
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        hm.put(node, copy);
        for(UndirectedGraphNode neighbor : node.neighbors){
            copy.neighbors.add(cloneGraph(neighbor));
        }
        return copy;
    }
}
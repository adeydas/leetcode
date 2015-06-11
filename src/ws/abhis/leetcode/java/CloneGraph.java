package ws.abhis.leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

 1
 / \
 /   \
 0 --- 2
 / \
 \_/
 */
public class CloneGraph {
    class UndirectedGraphNode {
            int label;
             List<UndirectedGraphNode> neighbors;
             UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
        };


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return DFS(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
    }

    private UndirectedGraphNode DFS(UndirectedGraphNode root, HashMap<UndirectedGraphNode, UndirectedGraphNode> visited) {
        if (root == null)
            return root;

        UndirectedGraphNode node = new UndirectedGraphNode(root.label);
        visited.put(root, node);

        for (UndirectedGraphNode n : root.neighbors) {
            if (visited.containsKey(n)) {
                node.neighbors.add(visited.get(n));
            } else {
                node.neighbors.add(DFS(n, visited));
            }
        }
        return node;
    }
}


/*
    Definition for a Node:
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

// Definition for a Node (provided by LeetCode)
static class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

final private Map<Node, Node> oldToNew = new HashMap<>();

public Node cloneGraph(Node node) {
    return node != null ? dfs(node) : null;
}

private Node dfs(Node node) {
    if (oldToNew.containsKey(node)) return oldToNew.get(node);

    Node copyNode = new Node(node.val);
    oldToNew.put(node, copyNode);
    for (var neighbour : node.neighbors) {
        copyNode.neighbors.add(dfs(neighbour));
    }

    return copyNode;
}

// Overall time complexity: O(n)
void main() {
//*   too lazy to test it out here ngl
//    System.out.println(cloneGraph());
//    System.out.println(cloneGraph());
}

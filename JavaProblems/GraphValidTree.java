public boolean validTree(int n, int[][] edges) {
    if (n == 0) {
        return true;
    }

    // replace ArrayList of lists with a map of lists
    Map<Integer, List<Integer>> adj = new HashMap<>();

    // build adjacency list from edge pairs
    for (int[] edge : edges) {
        int n1 = edge[0];
        int n2 = edge[1];

        // ensure each node has a list
        adj.computeIfAbsent(n1, _ -> new ArrayList<>());
        adj.computeIfAbsent(n2, _ -> new ArrayList<>());

        adj.get(n1).add(n2);
        adj.get(n2).add(n1); //* as the graph is undirected, both nodes are added in each other's lists
    }

    Set<Integer> visit = new HashSet<>();

    if (!dfs(0, -1, adj, visit)) {
        return false;
    }

    return n == visit.size();
}

private boolean dfs(int i, int prev, Map<Integer, List<Integer>> adj, Set<Integer> visit) {
    if (visit.contains(i)) {
        return false;
    }

    visit.add(i);

    // this condition skips iteration if neighbors do not exist
    //! NOTE: it won't affect the end result if there are any isolated nodes, because in validTree()
    //! there will be a final check of whether n is equal to the number of VISITED nodes
    List<Integer> neighbors = adj.get(i);
    if (neighbors == null || neighbors.isEmpty()) {
        return true;
    }

    for (int j : neighbors) {
        if (j == prev) {
            continue;
        }
        if (!dfs(j, i, adj, visit)) {
            return false;
        }
    }

    return true;
}

// Overall time complexity: O(V + E) vertices + edges
void main() {
    int n1 = 5;
    int[][] edges1 = {
            {0, 1},
            {0, 2},
            {0, 3},
            {1, 4}
    };
    System.out.println(validTree(n1, edges1));

    int n2 = 5;
    int[][] edges2 = {
            {0, 1},
            {1, 2},
            {2, 3},
            {1, 3},
            {1, 4}
    };
    System.out.println(validTree(n2, edges2));

    int n3 = 5;
    int[][] edges3 = {
            {0, 1},
            {2, 3}
    };
    System.out.println(validTree(n3, edges3));

    int n4 = 1;
    int[][] edges4 = {};
    System.out.println(validTree(n4, edges4));
}
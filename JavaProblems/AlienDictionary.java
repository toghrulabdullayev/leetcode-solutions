import java.util.*;

class Solution {
    public static String alienOrder(String[] words) {
        // Initialize adjacency list for the graph
        // Each character maps to a set of characters that come after it.
        Map<Character, Set<Character>> adj = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        // Build the graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            // Check for invalid order: if w1 is a prefix of w2 but w1 is longer
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }

            // Find the first differing character to establish an order
            for (int j = 0; j < minLen; j++) {
                char char1 = w1.charAt(j);
                char char2 = w2.charAt(j);
                if (char1 != char2) {
                    // char in w1 will be a key to the value of chars set from w2 coming after w1 in "alien" alphabet
                    adj.get(char1).add(char2); // char in w2 comes AFTER the char in w1
                    break; // Once a difference is found, this pair of words provides no more ordering info
                }
            }
        }

        // `visit` map to track DFS states:
        // 0 = unvisited
        // 1 = visiting (currently in recursion stack) - used for cycle detection
        // 2 = visited (fully processed and added to result)
        Map<Character, Integer> visit = new HashMap<>();
        // Initialize all characters as unvisited
        for (char c : adj.keySet()) {
            visit.put(c, 0);
        }

        // `res` will store characters in reverse topological order
        List<Character> res = new ArrayList<>();

        // Post-order DFS for topological sort and cycle detection
        for (char c : adj.keySet()) {
            // If dfs returns true, a cycle was detected
            if (dfs(c, adj, visit, res)) {
                return ""; // Detected a loop (invalid)
            }
        }

        // Reverse the result to get the correct topological order
        Collections.reverse(res);

        // Convert the list of characters to a string
        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }
        return sb.toString();
    }

    // DFS helper function
    // Returns true if a cycle is detected, false otherwise
    private static boolean dfs(char c, Map<Character, Set<Character>> adj, Map<Character, Integer> visit, List<Character> res) {
        // If already visiting this node, it's a cycle
        if (visit.get(c) == 1) {
            return true;
        }
        // If already fully visited, no need to process again
        if (visit.get(c) == 2) {
            return false;
        }

        // Mark as visiting
        visit.put(c, 1);

        // Recurse on neighbors
        for (char nei : adj.get(c)) {
            if (dfs(nei, adj, visit, res)) {
                return true; // Propagate cycle detection
            }
        }

        // Mark as fully visited
        visit.put(c, 2);
        // Add to result list (post-order traversal)
        res.add(c);
        return false; // No cycle detected from this node
    }

    // Overall time complexity: O(L), where L is total length of all words
    static void main() {
        System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }
}
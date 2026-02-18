import java.util.HashSet;
import java.util.Set;

//! NOTE: While loop here doesn't increase the time complexity to O(n^2)
class Solution {
    public int longestConsecutive(int[] nums) {
        // Converting the array to a set (same time complexity for all langs): O(n)
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;
        // Iterate through the set: O(n)
        for (int num : numSet) {
            // check if it's the start of a sequence: O(1)
            if (!numSet.contains(num - 1)) {
                int length = 0;
                // if 100 is the start, length becomes 1 and it looks-up for 100 + 1, 100 + 2 and etc: O(1)
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length); // O(1)
                // longest = longest > length ? longest : length; // also O(1)
            }
        }

        return longest;
    }
}

public class LongestConsecutiveSequence {
    static void main() {
        var solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(solution.longestConsecutive(new int[]{1, 0, 1, 2}));
    }
}
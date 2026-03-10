public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    // time complexity of sorting an array: O(n * log(n))
    Arrays.sort(nums); // sorting enables the two-pointer technique

    // if the first element is already positive or the last one is already negative, sum will never be 0
    if (nums[0] > 0 || nums[nums.length - 1] < 0) {
        return res;
    }

    // O(n ^ 2), do/while doesn't increase the time complexity
    for (int i = 0; i < nums.length; i++) {
        // skip duplicate values to avoid generating duplicate triplets
        if (i > 0 && nums[i] == nums[i - 1]) continue;

        // left points to the element after i
        int l = i + 1, r = nums.length - 1;
        while (l < r) {
            int threeSum = nums[i] + nums[l] + nums[r];
            if (threeSum > 0) {
                r--; // moves right pointer to a smaller (or equal) value
            } else if (threeSum < 0) {
                l++; // moves left pointer to a larger (or equal) value
            } else {
                res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                // "do" is executed once before checking the while condition
                do {
                    l++; // skip duplicate values to avoid repeated triplets
                } while (l < r && nums[l] == nums[l - 1]);
            }
        }
    }

    return res;
}

// Overall time complexity: O(n^2); space complexity: O(1) or O(n), depends on the lang's sorting implementation
void main() {
    System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    System.out.println(threeSum(new int[]{0, 1, 1}));
    System.out.println(threeSum(new int[]{0, 0, 0}));
    System.out.println(threeSum(new int[]{-2, -2, 0, 0, 2, 2}));
}

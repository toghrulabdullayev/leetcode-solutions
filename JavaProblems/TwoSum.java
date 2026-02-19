// returns indices in an array
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numMap = new HashMap<>();

    // converting the array into a map: O(n)
    for (int i = 0; i < nums.length; i++) {
        // suppose target = 9. If the element is 2, the 2nd should be 7
        int diff = target - nums[i];
        // looking up for the second value: O(1)-O(n)
        if (numMap.containsKey(diff)) {
            return new int[]{numMap.get(diff), i};
        }
        // key=num -> value=index: O(1)-O(n)
        numMap.put(nums[i], i);
    }

    return null;
}

// Overall time complexity (must be < O(n^2)): O(n)
void main() {
    System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
}

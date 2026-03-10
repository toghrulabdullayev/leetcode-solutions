// Sum-based method: Time complexity: O(n); Space complexity: O(1)
public int missingNumber(int[] nums) {
    int res = nums.length; // length is added beforehand to avoid IndexOutOfBounds error

    // missingNum = sum([0...length]) - sum(nums)
    for (int i = 0; i < nums.length; i++) {
        res += (i - nums[i]);
    }

    return res;
}

// XOR-based method: Time complexity: O(n); Space complexity: O(1)
public int missingNumber2(int[] nums) {
    int res = nums.length;

    //? Comes from XOR properties: i ^ i = 0 and i ^ 0 = i (can be proven using bit strings)
    for (int i = 0; i < nums.length; i++) {
        res ^= nums[i] ^ i;
    }

    return res;
}

//* Could also be solved using a HashSet; however, the space complexity would be O(n) instead of O(1).
void main() {
    System.out.println(missingNumber(new int[]{3, 0, 1}));
    System.out.println(missingNumber(new int[]{0, 1}));
    System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));

    System.out.println(missingNumber2(new int[]{3, 0, 1}));
    System.out.println(missingNumber2(new int[]{0, 1}));
    System.out.println(missingNumber2(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
}

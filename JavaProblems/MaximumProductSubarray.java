import java.util.Arrays;

// * dynamic programming
class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int res = Arrays.stream(nums).max().getAsInt();  // 0 -> [-1]
        int curMin = 1, curMax = 1;

        for (int n : nums) {
            if (n == 0) {  // ignore 0 to not mess up the product
                curMin = 1;
                curMax = 1;
                continue;
            }

            int tmp = curMax * n;
            curMax = Math.max(n, Math.max(tmp, n * curMin));
            curMin = Math.min(n, Math.min(tmp, n * curMin));

            res = Math.max(res, curMax);
        }

        return res;
    }

    // Overall time complexity: O(n), space complexity: O(1)
    static void main() {
        var sol = new MaximumProductSubarray();
        System.out.println(sol.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(sol.maxProduct(new int[]{-2, 0, -1}));
    }
}
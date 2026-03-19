# * dynamic programming
class Solution:
    def maxProduct(self, nums):
        res = max(nums)  # 0 -> [-1]
        curMin, curMax = 1, 1

        for n in nums:
            if n == 0:  # ignore 0 to not mess up the product
                curMin, curMax = 1, 1
                continue

            tmp = curMax * n
            curMax = max(tmp, n * curMin, n)
            curMin = min(tmp, n * curMin, n)
            res = max(res, curMax, curMin)

        return res


# Overall time complexity: O(n), space complexity: O(1)
print(Solution().maxProduct([2, 3, -2, 4]))
print(Solution().maxProduct([-2, 0, -1]))

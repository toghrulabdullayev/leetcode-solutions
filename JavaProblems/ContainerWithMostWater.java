public int maxArea(int[] height) {
    int res = 0;
    int l = 0, r = height.length - 1;

    while (l < r) {
        // multiply by the shorter border because water spills over the shorter side
        int area = Math.min(height[l], height[r]) * (r - l);
        res = Math.max(res, area);

        // move the pointer with the smaller height inward
        if (height[l] < height[r]) {
            l++;
        } else {
            // else if (height[l] > height[r]) is merged here
            //! NOTE: If both borders are equal, either pointer can be moved.
            //! Even if one side has a taller boundary ahead, either side can be shifted.
            r--;
        }
    }

    return res;
}

// Overall time complexity: O(n)
void main() {
    System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49 (7 and leftmost 8)
    System.out.println(maxArea(new int[]{1, 1})); // 1
}

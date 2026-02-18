// using Sliding Window technique (NOTE: while doesn't add to time complexity)
public int lengthOfLongestSubstring(String s) {
    Set<Character> charSet = new HashSet<>();
    int left = 0;
    int res = 0;

    // moving right side of the sliding window
    for (int right = 0; right < s.length(); right++) {
        // if right side contains the char, remove it from the left side and move the left side: both O(1)
        while (charSet.contains(s.charAt(right))) {
            charSet.remove(s.charAt(left));
            left += 1;
        }

        // Adding chars from the right side to avoid repetition: O(1)
        charSet.add(s.charAt(right));
        res = Math.max(res, right - left + 1); // res vs the current substr length
    }

    return res;
}

void main() {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(lengthOfLongestSubstring("bbbbb"));
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
}
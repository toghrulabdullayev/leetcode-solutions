// in order to get the longest palindrome, we check for both odd and even palindromes separately
@SuppressWarnings("D")
public String longestPalindrome(String s) {
    String res = "";
    int resLen = 0;

    // iterating through each character: O(n)
    for (int i = 0; i < s.length(); i++) {
        // odd length palindrome check
        int left = i;
        int right = i;

        // iterating until not palindrome or hit the limit: O(n/k) -> O(n)
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // if current length greater than the result length
            if ((right - left + 1) > resLen) {
                res = s.substring(left, right + 1);
                resLen = right - left + 1;
            }
            // spreads out to the sides
            left--;
            right++;
        }

        // even length palindrome check
        left = i;
        right = i + 1; //* the only difference between odd and even check

        // iterating until not palindrome or hit the limit: O(n/k) -> O(n)
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // if current length greater than the result length
            if ((right - left + 1) > resLen) {
                res = s.substring(left, right + 1);
                resLen = right - left + 1;
            }
            // spreads out to the sides
            left--;
            right++;
        }
    }

    return res;
}

// Overall time complexity: O(n^2)
void main() {
    System.out.println(longestPalindrome("babad"));
    System.out.println(longestPalindrome("cbbd"));
}

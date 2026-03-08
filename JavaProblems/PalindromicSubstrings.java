public int countSubstrings(String s) {
    int res = 0; // counts all palindromic substrings

    // spreading out left and right until the substr is not a palindrome or one of them is out of bounds
    for (int i = 0; i < s.length(); i++) {
        // for odd palindromes
        int l = i, r = i;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res++;
            l--;
            r++;
        }

        // for even palindromes
        l = i;
        r = i + 1;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res++;
            l--;
            r++;
        }
    }

    return res;
}

// Overall time complexity: O(n ^ 2)
void main() {
    System.out.println(countSubstrings("aaa")); // 6 (a, a, a, aa, aa, aaa)
    System.out.println(countSubstrings("abc")); // 3 (a, b, c)
    System.out.println(countSubstrings("pwwkew")); // 7 (p, w, w, k, e, w, ww)
}

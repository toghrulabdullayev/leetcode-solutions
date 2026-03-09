public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[s.length()] = true;

    for (int i = s.length() - 1; i > -1; i--) {
        for (String word : wordDict) {
            if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
                dp[i] = dp[i + word.length()];
            }
            if (dp[i]) break;
        }
    }

    return dp[0];
}

void main() {
    System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
    System.out.println(wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen"))));
    System.out.println(wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
}
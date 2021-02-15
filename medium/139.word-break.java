public boolean wordBreak(String s, List<String> words) {
    boolean[] dp = new boolean[s.length()+1];
    dp[0] = true;

    for (int i=0; i<s.length(); i++) {
        if (!dp[i]) {
            continue;
        }

        for (String word : words) {
            if (s.startsWith(word, i)) {
                dp[i+word.length()] = true;
            }
        }
    }

    return dp[s.length()];
}

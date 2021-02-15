public int numDecodings(String s) {
    int[] dp = new int[s.length()+1];
    dp[0] = 1;
    dp[1] = s.charAt(0) != '0' ? 1 : 0;

    for (int i=1; i<s.length(); i++) {
        int oneDigit = s.charAt(i) - '0';
        int twoDigit = (s.charAt(i-1) - '0') * 10 + oneDigit;

        if (oneDigit > 0) {
            dp[i+1] = dp[i];
        }

        if (twoDigit >= 10 && twoDigit <= 26) {
            dp[i+1] += dp[i-1];
        }
    }

    return dp[s.length()];
}

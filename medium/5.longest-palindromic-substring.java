public String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];

    String max = "";
    // base case: one-char substring
    for (int i=0; i<n; i++) {
        dp[i][i] = true;
        max = s.substring(i, i+1);
    }

    // base case: two-char substring
    for (int i=0; i+1<n; i++) {
       if (s.charAt(i) == s.charAt(i+1)) {
           dp[i][i+1] = true;
           max = s.substring(i, i+2);
       }
    }

    // all other cases
    for (int len=3; len<=n; len++) {
        for (int i=0, j=i+len-1; j<n; i++, j++) {
            if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                dp[i][j] = true;
                max = s.substring(i, j+1);
            }
        }
    }

    return max;
}

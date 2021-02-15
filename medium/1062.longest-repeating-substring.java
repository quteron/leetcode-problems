public int longestRepeatingSubstring(String s) {
    int n = s.length();
    int[][] dp = new int[n+1][n+1];

    int max = 0;
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            if (i == j || s.charAt(i) != s.charAt(j)) {
                continue;
            }

            dp[i+1][j+1] = dp[i][j] + 1;
            max = Math.max(max, dp[i+1][j+1]);
        }
    }

    return max;
}

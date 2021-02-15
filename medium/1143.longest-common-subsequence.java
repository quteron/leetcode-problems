public int longestCommonSubsequence(String a, String b) {
    int[][] dp = new int[a.length()+1][b.length()+1];

    for (int i=0; i<a.length(); i++) {
        for (int j=0; j<b.length(); j++) {
            if (a.charAt(i) == b.charAt(j)) {
                dp[i+1][j+1] = 1 + dp[i][j];
            } else {
                dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
    }

    return dp[a.length()][b.length()];
}

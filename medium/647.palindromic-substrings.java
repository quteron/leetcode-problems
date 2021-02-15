class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        // base case: one-char substring
        for (int i=0; i<n; i++) {
            dp[i][i] = true;
            count++;
        }


        // base case: two-char substring
        for (int i=0; i+1<n; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                count++;
            }
        }

        // all other cases
        for (int len=3; len<=n; len++) {
            for(int i=0, j=i+len-1; j<n; i++, j++) {
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}

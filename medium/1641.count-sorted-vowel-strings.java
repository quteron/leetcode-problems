class Solution {
    public int countVowelStrings(int n) {
        int[][] memo = new int[n][5];

        // when size is 1 - we can choose only from the vowels that we have
        for (int i=0; i<5; i++) {
            memo[0][i] = i+1;
        }

        // when vowel is 1 - we can build more than one sequence
        for (int i=1; i<n; i++) {
            memo[i][0] = 1;
            for (int j=1; j<5; j++) {
                memo[i][j] = memo[i-1][j] + memo[i][j-1];
            }
        }

        return memo[n-1][4];
    }

    private int countVowelStrings(int pos, int n) {
        if (n == 0) {
            return 1;
        }

        int count = 0;
        for (int i=pos; i<5; i++) {
            count += countVowelStrings(i, n-1);
        }

        return count;
    }
}

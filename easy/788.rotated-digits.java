class Solution {
    public int rotatedDigits(int n) {
        int count = 0;

        for (int i=1; i<=n; i++) {
            if (good(i, false, new HashMap<Integer, Boolean>())) {
                count++;
            }
        }

        return count;
    }

    private boolean good(int n, boolean state, Map<Integer, Boolean> memo) {
        if (n == 0) {
            return state;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int d = n % 10;
        if (d == 3 || d == 4 || d == 7) {
            memo.put(n, false);
        } else if (d == 0 || d == 1 || d == 8) {
            memo.put(n, good(n/10, state, memo));
        } else {
            memo.put(n, good(n/10, true, memo));
        }

        return memo.get(n);
    }
}

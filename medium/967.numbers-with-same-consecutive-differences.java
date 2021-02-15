class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList();

        for (int digit=1; digit<10; digit++) {
            backtracking(digit, digit, n-1, k, ans);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void backtracking(Integer current, int lastDigit, int n, int k, List<Integer> ans) {
        if (n == 0) {
            ans.add(current);
            return;
        }

        if (lastDigit-k >= 0) {
            int nextDigit = lastDigit-k;
            int next = current*10 + nextDigit;
            backtracking(next, nextDigit, n-1, k, ans);
        }

        if (k != 0 && lastDigit+k <= 9) {
            int nextDigit = lastDigit+k;
            int next = current*10 + nextDigit;
            backtracking(next, nextDigit, n-1, k, ans);
        }
    }
}

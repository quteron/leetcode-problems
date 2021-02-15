class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList();
        backtracking(2, n, new LinkedList(), ans);
        return ans;
    }

    private void backtracking(int number, int target, LinkedList<Integer> current, List<List<Integer>> ans) {
        if (target == 1) {
            if (current.size() > 1) {
                ans.add(new ArrayList(current));
            }

            return;
        }

        for (int i=number; i<=target; i++) {
            if (target % i != 0) {
                continue;
            }

            current.addLast(i);
            backtracking(i, target / i, current, ans);
            current.removeLast();
        }
    }
}

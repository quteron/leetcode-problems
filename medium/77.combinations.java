class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combine(1, n, k, new LinkedList(), ans);
        return ans;
    }

    private void combine(int pos, int n, int k, LinkedList<Integer> current, List<List<Integer>> ans) {
        if (k == 0) {
            ans.add(new ArrayList(current));
            return;
        }

        for (int i=pos; i<=n; i++) {
            current.add(i);
            combine(i+1, n, k-1, current, ans);
            current.removeLast();
        }
    }
}

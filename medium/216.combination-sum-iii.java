class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList();
        combinationSum3(n, k, 1, 9, new LinkedList(), ans);
        return ans;
    }

    private void combinationSum3(int target, int count, int start, int end, LinkedList<Integer> current, List<List<Integer>> ans) {
        if (target == 0 && count == 0) {
            ans.add(new ArrayList(current));
            return;
        }

        if (target == 0 || count == 0) {
            return;
        }

        for (int i=start; i<=end; i++) {
            if (target < i) {
                break;
            }

            current.add(i);
            combinationSum3(target-i, count-1, i+1, end, current, ans);
            current.removeLast();
        }
    }
}

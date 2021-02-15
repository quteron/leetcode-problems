class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        combinationSum2(candidates, target, 0, new ArrayList(), ans);

        return ans;
    }

    private void combinationSum2(int[] candidates, int target, int pos, List<Integer> current, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList(current));
            return;
        }

        for (int i=pos; i<candidates.length; i++) {
            if (i > pos && candidates[i] == candidates[i-1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);
            combinationSum2(candidates, target-candidates[i], i+1, current, ans);

            current.remove(current.size()-1);
        }
    }
}

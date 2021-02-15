class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> output = new ArrayList<>();
        combinationSum(candidates, target, 0, new ArrayList(), output);

        return output;
    }

    public void combinationSum(int[] candidates, int target, int pos, List<Integer> current, List<List<Integer>> output) {
        if (target == 0) {
            output.add(new ArrayList(current));
            return;
        }

        for (int i=pos; i<candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);
            combinationSum(candidates, target-candidates[i], i, current, output);

            current.remove(current.size()-1);
        }
    }
}

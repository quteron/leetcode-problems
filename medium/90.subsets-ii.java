class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        subsetsWithDup(nums, 0, new ArrayList(), ans);
        return ans;
    }

    private void subsetsWithDup(int[] nums, int pos, List<Integer> current, List<List<Integer>> ans) {
        ans.add(new ArrayList(current));

        for (int i=pos; i<nums.length; i++) {
            if (i > pos && nums[i-1] == nums[i]) {
                continue;
            }

            current.add(nums[i]);
            subsetsWithDup(nums, i+1, current, ans);
            current.remove(current.size()-1);
        }
    }
}

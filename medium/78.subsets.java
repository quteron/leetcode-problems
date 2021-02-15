class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsets(0, nums, new ArrayList(), ans);
        return ans;
    }

    private void subsets(int i, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        ans.add(new ArrayList(current));

        for (int j=i; j<nums.length; j++) {
            current.add(nums[j]);
            subsets(j+1, nums, current, ans);
            current.remove(current.size()-1);
        }
    }
}

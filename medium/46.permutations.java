class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        permute(nums, 0, ans);
        return ans;
    }

    private void permute(int[] nums, int pos, List<List<Integer>> ans) {
        if (pos == nums.length) {
            List<Integer> permutation = new ArrayList();
            for (int num : nums) {
                permutation.add(num);
            }
            ans.add(permutation);
            return;
        }

        for (int i=pos; i<nums.length; i++) {
            swap(nums, i, pos);
            permute(nums, pos+1, ans);
            swap(nums, pos, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

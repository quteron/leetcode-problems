class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        permuteUnique(nums, 0, ans);
        return ans;
    }

    private void permuteUnique(int[] nums, int pos, List<List<Integer>> ans) {
        if (pos == nums.length) {
            List<Integer> permutation = new ArrayList();
            for (int num : nums) {
                permutation.add(num);
            }
            ans.add(permutation);
            return;
        }

        Set<Integer> swapped = new HashSet();
        for (int i=pos; i<nums.length; i++) {
            if (swapped.contains(nums[i])) {
                continue;
            }

            swapped.add(nums[i]);

            swap(nums, i, pos);
            permuteUnique(nums, pos+1, ans);
            swap(nums, pos, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

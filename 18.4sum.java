class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 4, 0, target, new ArrayList());
    }

    private List<List<Integer>> kSum(int[] nums, int k, int start, int target, List<Integer> current) {
        List<List<Integer>> ans = new ArrayList();

        if (k == 2) {
            return twoSum(nums, start, target, current);
        }

        for (int i=start; i<nums.length; i++) {
            if (i == start || nums[i] != nums[i-1]) {
                current.add(nums[i]);
                ans.addAll(kSum(nums, k-1, i+1, target-nums[i], current));
                current.remove(current.size()-1);
            }
        }

        return ans;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target, List<Integer> current) {
        List<List<Integer>> ans = new ArrayList();

        Set<Integer> seen = new HashSet();
        for (int i=start; i<nums.length; i++) {
            int complement = target-nums[i];
            if (seen.contains(complement)) {
                List<Integer> found = new ArrayList(current);
                found.add(complement);
                found.add(nums[i]);
                ans.add(found);

                while (i+1<nums.length && nums[i] == nums[i+1]) {
                    i++;
                }
            }

            seen.add(nums[i]);
        }

        return ans;
    }
}

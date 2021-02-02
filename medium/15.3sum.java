public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> output = new ArrayList<>();
    for (int i=0; i<nums.length; i++) {
        if (i == 0 || (nums[i] != nums[i-1] && nums[i] <= 0)) {
            twoSum(nums, i, output);
        }
    }

    return output;
}

private void twoSum(int[] nums, int index, List<List<Integer>> output) {
    Set<Integer> visited = new HashSet<>();
    for (int i=index+1; i<nums.length; i++) {
        int complement = -(nums[index] + nums[i]);
        if (visited.contains(complement)) {
            output.add(Arrays.asList(nums[index], complement, nums[i]));
            while (i+1<nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }
        visited.add(nums[i]);
    }
}

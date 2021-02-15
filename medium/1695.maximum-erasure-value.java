public int maximumUniqueSubarray(int[] nums) {
    int maxSum=0, curSum=0;
    int l=0, r=0;

    Set<Integer> visited = new HashSet();
    while (r<nums.length) {
        if (!visited.contains(nums[r])) {
            visited.add(nums[r]);
            curSum += nums[r++];
        } else {
            visited.remove(nums[l]);
            curSum -= nums[l++];
        }

        maxSum = Math.max(maxSum, curSum);
    }

    return maxSum;
}

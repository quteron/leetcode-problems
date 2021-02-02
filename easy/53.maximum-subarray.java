public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }

    int cur = nums[0];
    int max = cur;

    for (int i=1; i<nums.length; i++) {
        cur = Math.max(cur+nums[i], nums[i]);
        max = Math.max(max, cur);
    }

    return max;
}

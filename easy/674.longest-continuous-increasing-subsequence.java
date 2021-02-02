public int findLengthOfLCIS(int[] nums) {
    int max = 0;
    int anchor = 0;

    for (int i=0; i<nums.length; i++) {
        if (i > 0 && nums[i] <= nums[i-1]) {
            anchor = i;
        }
        max = Math.max(max, i-anchor+1);
    }

    return max;
}

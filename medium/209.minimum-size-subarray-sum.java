public int minSubArrayLen(int target, int[] nums) {
    int min = nums.length+1;
    int sum = 0;

    int l = 0, r = 0;
    while (l < nums.length) {
        if (r < nums.length && sum < target) {
            sum += nums[r++];
        } else if (sum >= target) {
            min = Math.min(min, r-l);
            sum -= nums[l++];
        } else {
            break;
        }
    }

    return min == nums.length+1 ? 0 : min;
}

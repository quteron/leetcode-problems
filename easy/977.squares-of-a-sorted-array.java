public int[] sortedSquares(int[] nums) {
    int[] output = new int[nums.length];

    int i = nums.length-1;
    int l = 0, r = nums.length-1;
    while (l <= r) {
        if (nums[l] * nums[l] >= nums[r] * nums[r]) {
            output[i--] = nums[l] * nums[l];
            l++;
        } else {
            output[i--] = nums[r] * nums[r];
            r--;
        }
    }

    return output;
}

public int maxProduct(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }

    int max = nums[0];
    int min = nums[0];
    int output = max;

    for (int i=1; i<nums.length; i++) {
        int currMax = Math.max(min*nums[i], max*nums[i]);
        int currMin = Math.min(min*nums[i], max*nums[i]);

        min = Math.min(currMin, nums[i]);
        max = Math.max(currMax, nums[i]);

        output = Math.max(max, output);
    }
    
    return output;
}

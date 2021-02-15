public int maxProduct(int[] nums) {
    int max=nums[0];
    int minProduct=max, maxProduct=max;

    for (int i=1; i<nums.length; i++) {
        int curMinProduct = Math.min(minProduct * nums[i], maxProduct * nums[i]);
        int curMaxProduct = Math.max(minProduct * nums[i], maxProduct * nums[i]);

        minProduct = Math.min(curMinProduct, nums[i]);
        maxProduct = Math.max(curMaxProduct, nums[i]);

        max = Math.max(max, maxProduct);
    }

    return max;
}

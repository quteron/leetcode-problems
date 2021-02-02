public int[] productExceptSelf(int[] nums) {
    int[] output = new int[nums.length];

    output[0] = 1;
    for(int i=1; i<nums.length; i++) {
        output[i] = nums[i-1] * output[i-1];
    }

    int product = 1;
    for(int i=nums.length-2; i>=0; i--) {
        product *= nums[i+1];
        output[i] *= product;
    }

    return output;
}

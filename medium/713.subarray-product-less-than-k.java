public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k < 2) {
        return 0;
    }

    int product = 1, lo=0, ans=0;
    for (int i=0; i<nums.length; i++) {
        product *= nums[i];
        while (product >= k) {
            product /= nums[lo++];
        }
        ans += i-lo+1;
    }
    return ans;
}

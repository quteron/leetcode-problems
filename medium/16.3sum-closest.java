public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    int diff = Integer.MAX_VALUE;
    for (int i=0; i<nums.length; i++) {
        int lo=i+1, hi=nums.length-1;
        while (lo<hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (Math.abs(sum-target) < Math.abs(diff)) {
                diff = sum-target;
            }

            if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
    }

    return target + diff;
}

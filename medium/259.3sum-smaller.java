class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            ans += twoSumSmaller(nums, i+1, target-nums[i]);
        }
        return ans;
    }

    private int twoSumSmaller(int[] nums, int start, int target) {
        int ans = 0;
        int lo=start, hi=nums.length-1;
        while(lo < hi) {
            if (nums[lo] + nums[hi] < target) {
                ans += hi-lo;
                lo++;
            } else {
                hi--;
            }
        }

        return ans;
    }
}

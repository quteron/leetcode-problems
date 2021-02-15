class Solution {
    public int[] prevPermOpt1(int[] nums) {
        int i=nums.length-2;
        while (i >= 0 && nums[i] <= nums[i+1]) {
            i--;
        }

        // it's already the smallest
        if (i == -1) {
            return nums;
        }

        int j=searchFirstMaxSmallest(nums, nums[i], i+1);
        swap(nums, i, j);

        return nums;
    }

    private int searchFirstMaxSmallest(int[] nums, int target, int lo) {
        int hi = nums.length-1;

        while (lo<=hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] < target) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }

        while (nums[hi] == nums[hi-1]) {
            hi--;
        }

        return hi;
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

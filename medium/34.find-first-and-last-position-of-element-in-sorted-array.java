class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        if (nums.length == left || nums[left] != target) {
            return new int[] {-1, -1};
        }

        int right = binarySearch(nums, target, false);
        return new int[] {left, right-1};
    }

    private int binarySearch(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }

        return lo;
    }
}

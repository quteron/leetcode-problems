public int search(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length-1;

    while (lo <= hi) {
        int mid = lo + (hi-lo)/2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] >= nums[lo]) {
            if (nums[lo] <= target && nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        } else {
            if (nums[hi] >= target && nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
    }

    return -1;
}

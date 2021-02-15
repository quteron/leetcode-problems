class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int lo = search(nums, target, true);
        int hi = search(nums, target, false);

        return hi-lo+1 > nums.length/2;
    }

    private int search(int[] nums, int target, boolean left) {
        int lo=0, hi=nums.length-1;
        while (lo<=hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] == target) {
                if (left) {
                    hi = mid-1;
                } else {
                    lo = mid+1;
                }
            } else if (nums[mid] > target) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }

        return left ? lo : hi;
    }
}

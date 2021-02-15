class Solution {
    public void sortColors(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        int mid = lo;

        while (mid <= hi) {
            if (nums[mid] == 0) {
                swap(nums, lo, mid);
                lo++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, hi, mid);
                hi--;
            } else {
                mid++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

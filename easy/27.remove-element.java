class Solution {
    public int removeElement(int[] nums, int val) {
        int lastNotValue = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                nums[lastNotValue++] = nums[i];
            }
        }

        return lastNotValue;
    }
}

public int removeDuplicates(int[] nums) {
    int lo=1, count=1;

    for (int i=1; i<nums.length; i++) {
        if (nums[i] == nums[i-1]) {
            count++;
        } else {
            count = 1;
        }

        if (count <= 2) {
            nums[lo++] = nums[i];
        }
    }

    return lo;
}

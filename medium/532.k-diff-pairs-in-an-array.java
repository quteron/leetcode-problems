public int findPairs(int[] nums, int k) {
    int count = 0;
    Arrays.sort(nums);

    int l=0, r=0;
    while (l < nums.length && r < nums.length) {
        if (l == r || nums[r]-nums[l] < k) {
            r++;
        } else if (nums[r]-nums[l] > k) {
            l++;
        } else {
            count++;
            l++;

            while (l < nums.length && nums[l] == nums[l-1]) {
                l++;
            }
        }
    }

    return count;
}

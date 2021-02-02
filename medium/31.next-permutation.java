public void nextPermutation(int[] nums) {
    int n = nums.length;
    if (n == 1) {
        return;
    }

    int i = n-1;
    while (i > 0 && nums[i] <= nums[i-1]) {
        i--;
    }

    if (i != 0) {
        int j = n-1;
        while (nums[j] <= nums[i-1]) {
            j--;
        }
        swap(nums, j, i-1);
    }

    reverse(nums, i, n-1);
}

private void reverse(int[] nums, int l, int r) {
    while (l < r) {
        swap(nums, l++, r--);
    }
}

private void swap(int nums[], int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
}

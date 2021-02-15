public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    int l=0, r=nums.length-1;
    int[] ans = new int[nums.length];

    int i = a>=0 ? nums.length-1 : 0;
    while (l<=r) {
        int first = a*nums[l]*nums[l] + b*nums[l] + c;
        int second = a*nums[r]*nums[r] + b*nums[r] + c;

        if (a >= 0) {
            if (first > second) {
                ans[i--] = first;
                l++;
            } else  {
                ans[i--] = second;
                r--;
            }
        } else {
            if (first < second) {
                ans[i++] = first;
                l++;
            } else  {
                ans[i++] = second;
                r--;
            }
        }
    }

    return ans;
}

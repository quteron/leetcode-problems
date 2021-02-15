public int maxArea(int[] height) {
    int max = 0;

    int l = 0, r = height.length-1;
    while (l <= r) {
        int curHeight = Math.min(height[l], height[r]);
        max = Math.max(max, (r-l) * curHeight);

        if (height[l] > height[r]) {
            r--;
        } else {
            l++;
        }
    }

    return max;
}

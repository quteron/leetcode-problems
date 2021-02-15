public int longestOnes(int[] a, int k) {
    int left=0, right=0;
    for (;right<a.length; right++) {
        if (a[right] == 0) {
            k--;
        }

        if (k < 0) {
            if (a[left] == 0) {
                k++;
            }
            left++;
        }
    }

    return right-left;
}

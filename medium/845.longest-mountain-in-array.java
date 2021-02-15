public int longestMountain(int[] a) {
    int ans=0, lo=0;
    while (lo<a.length) {
        int hi = lo;
        if (hi+1<a.length && a[hi] < a[hi+1]) {
            // go up to the peak
            while (hi+1<a.length && a[hi] < a[hi+1]) {
                hi++;
            }

            // is it really a peak
            if (hi+1<a.length && a[hi] > a[hi+1]) {
                // go down to the base
                while (hi+1<a.length && a[hi] > a[hi+1]) {
                    hi++;
                }
                // accumulate height
                ans = Math.max(ans, hi-lo+1);
            }
        }
        // move start to the latest end
        lo = Math.max(lo+1, hi);
    }

    return ans;
}

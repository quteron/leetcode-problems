public void merge(int[] a, int m, int[] b, int n) {
    int i = m-1;
    int j = n-1;

    int cur = m+n-1;
    while (i >=0 && j >= 0) {
        if (a[i] >= b[j]) {
            a[cur--] = a[i--];
        } else {
            a[cur--] = b[j--];
        }
    }

    while (j >= 0) {
        a[cur--] = b[j--];
    }
}

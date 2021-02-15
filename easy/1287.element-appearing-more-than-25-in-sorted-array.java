public int findSpecialInteger(int[] a) {
    int candidate = a[0];
    int n=a.length, count=1;

    for (int i=1; i<a.length; i++) {
        if (a[i] == candidate) {
            count++;
            if (n/count < 4) {
                break;
            }
        } else {
            count = 1;
            candidate = a[i];
        }
    }

    return candidate;
}

public boolean arrayStringsAreEqual(String[] a, String[] b) {
    int l=0, i=0, r=0, j=0;

    while (l<a.length && r<b.length) {
        if (i == a[l].length()) {
            l++;
            i=0;
        }

        if (j == b[r].length()) {
            r++;
            j=0;
        }

        if (l<a.length && r<b.length && a[l].charAt(i++) != b[r].charAt(j++)) {
            return false;
        }
    }

    return l == a.length && r == b.length;
}

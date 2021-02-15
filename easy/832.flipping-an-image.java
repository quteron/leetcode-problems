class Solution {
    public int[][] flipAndInvertImage(int[][] a) {
        for (int[] row : a) {
            reverseAndInvert(row);
        }

        return a;
    }

    private void reverseAndInvert(int[] a) {
        int l=0, r=a.length-1;
        while (l<r) {
            int temp = invert(a, l);
            a[l++] = invert(a, r);
            a[r--] = temp;
        }

        if (l == r) {
            a[l] = invert(a, l);
        }
    }

    private int invert(int[] a, int i) {
        return a[i] ^ 1;
    }
}

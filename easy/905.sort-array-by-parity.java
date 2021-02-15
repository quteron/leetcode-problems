class Solution {
    public int[] sortArrayByParity(int[] a) {
        int i=0, j=a.length-1;
        while(i<j) {
            if (a[i] % 2 == 0) {
                i++;
            } else if (a[j] % 2 == 1) {
                j--;
            } else {
                swap(a, i, j);
            }
        }

        return a;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

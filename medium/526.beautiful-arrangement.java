class Solution {
    public int countArrangement(int n) {
        int[] perm = new int[n];
        for (int i=0; i<n; i++) {
            perm[i] = i+1;
        }

        return countArrangement(perm, 0);
    }

    public int countArrangement(int[] perm, int pos) {
        if (pos == perm.length) {
            return 1;
        }

        int count = 0;
        for (int i=pos; i<perm.length; i++) {
            if (!isBeautiful(pos, perm[i])) {
                continue;
            }

            swap(perm, i, pos);
            count += countArrangement(perm, pos+1);
            swap(perm, pos, i);
        }

        return count;
    }

    private boolean isBeautiful(int index, int number) {
        return number % (index+1) == 0 || (index+1) % number == 0;
    }

    private void swap(int[] perm, int i, int j) {
        int temp = perm[i];
        perm[i] = perm[j];
        perm[j] = temp;
    }
}

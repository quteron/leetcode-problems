public int[] intersect(int[] a, int[] b) {
    List<Integer> duplicates = new ArrayList<Integer>();
    Arrays.sort(a);
    Arrays.sort(b);

    int i = 0, j = 0;
    while (i < a.length && j < b.length) {
        if (a[i] < b[j]) {
            i++;
        } else if (a[i] > b[j]) {
            j++;
        } else {
            int val = a[i];

            int cA = 0;
            while (i < a.length && a[i] == val) {
                i++;
                cA++;
            }

            int cB = 0;
            while (j < b.length && b[j] == val) {
                j++;
                cB++;
            }

            int count = Math.min(cA, cB);
            while (count != 0) {
                duplicates.add(val);
                count--;
            }
        }
    }

    int[] output = new int[duplicates.size()];
    for (int k=0; k<duplicates.size(); k++) {
        output[k] = duplicates.get(k);
    }

    return output;
}

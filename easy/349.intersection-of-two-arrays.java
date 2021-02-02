public int[] intersection(int[] a, int[] b) {
    List<Integer> unique = new ArrayList<Integer>();

    Arrays.sort(a);
    Arrays.sort(b);

    int iA = 0, iB = 0;
    while (iA < a.length && iB < b.length) {
        if (a[iA] < b[iB]) {
            iA++;
        } else if (a[iA] > b[iB]) {
            iB++;
        } else {
            int val = a[iA];
            unique.add(val);

            while (iA < a.length && a[iA] == val) {
                iA++;
            }

            while (iB < b.length && b[iB] == val) {
                iB++;
            }
        }
    }

    int[] output = new int[unique.size()];
    for (int i=0; i<unique.size(); i++) {
        output[i] = unique.get(i);
    }

    return output;
}

public List<Integer> arraysIntersection(int[] a, int[] b, int[] c) {
    List<Integer> output = new ArrayList<>();

    int i = 0, j = 0, k = 0;
    while (i < a.length && j < b.length && k < c.length) {
        if (a[i] == b[j] && a[i] == c[k]) {
            output.add(a[i]);
            i++;
            j++;
            k++;
        } else if (a[i] < b[j]) {
            i++;
        } else if (b[j] < c[k]) {
            j++;
        } else {
            k++;
        }
    }

    return output;
}

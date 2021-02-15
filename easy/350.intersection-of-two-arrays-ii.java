public int[] intersect(int[] a, int[] b) {
    LinkedList<Integer> ans = new LinkedList();

    Arrays.sort(a);
    Arrays.sort(b);

    int i=0, j=0;
    while (i<a.length && j<b.length) {
        if (a[i] == b[j]) {
            ans.add(a[i]);
            i++; j++;
        } else if (a[i] < b[j]) {
            i++;
        } else {
            j++;
        }
    }

    return ans.stream().mapToInt(k->k).toArray();
}

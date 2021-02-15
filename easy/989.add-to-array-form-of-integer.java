public List<Integer> addToArrayForm(int[] a, int k) {
    List<Integer> ans = new ArrayList();

    int i=a.length-1;
    while (i>=0 || k > 0) {
        k += (i>=0) ? a[i--] : 0;
        ans.add(k % 10);
        k /= 10;
    }

    Collections.reverse(ans);
    return ans;
}

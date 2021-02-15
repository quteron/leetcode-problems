class Solution {
    public int[] intersection(int[] a, int[] b) {
       LinkedList<Integer> common = new LinkedList();

        Arrays.sort(a);
        Arrays.sort(b);

        int iA=0, iB=0;

        while (iA<a.length && iB<b.length) {
            if (a[iA] > b[iB]) {
                iB++;
            } else if (a[iA] < b[iB]) {
                iA++;
            } else if (common.isEmpty() || common.peekLast() != a[iA]) {
                common.add(a[iA++]);
            } else {
                iA++;
                iB++;
            }
        }

        return common.stream().mapToInt(i -> i).toArray();
    }
}

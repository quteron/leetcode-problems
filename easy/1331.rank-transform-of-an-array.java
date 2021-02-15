public int[] arrayRankTransform(int[] a) {
    TreeMap<Integer, List<Integer>> map = new TreeMap();

    for(int i=0; i<a.length; i++) {
        map.putIfAbsent(a[i], new ArrayList());
        map.get(a[i]).add(i);
    }

    int[] ans = new int[a.length];
    int rank = 1;
    for (int num : map.keySet()) {
        for (int index : map.get(num)) {
            ans[index] = rank;
        }
        rank++;
    }

    return ans;
}

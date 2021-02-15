public int maxWidthRamp(int[] A) {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    int dist = 0;
    for(int i=0; i<A.length; i++) {
        if (map.floorKey(A[i]) == null) {
            map.put(A[i], i);
        } else {
            int j = map.get(map.floorKey(A[i]));
            dist = Math.max(dist, i - j);
        }
    }

    return dist;
}

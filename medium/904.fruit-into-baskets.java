public int totalFruit(int[] tree) {
    Map<Integer, Integer> map = new LinkedHashMap();

    int l=0, ans=0;
    for (int r=0; r<tree.length; r++) {
        if (map.containsKey(tree[r])) {
            map.remove(tree[r]);
        }
        map.put(tree[r], r);

        if (map.size() > 2) {
            Map.Entry<Integer, Integer> leftmost = map.entrySet().iterator().next();
            map.remove(leftmost.getKey());
            l = leftmost.getValue()+1;
        }

        ans = Math.max(ans, r-l+1);
    }

    return ans;
}

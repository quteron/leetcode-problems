class SnapshotArray {

    private int snapId;

    private Map<Integer,Integer> current;
    private List<Map<Integer, Integer>> snapshots;


    public SnapshotArray(int length) {
        this.snapId = 0;

        this.current = new HashMap();
        this.snapshots = new ArrayList<>();
    }

    public void set(int index, int val) {
        current.put(index, val);
    }

    public int snap() {
        snapshots.add(new HashMap(current));
        snapId++;

        return snapId-1;
    }

    public int get(int index, int snapId) {
        Map<Integer, Integer> snapshot = snapshots.get(snapId);
        return snapshot.getOrDefault(index, 0);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

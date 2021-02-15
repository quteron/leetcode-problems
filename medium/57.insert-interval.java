class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ans = new LinkedList<>();

        int i=0;
        // skip that less new interval
        while (i < intervals.length && intervals[i][0] < newInterval[0]) {
            ans.add(intervals[i++]);
        }

        // add new interval
        merge(ans, newInterval);

        // merge remained intervals
        while (i < intervals.length) {
            merge(ans, intervals[i++]);
        }

        return ans.toArray(new int[ans.size()][]);
    }

    private void merge(LinkedList<int[]> ans, int[] next) {
        if (ans.isEmpty() || ans.getLast()[1] < next[0]) {
            ans.add(next);
        } else {
            ans.getLast()[1] = Math.max(ans.getLast()[1], next[1]);
        }
    }
}

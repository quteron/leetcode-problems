class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList();

        List<Integer> current = new ArrayList();
        current.add(0);

        allPathsSourceTarget(graph, 0, graph.length-1, current, ans);
        return ans;
    }

    private void allPathsSourceTarget(int[][] graph, int source, int target, List<Integer> current, List<List<Integer>> ans) {
        if (source == target) {
            ans.add(new ArrayList(current));
            return;
        }

        for (int node : graph[source]) {
            current.add(node);
            allPathsSourceTarget(graph, node, target, current, ans);
            current.remove(current.size()-1);
        }
    }
}

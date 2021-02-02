public List<List<Integer>> verticalOrder(TreeNode root) {
    Map<Integer, List<Integer>> map = new TreeMap<>();
    int min = 0, max = -1;

    Deque<Pair<Integer, TreeNode>> queue = new ArrayDeque<>();
    queue.addLast(new Pair(0, root));

    while (!queue.isEmpty()) {
        Pair<Integer, TreeNode> pair = queue.removeFirst();
        if (pair.getValue() != null) {
            int level = pair.getKey();
            TreeNode node = pair.getValue();

            List<Integer> nodes = map.getOrDefault(level, new ArrayList<>());
            nodes.add(node.val);
            map.put(level, nodes);

            min = Math.min(min, level);
            max = Math.max(max, level);

            queue.addLast(new Pair(level-1, node.left));
            queue.addLast(new Pair(level+1, node.right));
        }
    }

    List<List<Integer>> output = new ArrayList<>();
    for (int i=min; i<=max; i++) {
        output.add(map.get(i));
    }

    return output;
}

public List<Double> averageOfLevels(TreeNode root) {
    List<Double> output = new ArrayList<>();
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.addLast(root);

    while (!queue.isEmpty()) {
        int child = queue.size();
        double sum = 0.0;
        int i = 0;

        while (i != child) {
            TreeNode node = queue.removeFirst();
            sum += node.val;
            i++;

            if (node.left != null) {
                queue.addLast(node.left);
            }

            if (node.right != null) {
                queue.addLast(node.right);
            }
        }

        output.add(sum / child);
    }

    return output;
}

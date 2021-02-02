public List<Integer> rightSideView(TreeNode root) {
    List<Integer> output = new ArrayList<>();
    traverse(root, 0, output);
    return output;
}

private void traverse(TreeNode root, int level, List<Integer> output) {
    if (root == null) {
        return;
    }

    if (level == output.size()) {
        output.add(root.val);
    }

    traverse(root.right, level+1, output);
    traverse(root.left, level+1, output);
}

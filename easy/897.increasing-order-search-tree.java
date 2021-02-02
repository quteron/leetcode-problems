public TreeNode increasingBST(TreeNode root) {
    TreeNode dummy = new TreeNode();
    inorderTraversal(root, dummy);
    return dummy.right;
}

private TreeNode inorderTraversal(TreeNode root, TreeNode prev) {
    if (root == null) {
        return prev;
    }

    prev = inorderTraversal(root.left, prev);

    prev.right = root;
    prev = prev.right;
    prev.left = null;

    return inorderTraversal(root.right, prev);
}

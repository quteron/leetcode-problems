private int ans = Integer.MAX_VALUE;

public int minDiffInBST(TreeNode root) {
    inorderTraversal(root, null);
    return ans;
}

private TreeNode inorderTraversal(TreeNode root, TreeNode prev) {
    if (root == null) {
        return prev;
    }

    prev = inorderTraversal(root.left, prev);
    if (prev != null) {
        ans = Math.min(ans, root.val - prev.val);
    }

    return inorderTraversal(root.right, root);
}

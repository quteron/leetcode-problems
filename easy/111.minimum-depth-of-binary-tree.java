public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }

    if (root.left == null) {
        return 1 + minDepth(root.right);
    } else if (root.right == null) {
        return 1 + minDepth(root.left);
    } else {
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return 1 + Math.min(left, right);
    }
}

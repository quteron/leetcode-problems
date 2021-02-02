public boolean isBalanced(TreeNode root) {
    return isBalancedCheck(root) != -1;
}

private int isBalancedCheck(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int left = isBalancedCheck(root.left);
    int right = isBalancedCheck(root.right);

    if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
        return -1;
    }

    return 1 + Math.max(left, right);
}

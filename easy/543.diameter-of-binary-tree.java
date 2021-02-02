private int diameter = 0;

public int diameterOfBinaryTree(TreeNode root) {
    calculateHeight(root);
    return diameter;
}

private int calculateHeight(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int left = calculateHeight(root.left);
    int right = calculateHeight(root.right);
    diameter = Math.max(diameter, left + right);

    return Math.max(left, right) + 1;
}

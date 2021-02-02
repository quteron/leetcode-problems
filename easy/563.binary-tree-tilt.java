private int totalTilt = 0;

public int findTilt(TreeNode root) {
    findSum(root);
    return totalTilt;
}

private int findSum(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int leftsum = findSum(root.left);
    int rightSum = findSum(root.right);
    totalTilt += Math.abs(leftsum-rightSum);

    return root.val + leftsum + rightSum;
}

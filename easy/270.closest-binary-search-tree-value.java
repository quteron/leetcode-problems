public int closestValue(TreeNode root, double target) {
    int closest = root.val;
    double difference = Math.abs(closest - target);

    while (root != null) {
        double curDiff = Math.abs(root.val - target);
        if (curDiff < difference) {
            closest = root.val;
            difference = Math.abs(root.val - target);
        }

        if (target > root.val) {
            root = root.right;
        } else {
            root = root.left;
        }
    }
    return closest;
}

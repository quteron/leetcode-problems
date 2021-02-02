public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
}

private boolean isValidBST(TreeNode root, Integer low, Integer high) {
    if (root == null) {
        return true;
    }

    if (low != null && root.val <= low) {
        return false;
    }

    if (high != null && root.val >= high) {
        return false;
    }

    return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
}

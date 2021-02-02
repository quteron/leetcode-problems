public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
        if (root.val > q.val && root.val > p.val) {
            root = root.left;
        } else if (root.val < q.val && root.val < p.val) {
            root = root.right;
        } else {
            return root;
        }
    }

    return null;
}

class BSTIterator {
    Deque<TreeNode> stack = new ArrayDeque<>();

    BSTIterator(TreeNode root) {
        moveToLeftMost(root);
    }

    int next() {
        TreeNode current = stack.pop();
        moveToLeftMost(current.right);
        return current.val;
    }

    boolean hasNext() {
        return !stack.isEmpty();
    }

    private void moveToLeftMost(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

public boolean isSubPath(ListNode head, TreeNode root) {
    if (head == null) {
        return true;
    }

    if (root == null) {
        return false;
    }

    if (head.val == root.val && match(head, root)) {
        return true;
    }

    return isSubPath(head, root.left) || isSubPath(head, root.right);
}

private boolean match(ListNode head, TreeNode root) {
    if (head == null) {
        return true;
    }

    if (root == null) {
        return false;
    }

    if (head.val != root.val) {
        return false;
    }

    return match(head.next, root.left) || match(head.next, root.right);
}

public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    if (original == null) {
        return null;
    }

    if (original == target) {
        return cloned;
    }

    TreeNode output = getTargetCopy(original.left, cloned.left, target);
    if (output != null) {
        return output;
    }

    return getTargetCopy(original.right, cloned.right, target);
}

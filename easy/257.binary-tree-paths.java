public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<String>();
    if (root != null) {
        binaryTreePaths(root, "" + root.val, paths);
    }
    return paths;
}

private void binaryTreePaths(TreeNode root, String path, List<String> paths) {
    if (root.left == null && root.right == null) {
        paths.add(path);
    }

    if (root.left != null) {
        binaryTreePaths(root.left, path + "->" + root.left.val, paths);
    }

    if (root.right != null) {
        binaryTreePaths(root.right, path + "->" + root.right.val, paths);
    }
}

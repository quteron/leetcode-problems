public Node treeToDoublyList(Node root) {
    if (root == null) {
        return null;
    }

    Node output = new Node(0);
    Node lastNode = treeToDoublyList(root, output);

    lastNode.right = output.right;
    output.right.left = lastNode;

    return output.right;
}

public Node treeToDoublyList(Node root, Node output) {
    if (root == null) {
        return output;
    }

    // left child
    output = treeToDoublyList(root.left, output);
    // root
    output.right = root;
    output.right.left = output;
    output = output.right;
    // right child
    return treeToDoublyList(root.right, output);
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int post_index;
    private int[] postorder;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.post_index = postorder.length-1;
        this.postorder = postorder;

        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(0, inorder.length);
    }

    private TreeNode buildTree(int l, int r) {
        if (l == r) {
            return null;
        }

        int value = postorder[post_index--];
        TreeNode root = new TreeNode(value);

        int in_index = map.get(value);
        root.right = buildTree(in_index+1, r);
        root.left = buildTree(l, in_index);

        return root;
    }
}

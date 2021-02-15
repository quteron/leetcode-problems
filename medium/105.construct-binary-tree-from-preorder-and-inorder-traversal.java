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

    private int pre_index = 0;
    private int[] pre;
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre_index = 0;
        pre = preorder;

        map = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(0, inorder.length);
    }

    private TreeNode buildTree(int l, int r) {
        if (l == r) {
            return null;
        }

        int value = pre[pre_index++];
        TreeNode node = new TreeNode(value);

        int in_index = map.get(value);
        node.left = buildTree(l, in_index);
        node.right = buildTree(in_index+1, r);

        return node;
    }
}

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

    private int index = 0;

    public TreeNode str2tree(String s) {
        return construct(s);
    }

    private TreeNode construct(String s) {
        if (index == s.length()) {
            return null;
        }

        StringBuilder number = new StringBuilder();
        while (index < s.length() && s.charAt(index) != '(' && s.charAt(index) != ')') {
            number.append(s.charAt(index++));
        }

        int val = Integer.valueOf(number.toString());
        TreeNode node = new TreeNode(val);

        if (index == s.length()) {
            return node;
        } else if (s.charAt(index) == '(') {
            index++;
            node.left = construct(s);

            if (index < s.length() && s.charAt(index) == '(') {
                index++;
                node.right = construct(s);
            }
        }

        index++;
        return node;
    }
}

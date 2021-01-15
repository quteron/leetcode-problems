// recursion
class Solution {

    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        current = head;
        int size = getSize(head);
        return sortedListToBST(0, size-1);
    }

    private TreeNode sortedListToBST(int l, int r) {
        if (l > r) {
            return null;
        }

        int m = l + (r-l)/2;

        TreeNode left = sortedListToBST(l, m-1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;

        root.left = left;
        root.right = sortedListToBST(m+1, r);
        return root;
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
// iteration

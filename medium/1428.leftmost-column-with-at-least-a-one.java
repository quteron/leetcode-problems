/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> sizes = binaryMatrix.dimensions();

        int row=0;
        int col = sizes.get(1)-1;
        int ans = -1;

        while (row <= sizes.get(0)-1 && col >= 0) {
            if (binaryMatrix.get(row, col) == 1) {
                ans = col;
                col--;
            } else {
                row++;
            }
        }

        return ans;
    }
}

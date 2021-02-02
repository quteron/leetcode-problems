class Solution {
    class Triplet {
        int value;
        int row;
        int column;

        Triplet(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Triplet> minHeap = new PriorityQueue<>((a, b) -> a.value-b.value);

        for (int i=0; i<Math.min(matrix.length,k); i++) {
            minHeap.add(new Triplet(matrix[i][0], i, 0));
        }

        while (k != 1) {
            Triplet current = minHeap.poll();
            if (current.column + 1 != matrix.length) {
                Triplet next = new Triplet(matrix[current.row][current.column+1], current.row, current.column+1);
                minHeap.add(next);
            }
            k--;
        }

        return minHeap.poll().value;
    }
}

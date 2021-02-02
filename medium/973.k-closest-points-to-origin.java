class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> compare(a, b));
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        int i = 0;
        int[][] output = new int[maxHeap.size()][];
        while (!maxHeap.isEmpty()) {
            output[i++] = maxHeap.poll();
        }

        return output;
    }

    private int compare(int[] a, int[] b) {
        int dA = a[0]*a[0] + a[1]*a[1];
        int dB = b[0]*b[0] + b[1]*b[1];

        return dB - dA;
    }
 }

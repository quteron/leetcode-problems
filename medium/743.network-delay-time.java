class Solution {

    class Node {
        int id;
        int time;

        Node(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] matrix = new int[n+1][n+1];
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<n+1; j++) {
                matrix[i][j] = -1;
            }
        }

        for (int[] travel : times) {
            matrix[travel[0]][travel[1]] = travel[2];
        }

        Map<Integer, Integer> visited = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.time-b.time);
        minHeap.add(new Node(k, 0));

        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            if (visited.containsKey(current.id)) {
                continue;
            }

            visited.put(current.id, current.time);

            for(int i=1; i<n+1; i++) {
                int time = matrix[current.id][i];
                if (time >= 0 && !visited.containsKey(i)) {
                    Node next = new Node(i, current.time+time);
                    minHeap.add(next);
                }
            }
        }

        int total = 0;
        for (int value : visited.values()) {
            total = Math.max(total, value);
        }

        return visited.size() == n ? total : -1;
    }
}

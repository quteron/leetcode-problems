class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int code : barcodes) {
            int count = map.getOrDefault(code, 0);
            map.put(code, count+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int code : map.keySet()) {
            maxHeap.add(code);
        }

        int i=0;
        int[] output = new int[barcodes.length];
        while (maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();

            output[i++] = a;
            output[i++] = b;

            int countA = map.get(a);
            if (countA > 1) {
                map.put(a, countA-1);
                maxHeap.add(a);
            }

            int countB = map.get(b);
            if (countB > 1) {
                map.put(b, countB-1);
                maxHeap.add(b);
            }
        }

        if (!maxHeap.isEmpty()) {
            output[i] = maxHeap.poll();
        }

        return output;
    }
}

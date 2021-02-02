class Solution {

    private Map<Integer, Integer> map = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        for (int num : nums) {
            int freq = map.getOrDefault(num, k);
            map.put(num, ++freq);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>( (a, b) -> compare(a, b));
        for (int key : map.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int i=0;
        int[] output = new int[minHeap.size()];
        while (!minHeap.isEmpty()) {
            output[i++] = minHeap.poll();
        }

        return output;
    }

    private int compare(int a, int b) {
        return map.get(a) - map.get(b);
    }
}

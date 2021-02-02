class Solution {
    private HashMap<String, Integer> map = new HashMap<>();

    public List<String> topKFrequent(String[] words, int k) {
        for (String word : words) {
            int freq = map.getOrDefault(word, 0);
            map.put(word, ++freq);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> compare(a, b));
        for (String word : map.keySet()) {
            minHeap.add(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> output = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            output.add(minHeap.poll());
        }

        Collections.reverse(output);
        return output;
    }

    private int compare(String a, String b) {
        int diff = map.get(a) - map.get(b);
        return diff == 0 ? b.compareTo(a) : diff;
    }
}

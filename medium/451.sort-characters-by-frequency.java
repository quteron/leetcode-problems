class Solution {
    public String frequencySort(String s) {
        for (char ch : s.toCharArray()) {
            int freq = map.getOrDefault(ch, 0);
            map.put(ch, ++freq);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>( (a,b) -> compare(a, b));
        for (char ch : s.toCharArray()) {
            maxHeap.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            sb.append(maxHeap.poll());
        }

        return sb.toString();
     }

    private int compare(char a, char b) {
        int freq = map.get(b) - map.get(a);
        return freq == 0? a-b : freq;
    }
}

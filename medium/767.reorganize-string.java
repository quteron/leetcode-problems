class Solution {
    private Map<Character, Integer> map = new HashMap<>();

    public String reorganizeString(String S) {
        for (char letter : S.toCharArray()) {
            int freq = map.getOrDefault(letter, 0);
            map.put(letter, ++freq);
        }

        int maxFreq = 0;
        for (int value : map.values()) {
            maxFreq = Math.max(maxFreq, value);
        }

        if (maxFreq - 1 > S.length() - maxFreq) {
            return "";
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> compare(a, b));
        for (Character letter : map.keySet()) {
            maxHeap.add(letter);
        }

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 1) {
            Character letter1 = maxHeap.poll();
            sb.append(letter1);

            Character letter2 = maxHeap.poll();
            sb.append(letter2);

            int freq1 = map.get(letter1);
            if (--freq1 > 0) {
                map.put(letter1, freq1);
                maxHeap.add(letter1);
            }

            int freq2 = map.get(letter2);
            if (--freq2 > 0) {
                map.put(letter2, freq2);
                maxHeap.add(letter2);
            }
        }

        if (!maxHeap.isEmpty()) {
            sb.append(maxHeap.poll());
        }

        return sb.toString();
    }

    private int compare(Character a, Character b) {
        int diff = map.get(b) - map.get(a);
        return diff == 0 ? a - b : diff;
    }
}

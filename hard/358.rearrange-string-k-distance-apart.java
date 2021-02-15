class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0) {
            return s;
        }

        // fill in the map with counts
        Map<Character, Integer> map = new HashMap<>();
        for (char a: s.toCharArray()) {
            int count = map.getOrDefault(a, 0);
            map.put(a, count+1);
        }

        // put all characters to queue
        PriorityQueue<Character> queue = new PriorityQueue<>((a,b) -> compare(a, b, map));
        for (Character key : map.keySet()) {
            queue.offer(key);
        }

        StringBuilder sb = new StringBuilder();
        List<Character> wait = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (!queue.isEmpty() && wait.size() < k) {
                Character a = queue.poll();
                sb.append(a);
                wait.add(a);
            }

            if (wait.size() == k) {
                for (Character a : wait) {
                    int count = map.get(a);
                    if (count > 1) {
                        map.put(a, count-1);
                        queue.offer(a);
                    }
                }
                wait.clear();
            }
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }

    private int compare(Character a, Character b, Map<Character, Integer> map) {
        int diff = map.get(b)-map.get(a);
        return diff != 0 ? diff : a-b;
    }
}

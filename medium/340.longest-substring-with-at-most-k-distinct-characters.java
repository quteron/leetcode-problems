public int lengthOfLongestSubstringKDistinct(String s, int k) {
    // char -> position
    LinkedHashMap<Character, Integer> map = new LinkedHashMap();

    int max=0;
    int l=0, r=0;

    while (r < s.length()) {
        // if contains, remove to keep the insertion order
        if (map.containsKey(s.charAt(r))) {
            map.remove(s.charAt(r));
        }
        // will be the last in the insertion order
        map.put(s.charAt(r), r++);

        if (map.size() > k) {
            // find first in the insertion order
            Map.Entry<Character, Integer> leftmost = map.entrySet().iterator().next();
            // remove leftmost
            map.remove(leftmost.getKey());
            // sgift left position
            l = leftmost.getValue() + 1;
        }

        max = Math.max(max, r-l);
    }

    return max;
}

public int lengthOfLongestSubstringTwoDistinct(String s) {
    // char -> rightmost position
    Map<Character, Integer> map = new HashMap();

    int max = 0;
    int l=0, r=0;

    while (r<s.length()) {
        // expand
        map.put(s.charAt(r), r++);
        // shrink is exceeds 2 distinct chars
        if (map.size() > 2) {
            // find leftmost position
            int index = Collections.min(map.values());
            // remove this char
            map.remove(s.charAt(index));
            // sfit left position
            l = index+1;
        }

        max = Math.max(max, r-l);
    }

    return max;
}

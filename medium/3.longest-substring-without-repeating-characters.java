public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> unique = new HashMap<Character, Integer>();
    int max = 0;

    int i = 0;
    int j = 0;
    int n = s.length();

    while (i < n && j < n) {
        char ch = s.charAt(j);
        if (unique.containsKey(ch)) {
            i = Math.max(i, unique.get(ch)+1);
        }

        max = Math.max(max, j-i+1);
        unique.put(ch, j++);
    }

    return max;
}

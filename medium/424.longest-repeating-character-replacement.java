public int characterReplacement(String s, int k) {
    Map<Character, Integer> map = new HashMap();

    int maxFreq = 0;
    int l=0, ans=0;

    for (int r=0; r<s.length(); r++) {
        // expand window
        int count = map.getOrDefault(s.charAt(r), 0);
        map.put(s.charAt(r), ++count);
        // update max feq
        maxFreq = Math.max(maxFreq, count);

        if (r-l+1-maxFreq > k) {
            // shrink window
            count = map.get(s.charAt(l));
            map.put(s.charAt(l++), --count);
        }

        // recalculate max length
        ans = Math.max(ans, r-l+1);
    }

    return ans;
}

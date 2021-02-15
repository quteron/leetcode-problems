public int numKLenSubstrNoRepeats(String s, int k) {
    Map<Character, Integer> map = new HashMap();

    int ans=0, l=0;
    for (int r=0; r<s.length(); r++) {
        char letter = s.charAt(r);
        if (map.containsKey(letter)) {
            l = Math.max(l, map.get(letter)+1);
        }

        map.put(s.charAt(r), r);
        if (r-l+1 == k) {
            l++;
            ans++;
        }
    }

    return ans;
}

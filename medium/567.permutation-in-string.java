public boolean checkInclusion(String a, String b) {
    Map<Character, Integer> map = new HashMap();
    for (char ch : a.toCharArray()) {
        int count = map.getOrDefault(ch, 0);
        map.put(ch, ++count);
    }

    int l=0, r=0, k=a.length();
    while (r < b.length()) {
        if (map.containsKey(b.charAt(r))) {
            if (map.get(b.charAt(r)) > 0) {
                // expand
                int count = map.get(b.charAt(r));
                map.put(b.charAt(r), --count);
                r++;
                k--;
            } else {
                // shrink
                int count = map.get(b.charAt(l));
                map.put(b.charAt(l), ++count);
                l++;
                k++;
            }
        } else {
            while (l < r) {
                // shrink
                int count = map.get(b.charAt(l));
                map.put(b.charAt(l),++count);
                l++;
                k++;
            }
            r++;
            l=r;
        }

        if (k == 0) {
            return true;
        }
    }

    return false;
}

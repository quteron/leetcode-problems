public boolean buddyStrings(String a, String b) {
    if (a.length() != b.length()) {
        return false;
    }

    if (a.equals(b)) {
        int maxFreq = 0;
        int[] count = new int[26];

        for (char ch : a.toCharArray()) {
            count[ch - 'a']++;
            maxFreq = Math.max(maxFreq, count[ch - 'a']);
        }

        return maxFreq > 1;
    }

    int first = -1, second = -1;
    for (int i=0; i<a.length(); i++) {
        if (a.charAt(i) != b.charAt(i)) {
            if (first == -1) {
                first = i;
            } else if (second == -1) {
                second = i;
            } else {
                return false;
            }
        }
    }

    return second != -1 && a.charAt(first) == b.charAt(second) && a.charAt(second) == b.charAt(first);
}

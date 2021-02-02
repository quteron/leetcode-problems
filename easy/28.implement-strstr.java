public int strStr(String haystack, String needle) {
    if (needle.isEmpty()) {
        return 0;
    }

    int i = 0, j = 0;
    while (i < haystack.length() && j < needle.length()) {
        if (haystack.charAt(i) == needle.charAt(j)) {
            i++; j++;
        } else {
            i += 1-j;
            j = 0;
        }
    }

    return j == needle.length() ? i-j : -1;
}

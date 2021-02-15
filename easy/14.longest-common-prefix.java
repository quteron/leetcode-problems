public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
        return "";
    }

    String prefix = strs[0];
    int l=0, r=prefix.length();

    for (int i=1; i<strs.length; i++) {
        String s = strs[i];
        int j=0;

        while (j<s.length() && j<prefix.length() && s.charAt(j) == prefix.charAt(j)) {
            j++;
        }

        r = Math.min(r, j);
    }

    return prefix.substring(l, r);
}

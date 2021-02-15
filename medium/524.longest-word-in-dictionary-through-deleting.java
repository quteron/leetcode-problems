class Solution {
    public String findLongestWord(String s, List<String> d) {
        String max = "";

        for (String word : d) {
            if (isSubsequence(s, word)) {
                max = longest(max, word);
            }
        }

        return max;
    }

    private boolean isSubsequence(String s, String t) {
        int i=0;
        for (int j=0; j<s.length() && i < t.length(); j++) {
            if (s.charAt(j) == t.charAt(i)) {
                i++;
            }
        }
        return i == t.length();
    }

    private String longest(String s, String t) {
        if (s.length() > t.length()) {
            return s;
        } else if (s.length() < t.length()) {
            return t;
        } else {
            return s.compareTo(t) < 0 ? s : t;
        }
    }
}

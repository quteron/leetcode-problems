class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] mask = new boolean[s.length()];

        for (int i=0; i<s.length(); i++) {
            for (String word : dict) {
                matchWord(s, i, word, mask);
            }
        }

        StringBuilder ans = new StringBuilder();
        boolean opened = false;
        for (int i=0; i<s.length(); i++) {
            if (mask[i]) {
                if (!opened) {
                    opened = true;
                    ans.append("<b>");
                }
            } else if (opened) {
                opened = false;
                ans.append("</b>");
            }

            ans.append(s.charAt(i));
        }

        if (opened) {
            ans.append("</b>");
        }

        return ans.toString();
    }

    private void matchWord(String s, int i, String word, boolean[] mask) {
        for (int j=0; j<word.length(); j++) {
            if (i+j >= s.length() || word.charAt(j) != s.charAt(i+j)) {
                return;
            }
        }

        for (int j=0; j<word.length(); j++) {
            mask[i+j] = true;
        }
    }
}

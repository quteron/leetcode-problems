class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList();
        generateAbbreviations(word, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    private void generateAbbreviations(String word, int pos, int count, StringBuilder abbr, List<String> ans) {
        int initLen = abbr.length();

        if (pos == word.length()) {
            if (count > 0) {
                abbr.append(count);
            }
            ans.add(abbr.toString());
        } else {
            // abbreviate
            generateAbbreviations(word, pos+1, count+1, abbr, ans);
            // not abbreviate
            if (count > 0) {
                abbr.append(count);
            }
            abbr.append(word.charAt(pos));
            generateAbbreviations(word, pos+1, 0, abbr, ans);
        }

        abbr.setLength(initLen);
    }
}

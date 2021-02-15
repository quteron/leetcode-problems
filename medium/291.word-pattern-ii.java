class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        return wordPatternMatch(pattern, 0, s, 0, new HashMap<>(), new HashSet());
    }

    private boolean wordPatternMatch(String pattern, int i, String s, int j, Map<Character, String> map, Set<String> words) {
        if (i == pattern.length()) {
            return j == s.length();
        }

        char key = pattern.charAt(i);
        if (!map.containsKey(key)) {
            for (int k=j; k<s.length(); k++) {
                String word = s.substring(j, k+1);
                if (words.contains(word)) {
                    continue;
                }

                map.put(key, word);
                words.add(word);

                if (wordPatternMatch(pattern, i+1, s, k+1, map, words)) {
                    return true;
                }

                map.remove(key);
                words.remove(word);
            }

            return false;
        }

        String word = map.get(key);
        if (word.length() > s.length()-j) {
            return false;
        }

        String actual = s.substring(j, j+word.length());
        if (!word.equals(actual)) {
            return false;
        }

        return wordPatternMatch(pattern, i+1, s, j+word.length(), map, words);
    }
}

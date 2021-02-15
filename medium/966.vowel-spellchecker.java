class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet();
        Map<String, String> wordsLow = new HashMap();
        Map<String, String> wordsDV = new HashMap();

        for (String word : wordlist) {
            words.add(word);

            String lower = word.toLowerCase();
            wordsLow.putIfAbsent(lower, word);

            String devoweled = devowel(lower);
            wordsDV.putIfAbsent(devoweled, word);
        }

        String[] ans = new String[queries.length];
        for (int i=0; i<queries.length; i++) {
            String query = queries[i];

            if (words.contains(query)) {
                ans[i] = query;
                continue;
            }

            String lower = query.toLowerCase();
            if (wordsLow.containsKey(lower)) {
                ans[i] = wordsLow.get(lower);
                continue;
            }

            String devoweled = devowel(lower);
            if (wordsDV.containsKey(devoweled)) {
                ans[i] = wordsDV.get(devoweled);
                continue;
            }

            ans[i] = "";
        }

        return ans;
    }

    private Set<Character> vowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    private String devowel(String word) {
        StringBuilder ans = new StringBuilder();
        for (char c : word.toCharArray()) {
            ans.append(vowels.contains(c) ? '*' : c);
        }
        return ans.toString();
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String s : strs) {
            String code = getCode(s);
            map.putIfAbsent(code, new ArrayList());
            map.get(code).add(s);
        }

        List<List<String>> ans = new ArrayList();
        for (String code : map.keySet()) {
            ans.add(map.get(code));
        }

        return ans;
    }

    private String getCode(String s) {
        char[] counts = new char[26];
        for (char letter : s.toCharArray()) {
            counts[letter - 'a']++;
        }

        StringBuilder code = new StringBuilder();
        for (int i=0; i<26; i++) {
            code.append('#').append(counts[i]);
        }

        return code.toString();
    }
}

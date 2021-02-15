class Solution {
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> permutations = new ArrayList();
        permutations.add(new StringBuilder());

        for (char ch : s.toCharArray()) {
            int n = permutations.size();

            if (Character.isDigit(ch)) {
                for (StringBuilder sb : permutations) {
                    sb.append(ch);
                }
            } else {
                for (int i=0; i<n; i++) {
                    permutations.add(new StringBuilder(permutations.get(i)));
                    permutations.get(i).append(ch);

                    char inverted = Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
                    permutations.get(i+n).append(inverted);
                }
            }
        }

        List<String> ans = new ArrayList();
        for (StringBuilder sb : permutations) {
            ans.add(sb.toString());
        }

        return ans;
    }
}

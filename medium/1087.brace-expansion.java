class Solution {
    public String[] expand(String s) {
        List<String> items = new ArrayList();
        expand(s, 0, new StringBuilder(), items);

        String [] ans = new String[items.size()];
        for (int i=0; i<items.size(); i++) {
            ans[i] = items.get(i);
        }
        return ans;
    }

    private void expand(String s, int pos, StringBuilder current, List<String> ans) {
        if (pos == s.length()) {
            ans.add(current.toString());
            return;
        }

        if (s.charAt(pos) != '{') {
            current.append(s.charAt(pos));
            expand(s, pos+1, current, ans);
            current.deleteCharAt(current.length()-1);
            return;
        }

        int end = ++pos;
        while (s.charAt(end) != '}') {
            end++;
        }

        String[] group = s.substring(pos, end).split(",");
        Arrays.sort(group);

        for (String letter : group) {
            current.append(letter);
            expand(s, end+1, current, ans);
            current.deleteCharAt(current.length()-1);
        }
    }
}

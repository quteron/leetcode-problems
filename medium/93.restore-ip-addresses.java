class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() <= 15) {
            restoreIpAddresses(s, 0, new LinkedList<>(), ans);
        }
        return ans;
    }

    private void restoreIpAddresses(String s, int pos, LinkedList<String> segments, List<String> ans) {
        if (pos == s.length()) {
            if (segments.size() == 4) {
                ans.add(String.join(".", segments));
            }
            return;
        }

        int len = Math.min(s.length(), pos+3);
        for (int i=pos; i<len; i++) {
            String group = s.substring(pos, i+1);
            if (isValidGroup(group)) {
                segments.add(group);
                restoreIpAddresses(s, i+1, segments, ans);
                segments.removeLast();
            }
        }
    }

    private boolean isValidGroup(String group) {
        int len = group.length();
        return len <= 3 && group.charAt(0) != '0' ? Integer.parseInt(group) <= 255 : len == 1;
    }
}

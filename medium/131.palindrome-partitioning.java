class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        partition(s, 0, new ArrayList(), ans);
        return ans;
    }

    private void partition(String s, int pos, List<String> current, List<List<String>> ans) {
        if (pos == s.length()) {
            ans.add(new ArrayList(current));
            return;
        }

        for (int i=pos; i<s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                String palindrome = s.substring(pos, i+1);
                current.add(palindrome);
                partition(s, i+1, current, ans);
                current.remove(current.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i<j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}

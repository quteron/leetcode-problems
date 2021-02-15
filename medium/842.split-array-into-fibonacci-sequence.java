class Solution {
    public List<Integer> splitIntoFibonacci(String s) {
        List<Integer> ans = new ArrayList();
        if (backtracking(s, 0, ans)) {
            return ans;
        }
        return new ArrayList();
    }

    private boolean backtracking(String s, int pos, List<Integer> ans) {
        if (pos == s.length()) {
            return true;
        }

        for (int i=pos; i<s.length(); i++) {
            if (i>pos && s.charAt(pos) == '0') {
                break;
            }

            long number = Long.parseLong(s.substring(pos, i+1));
            if (number > Integer.MAX_VALUE) {
                break;
            }

            if (ans.size() > 2 && ans.get(ans.size()-1) * 2 < number) {
                break;
            }

            if (!isValidSequence(ans, (int)number)) {
                continue;
            }

            ans.add((int)number);
            if (backtracking(s, i+1, ans)) {
                return true;
            }
            ans.remove(ans.size()-1);
        }

        return false;
    }

    private boolean isValidSequence(List<Integer> ans, int number) {
        return ans.size() < 2 || ans.get(ans.size()-1) + ans.get(ans.size()-2) == number;
    }
}

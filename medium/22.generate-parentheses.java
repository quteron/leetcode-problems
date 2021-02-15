class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(n, n, new StringBuilder(2*n), ans);
        return ans;
    }

    private void generateParenthesis(int open, int closed, StringBuilder current, List<String> ans) {
        if (open == 0 && closed == 0) {
            ans.add(current.toString());
        }

        if (open != 0) {
            current.append("(");
            generateParenthesis(open-1, closed, current, ans);
            current.deleteCharAt(current.length()-1);
        }

        if (open < closed) {
            current.append(")");
            generateParenthesis(open, closed-1, current, ans);
            current.deleteCharAt(current.length()-1);
        }
    }
}

class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int ans = 0;
        char op = '+';
        int left = 0, right = 0;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                right = right * 10 + (c-'0');
            }

            if ((!Character.isDigit(c) && !Character.isWhitespace(c)) || i == s.length()-1) {
                if (op == '+' || op == '-') {
                    ans += left;
                    left = (op == '+') ? right : -right;
                } else if (op == '*') {
                    left *= right;
                } else if (op == '/') {
                    left /= right;
                }

                op = c;
                right = 0;
            }
        }

        ans += left;
        return ans;
    }
}

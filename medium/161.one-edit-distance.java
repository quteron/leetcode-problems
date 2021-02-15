class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int cmp = s.length() - t.length();
        if (Math.abs(cmp) > 1) {
            return false;
        }

        boolean flag = false;
        int i=0, j=0;

        while (i<s.length() && j<t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else if (flag) {
                return false;
            } else {
                if (cmp == 0) {
                    i++;
                    j++;
                } else if (cmp > 0) {
                    i++;
                } else {
                    j++;
                }

                flag = true;
            }
        }

        if (i != s.length() || j != t.length()) {
            flag = !flag;
        }

        return flag;
    }
}

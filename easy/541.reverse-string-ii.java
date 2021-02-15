class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i=0; i<s.length(); i += 2*k) {
            int j = Math.min(s.length(), i+k)-1;
            reverse(chars, i, j);
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int l, int r) {
        while (l<r) {
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
    }
}

class Solution {
    public void reverseWords(char[] s) {
        // reverse the whole array
        reverse(s, 0, s.length-1);

        //reverse word by word
        for(int l=0, r=0; r<=s.length; r++) {
            if (r == s.length || s[r] == ' ') {
                reverse(s, l, r-1);
                l = r+1;
            }
        }
    }

    private void reverse(char[] s, int l, int r) {
        while (l<r) {
            char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }
}

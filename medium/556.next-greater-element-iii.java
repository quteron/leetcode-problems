class Solution {
    public int nextGreaterElement(int n) {
        char[] s = String.valueOf(n).toCharArray();

        int l = s.length-1;
        while (l>0 && s[l] <= s[l-1]) {
            l--;
        }

        if (l == 0) {
            return -1;
        }

        l--;

        int r = search(s, l+1, s.length-1, s[l]);
        swap(s, l, r);
        reverse(s, l+1, s.length-1);

        try {
            return Integer.parseInt(new String(s));
        } catch (Exception e) {
            return -1;
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    private void reverse(char[] s, int l, int r) {
        while (l<r) {
            swap(s, l++, r--);
        }
    }

    private int search(char[] s, int l, int r, int target) {
        while (l<=r) {
            int m = l + (r-l)/2;

            if (s[m] <= target) {
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return r;
    }
}

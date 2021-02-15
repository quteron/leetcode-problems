class Solution {
    public int compress(char[] chars) {
        int i=0, count=0;
        for (int j=0; j<=chars.length; j++) {
            if (j == 0 || (j != chars.length && chars[j-1] == chars[j])) {
                count++;
            } else {
                i = compress(chars, i, chars[j-1], count);
                count=1;
            }
        }

        return i;
    }

    private int compress(char[] chars, int i, char letter, int count) {
        chars[i++] = letter;

        if (count == 1) {
            return i;
        }

        String s = String.valueOf(count);
        for (int j=0; j<s.length(); j++) {
            chars[i+j] = s.charAt(j);
        }

        return i+s.length();
    }
}

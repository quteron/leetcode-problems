class Solution {
    public String reverseWords(String s) {
        int l=0, r=s.length()-1;

        // remove leading spaces
        while (l<=r && s.charAt(l) == ' ') {
            l++;
        }

        // remove trailing spaces
        while (l<=r && s.charAt(r) == ' ') {
            r--;
        }

        Deque<String> words = new ArrayDeque();
        StringBuilder word = new StringBuilder();

        for (int i=l; i<=r; i++) {
            char ch = s.charAt(i);
            if (ch == ' ' && word.length() > 0) {
                words.addFirst(word.toString());
                word.setLength(0);
            } else if (ch != ' ') {
                word.append(ch);
            }
        }

        if (word.length() > 0) {
            words.addFirst(word.toString());
        }

        return String.join(" ", words);
    }
}

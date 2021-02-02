public boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;

    s = s.toLowerCase();

    while (l < r) {
        if (!Character.isLetterOrDigit(s.charAt(l))) {
            l++;
        } else if (!Character.isLetterOrDigit(s.charAt(r))) {
            r--;
        } else if (s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        } else {
            return false;
        }
    }

    return true;
}

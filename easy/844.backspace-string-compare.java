public boolean backspaceCompare(String s, String t) {
    int i = s.length()-1;
    int bS = 0;

    int j = t.length()-1;
    int bT = 0;

    while (i >= 0 || j >= 0) {
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                bS++;
                i--;
            } else if (bS > 0) {
                bS--;
                i--;
            } else {
                break;
            }
        }

        while (j >= 0) {
            if (t.charAt(j) == '#') {
                bT++;
                j--;
            } else if (bT > 0) {
                bT--;
                j--;
            } else {
                break;
            }
        }

        if (i == -1 && j == -1) {
            return true;
        } else if ((i == -1) != (j == -1)) {
            return false;
        } else if (s.charAt(i--) != t.charAt(j--)) {
            return false;
        }
    }

    return true;
}

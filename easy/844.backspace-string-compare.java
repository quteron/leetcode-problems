public boolean backspaceCompare(String s, String t) {
    int bS=0, bT=0;
    int iS=s.length()-1, iT=t.length()-1;

    while (iS >= 0 || iT >= 0) {
        if (iS >= 0 && s.charAt(iS) == '#') {
            bS++; iS--;
        } else if (iS >= 0 && bS > 0) {
            bS--; iS--;
        } else if (iT >= 0 && t.charAt(iT) == '#') {
            bT++; iT--;
        } else if (iT >= 0 && bT > 0) {
            bT--; iT--;
        } else if (iS >= 0 && iT >= 0 && s.charAt(iS) == t.charAt(iT)) {
            iS--; iT--;
        } else {
            return false;
        }
    }

    return true;
}

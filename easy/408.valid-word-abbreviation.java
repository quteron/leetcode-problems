public boolean validWordAbbreviation(String word, String abbr) {
    int i = 0;
    int j = 0;

    while (i < word.length() && j < abbr.length()) {
        if (abbr.charAt(j) != '0' && Character.isDigit(abbr.charAt(j))) {
            int start = j;
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                j++;
            }

            int number = Integer.parseInt(abbr.substring(start, j));
            i += number;
        } else if (word.charAt(i++) != abbr.charAt(j++)) {
            return false;
        }
    }

    return i == word.length() && j == abbr.length();
}

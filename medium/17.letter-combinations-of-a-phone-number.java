public List<String> letterCombinations(String digits) {
    List<String> output = new ArrayList<String>();
    if (!digits.isEmpty()) {
        letterCombinations(digits, 0, "", output);
    }
    return output;
}

public void letterCombinations(String digits, int index, String combination, List<String> output) {
    if (index == digits.length()) {
        output.add(combination);
        return;
    }

    char gidit = digits.charAt(index);
    for (char letter : getLettersFor(gidit)) {
        letterCombinations(digits, index+1, combination+letter, output);
    }
}

private char[] getLettersFor(char gidit) {
    switch(gidit) {
        case '2':
            return new char[] {'a', 'b', 'c'};
        case '3':
            return new char[] {'d', 'e', 'f'};
        case '4':
            return new char[] {'g', 'h', 'i'};
        case '5':
            return new char[] {'j', 'k', 'l'};
        case '6':
            return new char[] {'m', 'n', 'o'};
        case '7':
            return new char[] {'p', 'q', 'r', 's'};
        case '8':
            return new char[] {'t', 'u', 'v'};
        case '9':
            return new char[] {'w', 'x', 'y', 'z'};
        default:
            return new char[0];
    }
}

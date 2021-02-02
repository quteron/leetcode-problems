public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> alphabet = new HashMap<Character, Integer>();
    for(int i=0; i<order.length(); i++) {
        alphabet.put(order.charAt(i), i);
    }

    for(int i=1; i<words.length; i++) {
        if (!isSorted(words[i-1], words[i], alphabet)) {
            return false;
        }
    }

    return true;
}

private boolean isSorted(String a, String b, Map<Character, Integer> alphabet) {
    int i = 0;

    while (i < a.length() && i < b.length()) {
        char charA = a.charAt(i);
        char charB = b.charAt(i);

        if (alphabet.get(charA) < alphabet.get(charB)) {
            return true;
        } else if (alphabet.get(charA) > alphabet.get(charB)) {
            return false;
        } else {
            i++;
        }
    }

    return a.length() <= b.length();
}

private Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));

public String toGoatLatin(String s) {
    StringBuilder sb = new StringBuilder();

    String[] words = s.split(" ");
    for (int i=0; i<words.length; i++) {
        String word = words[i];

        if (i > 0) {
            sb.append(" ");
        }

        if (!startsWithVowel(word)) {
            sb.append(word.substring(1));
            sb.append(word.charAt(0));
        } else {
            sb.append(word);
        }

        sb.append("ma");
        sb.append("a".repeat(i+1));
    }

    return sb.toString();
}

private boolean startsWithVowel(String word) {
    return vowels.contains(word.charAt(0));
}

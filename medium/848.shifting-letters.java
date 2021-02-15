public String shiftingLetters(String s, int[] shifts) {
    int shift = 0;

    char[] ans = new char[s.length()];
    for (int i=s.length()-1; i>=0; i--){
        shift += shifts[i] % 26;
        shift %= 26;

        int letter = s.charAt(i) - 'a';
        int shifted = (letter + shift) % 26;
        ans[i] = (char)(shifted + 'a');
    }

    return new String(ans);
}

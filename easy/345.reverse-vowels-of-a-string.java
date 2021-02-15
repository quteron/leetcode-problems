class Solution {
    private Set<Character> vowels = Stream.of('a', 'e', 'i', 'o', 'u').collect(Collectors.toSet());

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        int l=0, r=chars.length-1;
        while (l<r) {
            if (!isVowel(chars[l])) {
                l++;
            } else if (!isVowel(chars[r])) {
                r--;
            } else {
                swap(chars, l, r);
                l++;
                r--;
            }
        }

        return new String(chars);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isVowel(char ch) {
        return vowels.contains(Character.toLowerCase(ch));
    }
}

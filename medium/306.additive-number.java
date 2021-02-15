import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        List<BigInteger> numbers = new ArrayList();
        return backtracking(num, 0, numbers);
    }

    private boolean backtracking(String s, int pos, List<BigInteger> numbers) {
        if (pos == s.length()) {
            return numbers.size() > 2;
        }

        for (int i=pos; i<s.length(); i++) {
            if (i>pos && s.charAt(pos) == '0') {
                break;
            }

            BigInteger number = new BigInteger(s.substring(pos, i+1));
            if (!isValidSequence(numbers, number)) {
                continue;
            }

            numbers.add(number);
            if (backtracking(s, i+1, numbers)) {
                return true;
            }
            numbers.remove(numbers.size()-1);
        }

        return false;
    }

    private boolean isValidSequence(List<BigInteger> numbers, BigInteger third) {
        if (numbers.size() < 2) {
            return true;
        }

        BigInteger twoSum = numbers.get(numbers.size()-1).add(numbers.get(numbers.size()-2));
        return twoSum.compareTo(third) == 0;
    }
}

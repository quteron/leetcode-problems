class PhoneDirectory {

    private TreeSet<Integer> numbers = new TreeSet<Integer>();

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        for (int number=0; number< maxNumbers; number++) {
            numbers.add(number);
        }
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        return numbers.isEmpty() ? -1 : numbers.pollFirst();
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return numbers.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        numbers.add(number);
    }
}

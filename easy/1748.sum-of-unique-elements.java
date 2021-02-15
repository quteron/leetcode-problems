public int sumOfUnique(int[] nums) {
    int sum = 0;

    Map<Integer, Integer> map = new HashMap();
    for (int num : nums) {
        int count = map.getOrDefault(num, 0);
        map.put(num, ++count);

        if (count == 1) {
            sum +=num;
        } else if (count == 2) {
            sum -=num;
        }
    }

    return sum;
}

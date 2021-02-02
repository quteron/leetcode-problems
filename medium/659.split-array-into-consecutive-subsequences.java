public boolean isPossible(int[] nums) {
    Map<Integer, Integer> counts = new HashMap<>();
    Map<Integer, Integer> tails = new HashMap<>();

    for (int num : nums) {
        int count = counts.getOrDefault(num, 0);
        counts.put(num, count+1);
    }

    for (int num : nums) {
        if (counts.get(num) == 0) {
            continue;
        } else if (tails.getOrDefault(num, 0) > 0) {
            tails.put(num, tails.get(num)-1);
            tails.put(num+1, tails.getOrDefault(num+1, 0)+1);
        } else if (counts.getOrDefault(num+1, 0) > 0 && counts.getOrDefault(num+2, 0) > 0) {
            counts.put(num+1, counts.get(num+1)-1);
            counts.put(num+2, counts.get(num+2)-1);
            tails.put(num+3, tails.getOrDefault(num+3, 0)+1);
        } else {
            return false;
        }

        counts.put(num, counts.get(num)-1);
    }

    return true;
}

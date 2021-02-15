public int countPairs(int[] nums) {
    int mod = 1_000_000_007;
    int ans = 0;

    Arrays.sort(nums);
    Map<Integer, Integer> map = new HashMap();

    for(int num : nums) {
        int power = 1;
        for (int i=0; i<22; i++) {
            int complement = power-num;
            if (map.containsKey(complement)) {
                ans += map.get(complement);
                ans %= mod;
            }
            power *= 2;
        }

        int count = map.getOrDefault(num, 0);
        map.put(num, ++count);
    }

    return ans;
}

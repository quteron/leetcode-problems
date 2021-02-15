public int threeSumMulti(int[] arr, int target) {
    Arrays.sort(arr);

    long ans = 0;
    for (int i=0; i<arr.length; i++) {
        ans += twoSumMulti(arr, i, target);
    }

    return (int)(ans % 1000000007);
}

private long twoSumMulti(int[] arr, int i1, int target) {
    Map<Integer, Integer> map = new HashMap();
    long ans = 0;

    for (int i3=i1+1; i3<arr.length; i3++) {
        int complement = target - arr[i3] - arr[i1];
        if (map.containsKey(complement)) {
            ans += map.get(complement);
        }

        int count = map.getOrDefault(arr[i3], 0);
        map.put(arr[i3], ++count);
    }

    return ans;
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return new ArrayList<>();
        }

        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>( (a, b) -> a.get(0) + a.get(1) - b.get(0) - b.get(1) );
        for (int i=0; i<nums2.length; i++) {
            minHeap.add(Arrays.asList(nums1[0], nums2[i]));
        }

        int j = 1;
        List<List<Integer>> output = new ArrayList<>();
        while (!minHeap.isEmpty() && k != 0) {
            List<Integer> current = minHeap.poll();
            output.add(current);
            k--;

            if (j != nums1.length && !minHeap.isEmpty() && minHeap.peek().get(0) + minHeap.peek().get(1) > nums1[j] + nums2[0]) {
                for (int i=0; i<nums2.length; i++) {
                    minHeap.add(Arrays.asList(nums1[j], nums2[i]));
                }
                j++;

            }
        }

        return output;
    }
}

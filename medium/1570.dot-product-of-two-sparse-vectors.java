class SparseVector {

    private Map<Integer, Integer> map;

    SparseVector(int[] nums) {
        this.map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    private int getAt(int index) {
        return map.containsKey(index) ? map.get(index) : 0;
    }

	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0;
        Map<Integer, Integer> a = this.map.size() <= vec.map.size() ? this.map : vec.map;
        Map<Integer, Integer> b = this.map.size() <= vec.map.size() ? vec.map : this.map;

        for (int index : a.keySet()) {
            product += vec.getAt(index) * this.getAt(index);
        }

        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);

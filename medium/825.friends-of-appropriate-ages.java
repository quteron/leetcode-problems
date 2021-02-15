class Solution {
    public int numFriendRequests(int[] ages) {
        int[] counts = new int[121];
        for (int age : ages) {
            counts[age]++;
        }

        int ans = 0;
        for (int ageA = 0; ageA<121; ageA++) {
            int countA = counts[ageA];

            for (int ageB = 0; ageB<121; ageB++) {
                int countB = counts[ageB];

                if (ageB <= 0.5 * ageA + 7) continue;
                if (ageB > ageA) continue;
                if (ageB > 100 && ageA < 100) continue;

                ans += countA * countB;
                if (ageA == ageB) ans -= countA;
            }
        }


        return ans;
    }
}

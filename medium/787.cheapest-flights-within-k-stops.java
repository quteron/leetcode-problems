class Solution {

    class City {
        int id;
        int steps;
        int price;

        City(int id, int steps, int price) {
            this.id = id;
            this.steps = steps;
            this.price = price;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] matrix = new int[n][n];

        for (int[] flight : flights) {
            matrix[flight[0]][flight[1]] = flight[2];
        }

        PriorityQueue<City> minHeap = new PriorityQueue<>((a,b) -> a.price-b.price);
        minHeap.add(new City(src, 0, 0));

        while (!minHeap.isEmpty()) {
            City city = minHeap.poll();
            // have reached the destination
            if (city.id == dst) {
                return city.price;
            }

            // out of flights in this route
            if (city.steps == K+1) {
                continue;
            }

            for (int i=0; i<matrix[city.id].length; i++) {
                int price = matrix[city.id][i];
                if (price > 0) {
                    City next = new City(i, city.steps+1, city.price+price);
                    minHeap.add(next);
                }
            }
        }

        return -1;
    }
}

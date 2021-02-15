class Solution {
    class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length;
        int capital = W;

        PriorityQueue<Project> projects = new PriorityQueue<>((a,b) -> compare(a, b));
        for (int i=0; i<n; i++) {
            projects.offer(new Project(Capital[i], Profits[i]));
        }

        PriorityQueue<Project> available = new PriorityQueue<>((a,b) -> b.profit-a.profit);
        while (k != 0) {
            if (!projects.isEmpty() && projects.peek().capital <= capital) {
                available.offer(projects.poll());
            } else if (!available.isEmpty()) {
                Project next = available.poll();
                capital += next.profit;
                k--;
            } else {
                break;
            }
        }

        return capital;
    }

    public int compare(Project a, Project b) {
        int diff = a.capital-b.capital;
        return diff != 0 ? diff : b.profit-a.profit;
    }
}

public int leastInterval(char[] tasks, int n) {
    int maxCount = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (char task : tasks) {
        int count = map.getOrDefault(task, 0);
        map.put(task, ++count);
        maxCount = Math.max(maxCount, count);
    }

    int maxTasks = 0;
    for (int count : map.values()) {
        if (count == maxCount) {
            maxTasks++;
        }
    }

    return Math.max(tasks.length, (maxCount-1)*(n+1) + maxTasks);
}

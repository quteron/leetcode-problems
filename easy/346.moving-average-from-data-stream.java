private int size;
private Deque<Integer> queue;

private double sum = 0;

/** Initialize your data structure here. */
public MovingAverage(int size) {
    this.queue = new ArrayDeque<Integer>(size);
    this.size = size;
}

public double next(int val) {
    if (queue.size() == size) {
        sum -= queue.removeFirst();
    }

    queue.addLast(val);
    sum += val;

    return sum / queue.size();
}

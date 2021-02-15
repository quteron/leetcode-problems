/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {

    class Event {
        int employeeId;
        int index;
        Interval interval;

        Event(int employeeId, int index, Interval interval) {
            this.employeeId = employeeId;
            this.index = index;
            this.interval = interval;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> output = new ArrayList<>();

        PriorityQueue<Event> queue = new PriorityQueue<>((a, b) -> compare(a, b));
        for (int i=0; i<schedule.size(); i++) {
            List<Interval> employee = schedule.get(i);
            if (!employee.isEmpty()) {
                Event event = new Event(i, 0, employee.get(0));
                queue.offer(event);
            }
        }

        Interval current = null;
        while (!queue.isEmpty()) {
            Event event = queue.poll();
            Interval interval = event.interval;
            List<Interval> employee = schedule.get(event.employeeId);

            if (employee.size() > event.index+1) {
                Event next = new Event(event.employeeId, event.index+1, employee.get(event.index+1));
                queue.offer(next);
            }

            if (current == null) {
                current = new Interval(interval.end, -1);
            } else if (current.start >= interval.end) {
                continue;
            } else if (current.start < interval.start) {
                current.end = interval.start;
                output.add(current);
                current = new Interval(interval.end, -1);
            } else if (current.start < interval.end) {
                current.start = interval.end;
            }
        }

        return output;
    }

    private int compare(Event a, Event b) {
        int diff = a.interval.start - b.interval.start;
        return diff != 0 ? diff : a.interval.end - b.interval.end;
    }
}

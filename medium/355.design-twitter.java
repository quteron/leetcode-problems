class Twitter {

    private class Tweet {
        int id;
        int time;
        Tweet next;
        Tweet prev;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private class User {
        int id;
        Tweet latest;
        Set<User> followees = new HashSet<>();

        User(int id) {
            this.id = id;
            this.followees.add(this);
        }
    }

    private int time = 0;
    private int feedSize = 10;

    private Map<Integer, User> users;

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user = users.getOrDefault(userId, new User(userId));
        Tweet tweet = new Tweet(tweetId, time++);

        if (user.latest != null) {
            user.latest.next = tweet;
            tweet.prev = user.latest;
            user.latest = tweet;
        } else {
            user.latest = tweet;
        }

        users.put(userId, user);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
        List<Integer> output = new ArrayList<>();

        User user = users.getOrDefault(userId, new User(userId));
        for (User followee : user.followees) {
            if (followee.latest != null) {
                maxHeap.add(followee.latest);
            }
        }

        while (!maxHeap.isEmpty() && output.size() != feedSize) {
            Tweet latest = maxHeap.poll();
            output.add(latest.id);
            if (latest.prev != null) {
                maxHeap.add(latest.prev);
            }
        }

        return output;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User followee = users.getOrDefault(followeeId, new User(followeeId));
        users.put(followeeId, followee);
        User user = users.getOrDefault(followerId, new User(followerId));
        users.put(followerId, user);

        user.followees.add(followee);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (users.containsKey(followerId)) {
            User followee = users.getOrDefault(followeeId, new User(followeeId));
            users.put(followeeId, followee);

            User user = users.get(followerId);
            user.followees.remove(followee);
        }
    }
}

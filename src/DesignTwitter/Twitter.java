class Twitter {
    PriorityQueue<Tweet> pq;
    int sequenceId;
    HashMap<Integer, List<Tweet>> userTweetHm;
    HashMap<Integer, HashSet<Integer>> userHm;
    /** Initialize your data structure here. */
    public Twitter() {
        sequenceId = 0;
        userTweetHm = new HashMap<>();
        userHm = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userTweetHm.containsKey(userId)){
            userTweetHm.put(userId, new ArrayList<>());
        }
        userTweetHm.get(userId).add(new Tweet(tweetId, sequenceId++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ret = new ArrayList<>();
        pq = new PriorityQueue<>((a, b) -> (a.sequenceId - b.sequenceId));
        addTweets(userId, pq);
        HashSet<Integer> followees = userHm.get(userId);
        if(followees != null && !followees.isEmpty()){
            for(Integer followee: followees){
                addTweets(followee, pq);
            }
        }
        while(!pq.isEmpty()){
            Tweet tweet = pq.poll();
            if(tweet != null) {
                ret.add(0, tweet.tweetId);
            }
        }
        return ret;
    }

    private void addTweets(int id, PriorityQueue<Tweet> pq){
        List<Tweet> selfTweets = userTweetHm.get(id);
        if(selfTweets != null && !selfTweets.isEmpty()){
            for(Tweet tweet: selfTweets){
                pq.add(tweet);
                if(pq.size() > 10){
                    pq.poll();
                }
            }
        }
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(!userHm.containsKey(followerId)){
            userHm.put(followerId, new HashSet<>());
        }
        userHm.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(userHm.containsKey(followerId)){
            userHm.get(followerId).remove(followeeId);
        }
    }
}

class Tweet{
    int tweetId;
    int sequenceId;
    public Tweet(int tweetId, int sequenceId){
        this.tweetId = tweetId;
        this.sequenceId = sequenceId;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
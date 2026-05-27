class Pair{
    int time, tweet;
    Pair(int time, int tweet){
        this.time = time;
        this.tweet = tweet;
    }
}
class Twitter {
    HashMap<Integer, Set<Integer>> users;
    HashMap<Integer, List<Pair>> userTweets;
    int timer;

    public Twitter() {
        users = new HashMap<>();
        userTweets = new HashMap<>();
        timer = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)){
            users.put(userId, new HashSet<>());
            userTweets.put(userId, new ArrayList<>());
        }
        userTweets.get(userId).add(new Pair(timer++, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!users.containsKey(userId)){
            return new ArrayList<>();
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for(int friend : users.get(userId)){
            List<Pair> list = userTweets.get(friend);
            int count = 0;
            int i = list.size()-1;
            while(count < 10 && i >= 0){
                pq.add(list.get(i));
                count++;
                i--;
            }
        }
        List<Pair> selfTweets = userTweets.get(userId);
        int count = 0;
        int i = selfTweets.size()-1;
        while(count < 10 && i >= 0){
            pq.add(selfTweets.get(i));
            count++;
            i--;
        }
        List<Integer> res = new ArrayList<>();
        i = 0;
        while(!pq.isEmpty() && i < 10){
            res.add(pq.remove().tweet);
            i++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
            users.put(followerId, new HashSet<>());
            userTweets.put(followerId, new ArrayList<>());
        }
        if(!users.containsKey(followeeId)){
            users.put(followeeId, new HashSet<>());
            userTweets.put(followeeId, new ArrayList<>());
        }
        users.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
            users.put(followerId, new HashSet<>());
            userTweets.put(followerId, new ArrayList<>());
        }
        if(!users.containsKey(followeeId)){
            users.put(followeeId, new HashSet<>());
            userTweets.put(followeeId, new ArrayList<>());
        }
        users.get(followerId).remove(followeeId);
        
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
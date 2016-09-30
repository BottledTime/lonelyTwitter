package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by derekshultz on 2016-09-29.
 */
public class TweetList
{
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList()
    {

    }

    public boolean hasTweet(Tweet tweet)
    {
           return tweets.contains(tweet);
    }

    public void add(Tweet tweet)
    {
        if (tweets.contains(tweet))
        {
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }

    public void delete(Tweet tweet)
    {
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index)
    {
        return tweets.get(index);

    }

    public List<Tweet> getTweets()
    {
        List<Tweet> copy = new ArrayList<Tweet>(tweets);
        Collections.sort(copy, new Comparator<Tweet>() {
            public int compare(Tweet lhs, Tweet rhs) {
                return lhs.getDate().compareTo(rhs.getDate());
            }
        });
        return copy;
    }

    public int getCount()
    {
        return tweets.size();
    }
}

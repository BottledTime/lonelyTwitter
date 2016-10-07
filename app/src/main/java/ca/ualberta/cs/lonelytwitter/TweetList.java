package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by derekshultz on 2016-09-29.
 * This is a model controller class that represents the list of all the tweets that exist. It allows
 * tweets to be added or removed.
 */
public class TweetList
{
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Instantiates a new Tweet list.
     */
    public TweetList()
    {

    }

    /**
     * Has tweet boolean. Returns true if the tweetlist contains the specified tweet.
     *
     * @param tweet the tweet
     * @return whether the tweet is in the list
     */
    public boolean hasTweet(Tweet tweet)
    {
           return tweets.contains(tweet);
    }

    /**
     * Add a tweet.
     *
     * @param tweet the tweet
     */
    public void add(Tweet tweet)
    {
        if (tweets.contains(tweet))
        {
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }

    /**
     * Delete a tweet.
     *
     * @param tweet the tweet
     */
    public void delete(Tweet tweet)
    {
        tweets.remove(tweet);
    }

    /**
     * Gets tweet.
     *
     * @param index the index
     * @return the tweet
     */
    public Tweet getTweet(int index)
    {
        return tweets.get(index);

    }

    /**
     * Gets the whole tweets list and returns them in order of their date.
     *
     * @return the tweets in chronological order
     */
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

    /**
     * Gets a count of all the tweets.
     *
     * @return the count
     */
    public int getCount()
    {
        return tweets.size();
    }
}

package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;
import java.util.List;

//import JUnit4 to have @Before to make everything way better

/**
 * Created by derekshultz on 2016-09-29.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest()
    {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testAddDuplicateTweet()
    {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);
        try
        {
            tweets.add(tweet);
        }
        catch(IllegalArgumentException arg)
        {
            return;
        }
        assertTrue(false);
    }

    //must start with 'test'
    public void testHasTweet()
    {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testDelete()
    {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        list.delete(tweet);
        assertFalse(list.hasTweet(tweet));
    }

    public void testGetTweet()
    {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }

    public void testGetTweets()
    {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweet.setDate(new Date(1999, 12, 31));
        Tweet another_tweet = new NormalTweet("adding another tweet");
        another_tweet.setDate(new Date(2000, 1, 1));
        tweets.add(another_tweet);
        tweets.add(tweet);
        assertEquals(tweets.getTweets().get(0), tweet);
        assertEquals(tweets.getTweets().get(1), another_tweet);
    }

    public void testHasEqualTweet()
    {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);
        Tweet new_tweet = new NormalTweet("adding tweet");
        assertTrue(tweets.hasTweet(new_tweet));
    }

    public void testGetCount()
    {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);
        assertEquals(tweets.getCount(), 1);
        Tweet another_tweet = new NormalTweet("yo");
        tweets.add(another_tweet);
        assertEquals(tweets.getCount(), 2);
    }
}

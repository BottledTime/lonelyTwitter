package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;
import java.util.Date;

/**
 * This is a model abstract class that represents tweets.
 * It has a message attribute and a date attribute. It allows the caller to set the message or
 * the message and the date upon creation.
 * It overrides toString to return its message. The message and date are capable of being reset
 * later. It's equal method checks if the message is equal.
 * Created by watts1 on 9/15/16.
 */
public abstract class Tweet implements Tweetable, Serializable {
    private String message;
    private Date date;

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     * @param date    the date
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    @Override
    public String toString()
    {
        return message;
    }

    /**
     * Is important boolean.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();


    /**
     * Sets message.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140){
            //Do Something!
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    /**
     * Overrides equal to check if the message is equal.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        if (!message.equals(tweet.message)) return false;
        return date.equals(tweet.date);

    }

    @Override
    public int hashCode() {
        int result = message.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}

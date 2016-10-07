package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

/**
 * Created by watts1 on 9/15/16.
 * This is an interface to enforce that something is able to be tweeted. getMessage needs to return
 * a String and getDate needs to return a date.
 */
public interface Tweetable {
    /**
     * Gets message. Must return a String.
     *
     * @return the message
     */
    public String getMessage();

    /**
     * Gets date. Must return a Date.
     *
     * @return the date
     */
    public Date getDate();

}

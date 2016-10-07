package ca.ualberta.cs.lonelytwitter;

/**
 * Created by watts1 on 9/15/16.
 * This is the model class that represents normal tweets that are not important. It's just like the
 * Tweet abstract class, but its isImportant method returns false.
 */
public class NormalTweet extends Tweet {

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message for the Tweet
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * This overrides Tweet's abstract method that says whether a tweet is important, but returns
     * false.
     * @return true to say that this tweet is important.
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}

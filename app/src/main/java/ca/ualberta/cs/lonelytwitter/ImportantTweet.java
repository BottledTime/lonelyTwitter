package ca.ualberta.cs.lonelytwitter;

/**
 * This class is a model class that represents tweets that are important.
 * It's just like the Tweet abstract class, but its isImportant method returns true.
 * Created by watts1 on 9/15/16.
 */
public class ImportantTweet extends Tweet{

    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message for the Tweet
     */
    public ImportantTweet(String message){
        super(message);
    }

    /**
     * This overrides Tweet's abstract method that says whether a tweet is important, but returns
     * true.
     * @return true to say that this tweet is important.
     */
    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }


}

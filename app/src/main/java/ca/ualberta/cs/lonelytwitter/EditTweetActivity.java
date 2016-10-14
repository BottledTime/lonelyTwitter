package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    private EditText tweetText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        Tweet tweet = (Tweet) getIntent().getExtras().get("Tweet");
        tweetText = (EditText)findViewById(R.id.tweetTextView);
        tweetText.setText(tweet.toString());
    }
}

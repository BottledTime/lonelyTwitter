/*
Copyright (C) 2016 Team 20, CMPUT301, University of Alberta - All Rights Reserved
You may use, copy or distribute this code under terms and conditions of University of Alberta
and Code of Student Behaviour.
Please contact abc@abc.ca for more details or questions.
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This class is the main view class in lonelyTwitter class.
 * It deals with user inputs, saves/loads them in/from the file FILE_NAME (file.sav)
 * <p> You can access this file from Android Device Monitor.</p>
 * <pre> pre-formatted      text</pre>
 * <code>
 * pseudo-code that is used in this class is as follows:
 * step 1 <br>
 * step2 <br>
 * </code>
 *
 * @author derekshultz
 * @see NormalTweet
 * @see java.io.BufferedReader
 * @see TweetList
 * @since 1.4
 */
public class LonelyTwitterActivity extends Activity {

	/**
	 * This is the name of the file that is saved in your virtual device.
	 * You can access it through Android Device Monitor by selecting your app,
	 * then data -> data -> file.sav
	 * @see NormalTweet
	 * @author A
	 */
	private Activity activity = this;

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	public ListView getOldTweetsList(){
		return oldTweetsList;
	}

	/**
	 * Called when the activity is first created. Shows views. Sets listeners for the save button
	 * and the clear button
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		loadFromFile();

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet newTweet = new NormalTweet(text);
				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				tweetList.clear();
                deleteFile(FILENAME);
				adapter.notifyDataSetChanged();
//				saveInFile();
			}
		});

		oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				Intent intent = new Intent(activity, EditTweetActivity.class);
                intent.putExtra("Tweet", adapter.getItem(position));
				startActivity(intent);
			}
		});
	}

	/**
	 * Sets up adapter for the list of tweets
	 */
	@Override
	protected void onStart() {
		super.onStart();
        loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * This method loads the json file (or creates one if it doesn't yet exist) and generates the
	 * tweets from its contents.
	 */
	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			//Code taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt September 22, 2016
			Type listType =new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			saveInFile();
			//throw new RuntimeException();
		}
	}

	/**
	 * This method saves to the json file.
	 */
	private void saveInFile() {
		try {

			FileOutputStream fos = openFileOutput(FILENAME, 0);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweetList, writer);
			writer.flush();
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
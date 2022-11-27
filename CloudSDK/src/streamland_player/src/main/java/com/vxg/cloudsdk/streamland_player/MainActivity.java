/*
 *
  * Copyright (c) 2011-2017 VXG Inc.
 *
 */


package com.vxg.cloudsdk.streamland_player;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.vxg.cloud.core.CloudCommon.CloudLiveUrlType;
import com.vxg.cloud.core.CloudHelpers;
import com.vxg.cloudsdk.CloudPlayerSDK;
import com.vxg.cloudsdk.CloudSDK;
import com.vxg.cloudsdk.Enums.CloudPlayerEvent;
import com.vxg.cloudsdk.Enums.CloudPlayerLocalRecordFlag;
import com.vxg.cloudsdk.Interfaces.ICloudObject;
import com.vxg.cloudsdk.Interfaces.ICloudPlayerCallback;
import com.vxg.cloudsdk.Objects.CloudPlayerConfig;
import com.vxg.cloudsdk.streamland_player.snippets.CloudClips;
import com.vxg.cloudsdk.streamland_player.snippets.CloudEvents;
import com.vxg.cloudsdk.streamland_player.snippets.CloudTimelineDays;
import com.vxg.cloudsdk.streamland_player.snippets.CloudTimelineSegments;
import com.vxg.cloudsdk.streamland_player.snippets.CloudTimelineThumbnails;
import com.vxg.cloudsdk.streamland_player.snippets.CloudTimelines;
import com.vxg.ui.CloudPlayerView;
import com.vxg.ui.TimeLineSet;

import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;

public class MainActivity extends Activity implements OnClickListener, CloudPlayerView.OnCloudPlayerViewChange
{
	public final String TAG = MainActivity.class.getSimpleName();

	public  static		AutoCompleteTextView	edtId;
	private Button		btnConnect;
	private Button 		btnTestAPI;
	private Button 		btnShowTimeline;

	private Button 		btnRecord;
	private boolean     isRecording = false;
	private View 		viewLayout_info;

	private CloudPlayerView player;
	private CloudPlayerSDK playerSDK;

	private MulticastLock multicastLock = null;

	//SET Channel
	String msAccessToken = "";


    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		setTitle(R.string.app_name);
		super.onCreate(savedInstanceState);

		WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
		multicastLock = wifi.createMulticastLock("multicastLock");
		multicastLock.setReferenceCounted(true);
		multicastLock.acquire();

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

		getWindow().requestFeature(Window.FEATURE_PROGRESS);
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);

		CloudSDK.setContext(this);
		CloudSDK.setLogLevel(2);
		CloudSDK.setLogEnable(true);

		setContentView(R.layout.view_camera_buy_id);

		Toast.makeText(getApplicationContext(), "CloudSDK ver="+CloudSDK.getLibVersion(), Toast.LENGTH_LONG).show();

		player = (CloudPlayerView) findViewById(R.id.player_view);
		player.setOnCloudPlayerViewChange(this);
		player.setNotificationsListener(new CloudPlayerView.Notifications() {
			@Override
			public int onSharedTokenWillExpireIn(long deltaTimeInMs) {
				Log.e(TAG, "onSharedTokenWillExpireIn: " + deltaTimeInMs);
				return 0;
			}

			@Override
			public int onSeekStarted() {
				return 0;
			}

			@Override
			public int onSeekFailed() {
				return 0;
			}

			@Override
			public int onSeekCompleted() {
				return 0;
			}

			@Override
			public int onLocalRecordStarted() {
				Log.d(TAG,"onLocalRecordStarted: ");
				isRecording = true;
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						btnRecord.setText("STOP RECORD");
					}
				});

				return 0;
			}

			@Override
			public int onLocalRecordStopped(String path) {
				Log.d(TAG,"onLocalRecordStopped: path: " + path);
				isRecording = false;
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						btnRecord.setText("START RECORD");
					}
				});
				return 0;
			}

			@Override
			public int onLocalRecordClosed() {
				Log.d(TAG,"onLocalRecordClosed: ");
				isRecording = false;
				return 0;
			}
		});

		playerSDK = player.getCloudPlayerSDK();

		player.setTimeLineEnabled(true);
		//player.getTimeLine().setType(TimeLineSet.TimeLine.TYPE_RANGE);
		player.hideTimeLine();

		player.getTimeLine().setLoaderListener(new TimeLineSet.LoaderListener() {
			//Shows data wich has been loaded on timline directly from server. For debug purpose
			@Override
			public void onDataLoaded(List<Pair<Long, Long>> data) {
			if(data!=null){
				Log.d(TAG,"onDataLoaded to TimeLine size ="+data.size());
				int i=0;
				for(Pair p:data){
					Log.d(TAG,"onDataLoaded item"+(i++)+"start="+TimeLineSet.getDate((long)p.first)+" end="+TimeLineSet.getDate((long)p.second));
				}
			} else
				Log.d(TAG,"onDataLoaded data = null");
			}
		});

		btnShowTimeline = (Button) findViewById(R.id.but_show_timeline);
		btnShowTimeline.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (player.getTimeLineVisibility() == View.INVISIBLE) {
					player.showTimeLine();
					btnShowTimeline.setText("hide timeline");
				} else {
					player.hideTimeLine();
					btnShowTimeline.setText("show timeline");
				}
			}
		});

		btnTestAPI = (Button) findViewById(R.id.but_test_api);
		btnTestAPI.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				testAPI();
			}
		});

		btnRecord = (Button) findViewById(R.id.but_record);
		btnRecord.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isRecording) {
					playerSDK.localRecordStop();
				} else {
					playerSDK.localRecordSetup(getRecordPath(), CloudPlayerLocalRecordFlag.NO_START.value, 0, 0, "TestRecord");
					playerSDK.localRecordStart();
				}
			}
		});

		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		edtId = (AutoCompleteTextView)findViewById(R.id.edit_id);
		edtId.setText(msAccessToken ==null?"": msAccessToken);

		edtId.setOnEditorActionListener(new OnEditorActionListener()
		{
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event)
			{
				if (event != null&& (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
				{
					InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					in.hideSoftInputFromWindow(edtId.getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
					return true;

				}
				return false;
			}
		});

		btnConnect = (Button)findViewById(R.id.button_connect);
        btnConnect.setOnClickListener(this);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.main_view);
        layout.setOnTouchListener(new OnTouchListener() 
		{
			public boolean onTouch(View v, MotionEvent event) 
			{
				InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				if (getWindow() != null && getWindow().getCurrentFocus() != null && getWindow().getCurrentFocus().getWindowToken() != null)
					inputManager.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
				return true;
			}
		});

		viewLayout_info = findViewById(R.id.layout_info);

    }

	public boolean check_access_token(){
    	String ch = edtId.getText().toString();
    	if(ch.length() > 0){
			msAccessToken = ch;
		}
		if(msAccessToken == null || msAccessToken.length()<1){

					new AlertDialog.Builder(this)
									.setTitle("Access token")
									.setMessage("Please set \'Access token\' STRING into msAccessToken variable ")
									.setNeutralButton("OK", null)
									.show();

					return false;
			}
		return true;
	}

	public void onClick(View v)
	{
		try{
			if(!check_access_token())
				return ;

			// set auto started record
			CloudPlayerConfig config = playerSDK.getCloneConfig();
			config.localRecordPath(getRecordPath());
			config.localRecordFlags(CloudPlayerLocalRecordFlag.AUTO_START.value | CloudPlayerLocalRecordFlag.SPLIT_BY_TIME.value);
			config.localRecordSplitTime(30);
			config.localRecordPrefix("AutoTestRecord");
			playerSDK.setConfig(config);

			playerSDK.setSource(msAccessToken);
			player.play();

		} catch (Exception e){
			Log.e(TAG,e.toString());
			return;
		}
    }

	private String getRecordPath()
	{
		File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
				Environment.DIRECTORY_DCIM), "RecordsMediaPlayer");

		if (! mediaStorageDir.exists()){
			if (!(mediaStorageDir.mkdirs() || mediaStorageDir.isDirectory())){
				Log.e(TAG, "<=getRecordPath() failed to create directory path="+mediaStorageDir.getPath());
				return "";
			}
		}
		return mediaStorageDir.getPath();
	}

	private void testAPI() {
		// To check the snippets, please uncomment what you are interested in checking.
		// The result is in the application logs
		// For avoid run network code in main thread with methods *Sync, we use Executors.newSingleThreadExecutor for this test

//		CloudPlayerSDK testSDK = new CloudPlayerSDK(null, null, null);
//		testSDK.setSourceForAPIOnly(msAccessToken);
//
//		CloudClips clips = new CloudClips(testSDK);
//		Executors.newSingleThreadExecutor().submit(clips::printClipsSync);
//		Executors.newSingleThreadExecutor().submit(clips::createClipCompleteSync);
//		Executors.newSingleThreadExecutor().submit(clips::createClipSync);
//		Executors.newSingleThreadExecutor().submit(clips::updateClipsSync);
//		Executors.newSingleThreadExecutor().submit(clips::deleteClipsForClipIdSync);
//		Executors.newSingleThreadExecutor().submit(clips::printClipsSync);
//		Executors.newSingleThreadExecutor().submit(() -> clips.deleteClipsForCameraIdSync(-1));
//		Executors.newSingleThreadExecutor().submit(clips::printClipsSync);
//		clips.printClips();
//		clips.createClip();
//		clips.deleteClipsForCameraId(-1);
//
//		CloudTimelines timelines = new CloudTimelines(testSDK);
//		Executors.newSingleThreadExecutor().submit(timelines::printTimelineSync);
//		Executors.newSingleThreadExecutor().submit(timelines::printTimelineWithLimitSync);
//		timelines.printTimeline();
//		timelines.printTimelineWithLimit();
//
//		CloudTimelineDays days = new CloudTimelineDays(testSDK);
//		Executors.newSingleThreadExecutor().submit(days::printTimelineDaysSync);
//		Executors.newSingleThreadExecutor().submit(days::printTimelineDaysWithLimitSync);
//		days.printTimelineDays();
//		days.printTimelineDaysWithLimit();
//
//		CloudEvents events = new CloudEvents(testSDK);
//		Executors.newSingleThreadExecutor().submit(events::printEventsSync);
//		Executors.newSingleThreadExecutor().submit(events::printEventsWithLimitSync);
//		events.printEvents();
//		events.printEventsWithLimit();
//
//		CloudTimelineSegments segments = new CloudTimelineSegments(testSDK);
//		Executors.newSingleThreadExecutor().submit(segments::printSegmentsSync);
//		Executors.newSingleThreadExecutor().submit(segments::printSegmentsWithLimitSync);
//		segments.printSegments();
//		segments.printSegmentsWithLimit();
//
//		CloudTimelineThumbnails thumbnails = new CloudTimelineThumbnails(testSDK);
//		Executors.newSingleThreadExecutor().submit(thumbnails::printThumbnailsSync);
//		Executors.newSingleThreadExecutor().submit(thumbnails::printThumbnailsWithLimitSync);
//		thumbnails.printThumbnails();
//		thumbnails.printThumbnailsWithLimit();
	}
  	@Override
  	protected void onDestroy() 
  	{
  		Log.e(TAG, "onDestroy()");

		System.gc();
		
		if (multicastLock != null) {
		    multicastLock.release();
		    multicastLock = null;
		}		
		super.onDestroy();
   	}	

	//=> CloudPlayerView.OnCloudPlayerViewChange
	@Override
	public void onFullscreen(boolean isFullscreen, int nLockOrientation) {
		if(isFullscreen){
			viewLayout_info.setVisibility(View.GONE);
		}else{
			viewLayout_info.setVisibility(View.VISIBLE);
		}

		if(nLockOrientation != -1){ // user clicked on player
			setRequestedOrientation(nLockOrientation);
		}else{
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
		}

	}

	@Override
	public void onShowControls(boolean isShow) {

	}

	@Override
	public void onPlayed() {

	}

	@Override
	public void onPaused() {

	}

	@Override
	public void onEOS() {

	}

	@Override
	public void onOutOfRange() {

	}

	@Override
	public void onError(int error) {

	}

	@Override
	public void onStatusWillShow(CloudPlayerEvent event, int code, String message, CloudPlayerView.onStatusWillShowResult result) {
		Log.d(TAG,"onStatusWillShow: event: " + event + ", code: " + code + ", message: " + message);
		//result.update("New text here");
		//result.skip();
	}
	//<= CloudPlayerView.OnCloudPlayerViewChange

}

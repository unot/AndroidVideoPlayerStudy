package com.tumblr.interglacial.JustCapture;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class JustCaptureActivity extends Activity implements OnClickListener {
	private VideoView video = null;
	private String video_path;
	private Uri video_uri;
	private int PIC_REQUEST_CODE = 1000;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// ボタン
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(this);
		// 動画再生
		video_path = "/mnt/sdcard/DCIM/100SHARP/120222_174634.3gp";
		video = (VideoView) findViewById(R.id.videoView1);
		video.setMediaController(new MediaController(this));
		video.setVideoPath(video_path);
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		// int PIC_REQUEST_CODE = 1000;
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("video/*");
		startActivityForResult(Intent.createChooser(intent, "Select a video"),
				PIC_REQUEST_CODE);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == PIC_REQUEST_CODE) {
			// ContentResolver cr = getContentResolver();
			// String[] columns = {MediaStore.Video.Media.DATA };
			// Cursor c = cr.query(data.getData(), columns, null, null, null);
			// c.moveToFirst();
			video_uri = data.getData();
			video = (VideoView) findViewById(R.id.videoView1);
			video.setMediaController(new MediaController(this));
			video.setVideoURI(video_uri);
		}
	}
}
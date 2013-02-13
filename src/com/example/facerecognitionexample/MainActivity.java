package com.example.facerecognitionexample;

// import org.opencv.android.BaseLoaderCallback;
// import org.opencv.android.LoaderCallbackInterface;
// import org.opencv.utils.Converters;
import org.opencv.android.OpenCVLoader;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import com.example.facerecognitionexample.FaceRecognition;

public class MainActivity extends Activity {
	final String TAG = new String("FR");
	
	// Tao doi tuong model cho class FaceRecognition
	FaceRecognition model = new FaceRecognition(10);
	
	// Khoi dong OpenCV
	static {
		if (!OpenCVLoader.initDebug()) {
			// Handle initialization error
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		model.imgRead(); // Doc hinh anh
		model.imgTrain(); // Huan luyen hinh anh
		
		Log.i(TAG, "Finish successfully"); // Chuong trinh hoan tat thanh cong
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	/*
	private BaseLoaderCallback  mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                {
                    Log.i(TAG, "OpenCV loaded successfully");
                    
                } break;
                default:
                {
                    super.onManagerConnected(status);
                } break;
            }
        }
    };
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.i(TAG, "called onResume");
		super.onResume();
		
		Log.i(TAG, "Trying to load OpenCV library");
	    if (!OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_2, this, mOpenCVCallBack)) {
	        Log.e(TAG, "Cannot connect to OpenCV Manager");
	    }
	}
	*/
	
}

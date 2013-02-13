package com.example.facerecognitionexample; // opencv path: D:\Programs\OpenCV...
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import org.opencv.contrib.FaceRecognizer;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.utils.Converters;
import android.util.Log;

public class FaceRecognition extends FaceRecognizer {

		public FaceRecognition(long addr) {
			super(addr);
			// TODO Auto-generated constructor stub
		}
		
		final String TAG = new String("FR");
		
		ArrayList<Mat> images = new ArrayList<Mat>(); // Tao list luu tru hinh anh
		Vector<Integer> labels = new Vector<Integer>(); // Tao list luu nhan cho hinh anh
		
		// Tao cac doi tuong file hinh anh
		File imgFile1 = new File("/mnt/sdcard/337_Nick+Carter+nick12.jpg");
		File imgFile2 = new File("/mnt/sdcard/Nick-3-nick-carter.jpg");
		File imgFile3 = new File("/mnt/sdcard/nick-carter-9a.jpg");
		
		public void imgRead() {
			if (imgFile1.exists()) {
				Log.i(TAG, "Reading pic1");
				try {
					Mat pic1 = Highgui.imread(imgFile1.getAbsolutePath(), Highgui.CV_LOAD_IMAGE_GRAYSCALE); // doc file anh 1
					images.add(pic1);
					labels.add(0);
				} catch (Exception ex) {
					Log.e(TAG, ex.getMessage());
				}
				
				Log.i(TAG, "Read pic1 successfully");
			}
			
			if (imgFile2.exists()) {
				Log.i(TAG, "Reading pic2");
				Mat pic2 = Highgui.imread(imgFile2.getAbsolutePath(), Highgui.CV_LOAD_IMAGE_GRAYSCALE); // doc file anh 2
				images.add(pic2);
				labels.add(0);
				Log.i(TAG, "Read pic2 successfully");
			}
			
			if (imgFile3.exists()) {
				Log.i(TAG, "Reading pic3");
				Mat pic3 = Highgui.imread(imgFile3.getAbsolutePath(), Highgui.CV_LOAD_IMAGE_GRAYSCALE); // doc file anh 3
				images.add(pic3);
				labels.add(0);
				Log.i(TAG, "Read pic3 successfully");
			}
			
		}
		
		public void imgTrain() {
			Log.i(TAG, "Training");
			try {
				super.train(images, Converters.vector_int_to_Mat(labels)); // huan luyen tu nhung hinh anh da cho
				Log.i(TAG, "Train successfully");
			} catch (Exception ex) {
				Log.e(TAG, ex.getMessage() + ex.getCause());
			}
					
			
		}
	}
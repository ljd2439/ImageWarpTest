package com.example.jaedong.imagewarptest;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import org.opencv.calib3d.Calib3d;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfPoint3f;


public class MainActivity extends AppCompatActivity {

    private final int pixel_width = 2048;
    private final int pixel_height = 1536;
    private GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        glSurfaceView = new SurfaceView(this);
        setContentView(glSurfaceView);

    }
/*
    public void solvePnp(){


        MatOfPoint3f objectPoints = new MatOfPoint3f();
        float[] p1 = {0.0f, 0.0f, 0.0f};
        float[] p2 = {1.0f, 0.0f, 0.0f};
        float[] p3 = {1.0f, 0.5f, 0.85f};
        float[] p4 = {0.0f, 0.5f, 0.85f};

        objectPoints.put(0,0,p1);
        objectPoints.put(0,1,p2);
        objectPoints.put(0,2,p3);
        objectPoints.put(0,3,p4);

        MatOfPoint2f imagePoints = new MatOfPoint2f();
        float[] p1_ = {0.0f, 0.0f};
        float[] p2_ = {1.0f, 0.0f};
        float[] p3_ = {1.0f, 0.5f};
        float[] p4_ = {0.0f, 0.5f};

        imagePoints.put(0,0,p1_);
        imagePoints.put(0,1,p2_);
        imagePoints.put(0,2,p3_);
        imagePoints.put(0,3,p4_);

        Mat cameraMatrix = new Mat();

        MatOfDouble distCoeffs;
        Mat rvec;
        Mat tvec;
    }
*/
    @Override
    protected void onResume(){
        super.onResume();
        glSurfaceView.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        glSurfaceView.onPause();
    }

}


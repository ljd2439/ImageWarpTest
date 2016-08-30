package com.example.jaedong.imagewarptest;

import android.content.Context;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;


import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfPoint3f;

import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


/**
 * Created by jaedong on 2016. 7. 19..
 */
public class SurfaceView extends GLSurfaceView {

    private Renderer mRenderer;

    public SurfaceView(Context context){
        super(context);

        mRenderer = new Renderer();
        setRenderer(mRenderer);
    }

    private class Renderer implements GLSurfaceView.Renderer {

        private Camera mCamera = new Camera();
        private Line mLine_x = new Line(-40,0,0,40,0,0,0);
        private Line mLine_y = new Line(0,-60,0,0,60,0,0);
        private Line mLine_z = new Line(0,0,-60,0,0,60,0);
        private Rect mRect = new Rect(30, 5);

        public Renderer() {

        }

        public void onSurfaceCreated(GL10 gl, EGLConfig config) {

            gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
            gl.glClearDepthf(1.0f);
            gl.glEnable(GL10.GL_DEPTH_TEST);
            gl.glDepthFunc(GL10.GL_LEQUAL);
            gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);

        }

        public void onSurfaceChanged(GL10 gl, int width, int height) {

            gl.glViewport(0, 0, width, height);
            gl.glMatrixMode(GL10.GL_PROJECTION);
            gl.glLoadIdentity();

            GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f, 100.0f);

            gl.glMatrixMode(GL10.GL_MODELVIEW);
            gl.glLoadIdentity();
        }

        public void onDrawFrame(GL10 gl) {

            gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
            gl.glLoadIdentity();
            GLU.gluLookAt(gl, 40.0f, 30.0f, 70.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);

            mCamera.draw(gl);
            mLine_x.draw(gl);
            mLine_y.draw(gl);
            mLine_z.draw(gl);
            mRect.draw(gl);
        }
    }
}

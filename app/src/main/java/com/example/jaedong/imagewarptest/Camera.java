package com.example.jaedong.imagewarptest;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.provider.MediaStore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by jaedong on 2016. 7. 20..
 */
public class Camera {

    private FloatBuffer vertexBuffer;
    private FloatBuffer colorBuffer;
    private ByteBuffer indexBuffer;

    float camera_x = 5.0f;
    float camera_y = 5.0f;
    float camera_z = 20.0f;

    private float vertices[] = {
            camera_x-1.0f, camera_y+1.0f, camera_z+1.0f,
            camera_x+1.0f, camera_y+1.0f, camera_z+1.0f,
            camera_x+1.0f, camera_y+1.0f, camera_z-1.0f,
            camera_x-1.0f, camera_y+1.0f, camera_z-1.0f,
            camera_x-1.0f, camera_y-1.0f, camera_z+1.0f,
            camera_x+1.0f, camera_y-1.0f, camera_z+1.0f,
            camera_x+1.0f, camera_y-1.0f, camera_z-1.0f,
            camera_x-1.0f, camera_y-1.0f, camera_z-1.0f
    };

    private float colors[] = {
            1.0f, 0.1f, 0.6f, 1.0f,
            1.0f, 0.1f, 0.6f, 1.0f,
            1.0f, 0.1f, 0.6f, 1.0f,
            1.0f, 0.1f, 0.6f, 1.0f,
            0.5f, 0.2f, 0.9f, 1.0f,
            0.5f, 0.2f, 0.9f, 1.0f,
            0.5f, 0.2f, 0.9f, 1.0f,
            0.5f, 0.2f, 0.9f, 1.0f
    };

    private byte indices[] = {
            0,1,2,0,2,3,
            4,5,6,4,6,7,
            0,4,5,0,5,1,
            3,7,6,3,6,2,
            0,4,7,0,7,3,
            1,5,6,1,6,2
    };

    public Camera() {

        ByteBuffer byteBuf = ByteBuffer.allocateDirect(vertices.length * 4);
        byteBuf.order(ByteOrder.nativeOrder());
        vertexBuffer = byteBuf.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        byteBuf = ByteBuffer.allocateDirect(colors.length * 4);
        byteBuf.order(ByteOrder.nativeOrder());
        colorBuffer = byteBuf.asFloatBuffer();
        colorBuffer.put(colors);
        colorBuffer.position(0);

        indexBuffer = ByteBuffer.allocateDirect(indices.length);
        indexBuffer.put(indices);
        indexBuffer.position(0);
    }

    public void draw(GL10 gl) {

        gl.glFrontFace(GL10.GL_CW);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glDrawElements(GL10.GL_TRIANGLES, 36, GL10.GL_UNSIGNED_BYTE, indexBuffer);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

        Line camera_x_axis = new Line(camera_x, camera_y, camera_z, camera_x + 6, camera_y, camera_z, 1);
        Line camera_y_axis = new Line(camera_x, camera_y, camera_z, camera_x, camera_y + 6, camera_z, 1);
        Line camera_z_axis = new Line(camera_x, camera_y, camera_z, camera_x, camera_y, camera_z + 6, 1);
        camera_x_axis.draw(gl);
        camera_y_axis.draw(gl);
        camera_z_axis.draw(gl);

    }


}

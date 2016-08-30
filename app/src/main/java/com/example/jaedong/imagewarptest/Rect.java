package com.example.jaedong.imagewarptest;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by jaedong on 2016. 7. 21..
 */
public class Rect {

    private FloatBuffer vertexBuffer;
    private FloatBuffer colorBuffer;
    private ByteBuffer indexBuffer;

    float rect_x = 10.0f;
    float rect_y = 10.0f;
    float rect_z = 20.0f;

    private float vertices[] = new float[12];

    private float colors[] = {
            0.1f, 0.5f, 1.0f, 1.0f,
            0.1f, 0.5f, 1.0f, 1.0f,
            0.1f, 0.5f, 1.0f, 1.0f,
            0.1f, 0.5f, 1.0f, 1.0f
    };

    private byte indices[] = {
            0,1,2,0,2,3,
    };

    public Rect(float z, float l) {

        vertices[0]  = -l;
        vertices[1]  =  l;
        vertices[2]  =  z;
        vertices[3]  =  l;
        vertices[4]  =  l;
        vertices[5]  =  z;
        vertices[6]  =  l;
        vertices[7]  = -l;
        vertices[8]  =  z;
        vertices[9]  = -l;
        vertices[10] = -l;
        vertices[11] =  z;

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
        gl.glDrawElements(GL10.GL_TRIANGLES, 6, GL10.GL_UNSIGNED_BYTE, indexBuffer);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }

}

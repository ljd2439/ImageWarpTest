package com.example.jaedong.imagewarptest;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by jaedong on 2016. 7. 20..
 */
public class Line {


    private float vertices[] = new float[6];
    private FloatBuffer vertexBuffer;
    private ByteBuffer indexBuffer;

    private int type = 0;


    public Line(float x, float y, float z, float x_, float y_, float z_, int type_) {

        vertices[0] = x;
        vertices[1] = y;
        vertices[2] = z;
        vertices[3] = x_;
        vertices[4] = y_;
        vertices[5] = z_;

        type = type_;

        ByteBuffer byteBuf = ByteBuffer.allocateDirect(vertices.length * 4);
        byteBuf.order(ByteOrder.nativeOrder());
        vertexBuffer = byteBuf.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
    }

    public void draw(GL10 gl) {

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        if(type == 0) gl.glColor4f(0.8f, 0.8f, 0.5f, 1.0f);
        if(type == 1) gl.glColor4f(0.2f, 0.8f, 0.2f, 1.0f);
        gl.glLineWidth(3);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glDrawArrays(GL10.GL_LINES, 0, vertices.length/2);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }


}


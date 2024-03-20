package org.UeubungsAufgabe1;

import static org.lwjgl.opengl.GL11.GL_LINE_LOOP;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class NEck {
	int n;
	float[] middlePoint;
	float size;
	public NEck(int n) {
		this.n = n;
		middlePoint = new float[] {0f,0f,0f};
	}
	public NEck(int n, float x, float y, float z) {
		this.n = n;
		this.middlePoint = new float[] {x,y,z};
	}
	public NEck(int n,float size, float x, float y, float z) {
		this.n = n;
		this.size = size;
		this.middlePoint = new float[] {x,y,z};
	}
	public void draw()
	{
		drawNEck();
	}
	
	private void drawNEck()
	{
		double degree = 2*Math.PI/n;
		glColor3f(0,1,0);
		glBegin(GL_LINE_LOOP);
			for(int i = 0; i < n;i++) {
				glVertex3f((float)Math.cos(degree*i)*size+middlePoint[0],(float)Math.sin(degree*i)*size + middlePoint[1],0f+ middlePoint[1]);
			}
		glEnd();
	}
}

package org.UeubungsAufgabe1;//Imports
import static org.lwjgl.opengl.GL11.*;


public class Dreieck
{
	// private Variablen
	float[] vert1;
	float[] vert2;
	float[] vert3;
	public Dreieck(float x1, float y1, float z2, float x2, float y2, float z1, float x3, float y3, float z3) {
		vert1 = new float[] {x1,y1,z1};
		vert2= new float[] {x2,y2,z2};
		vert3 = new float[] {x3,y3,z3};
	}
	public void draw()
	{
		drawDreieck();
	}
	
	private void drawDreieck()
	{
		glColor3f(0,1,0);
		glBegin(GL_TRIANGLES);
			glColor3f(1, 0, 0);  // rot
			glVertex3f(vert1[0], vert1[1], vert1[2]);
			glColor3f(0, 1, 0);  // gruen
			glVertex3f(vert2[1], vert2[1], vert2[2]);
			glColor3f(1, 1, 1);  // weiss
			glVertex3f(vert3[0], vert3[1], vert3[2]);
		glEnd();
	}
}

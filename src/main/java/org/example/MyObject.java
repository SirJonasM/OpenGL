package org.example;//Imports
import static org.lwjgl.opengl.GL11.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils; // to create a float buffer in place of the glfloat array


public class MyObject
{
	// private Variablen
	// keine

	
	public void draw()
	{
		drawDreieck();
	}
	
	private void drawDreieck()
	{
		glColor3f(0,1,0);
		glBegin(GL_TRIANGLES);
			glColor3f(1, 0, 0);  // rot
			glVertex3f(1, 0, 0);
			glColor3f(0, 1, 0);  // gruen
			glVertex3f(-0.75f, -0.75f, 0);
			glColor3f(1, 1, 1);  // weiss
			glVertex3f(0, 0.75f, 0);
		glEnd();
	}
}

package org.example;//Imports
import static org.lwjgl.opengl.GL11.*;

public class MyScene
{
	// private Variablen
	
	MyObject dreieck = new MyObject();
	
	public void initGLState()
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(-2.0, 2.0, -2.0, 2.0, -2.0, 2.0);
		
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		glClearColor(0, 0, 0, 0); // Set the clear color
	}
	
	public void renderLoop()
	{	
		dreieck.draw();	
	}
}

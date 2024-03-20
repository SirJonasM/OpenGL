package org.example;//Imports
import static org.lwjgl.opengl.GL11.*;

public class MyScene
{
	// private Variablen
	
	Dreieck dreieck1 = new Dreieck(0f,0f,0f,.2f,0.2f,0.2f,0f,0.2f,0f);
	Dreieck dreieck2 = new Dreieck(1f,1f,1f,2f,2f,2f,1f,2f,1f);
	NEck neck1 = new NEck(10,2f,0f,0f,0f);
	NEck neck2 = new NEck(1_000,1f,1f,1f,1f);
	NEck neck3 = new NEck(20,0.5f,-1f,-1f,0f);
	NEck neck4 = new NEck(7,0.1f,-1f,1f,0f);
	
	public void initGLState() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(-2.0, 2.0, -2.0, 2.0, -2.0, 2.0);
		
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		glClearColor(0, 0, 0, 0); // Set the clear color
	}
	
	public void renderLoop() {
		dreieck1.draw();
		dreieck2.draw();
		neck1.draw();
		neck2.draw();
		neck3.draw();
		neck4.draw();
	}
}

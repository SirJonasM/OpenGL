package org.UeubungsAufgabe1;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
 
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
import org.lwjgl.BufferUtils; 

import java.nio.IntBuffer;

 
public class Main
{
 
    // The window handle
    private long window;
    
    private final MyScene scene = new MyScene();
    private int WIDTH = 1000, HEIGHT = 1000;

 
    public void run()
    {
        try {
            init();
            loop();
 
            // Reset all callbacks for the specified GLFW window to NULL and free all previously set callbacks.
            glfwFreeCallbacks(window); 
            
            // Destroy the specified window and its context.
            glfwDestroyWindow(window); 
        } finally {
        	
        	// Destroy all remaining windows, free any allocated resources and set the library to an uninitialized state.
			// Once this is called, you must again call glfwInit successfully before you will be able to use 
			// most GLFW functions.
        	glfwTerminate();

        	// Free the error callback
        	glfwSetErrorCallback(null).free();
        }
    }
 
    private void init()
    {
    	
    	// Setup an error callback. The default implementation will print the error message in System.err.
    	GLFWErrorCallback.createPrint(System.err).set();

    	// Initialize GLFW. Most GLFW functions will not work before doing this.
    	if ( !glfwInit() )
    		throw new IllegalStateException("Unable to initialize GLFW");

    	// Configure our window
    	glfwDefaultWindowHints(); // optional, the current window hints are already the default
    	glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
    	glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

 
        // Create the window
        window = glfwCreateWindow(WIDTH, HEIGHT, "Beispiel 1", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");
        
        // Get the resolution of the primary monitor
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        
        // Center our window
        glfwSetWindowPos(window, (vidmode.width() - WIDTH) / 2, (vidmode.height() - HEIGHT) / 2);

        // Make the OpenGL context of the specified window current on the calling thread.
        glfwMakeContextCurrent(window);

        // Set the swap interval for the current OpenGL, i.e. the number of screen updates
		// to wait from the time glfwSwapBuffers was called before swapping the buffers and returning
        glfwSwapInterval(1);
 
        // Make the window visible
        glfwShowWindow(window);
        
        // Create a new GLCapabilities instance for the OpenGL context that is current in the current thread
        GL.createCapabilities();
    }
 
    private void loop()
    {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
 
        scene.initGLState();
 
        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while ( !glfwWindowShouldClose(window) ) {
        	
        	// Clear the color buffers and depth buffer
        	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            
            scene.renderLoop();
 
            // Swap the color buffers
            glfwSwapBuffers(window);
 
            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
            IntBuffer IntWindowWidth = BufferUtils.createIntBuffer(1);
            IntBuffer IntWindowHeight = BufferUtils.createIntBuffer(1);
            
            glfwGetWindowSize(window, IntWindowWidth, IntWindowHeight);
            if (windowSizeChanged(IntWindowWidth, IntWindowHeight))
    		{
            	glViewport(0, 0, WIDTH, HEIGHT);
    		}

            IntWindowWidth.clear();
            IntWindowHeight.clear();
        }
    }
    
    private boolean windowSizeChanged(IntBuffer w, IntBuffer h)
    {
    	if (WIDTH != w.get(0) || HEIGHT != h.get(0))
    	{
    		WIDTH = w.get(0);
    		HEIGHT = h.get(0);
    		return true;
    	}
    	
    	return false;
    }
 
    public static void main(String[] args)
    {
        new Main().run();
    }
}
/*
 * Tutorial original en 
 * http://www.javaworld.com/article/2075966/core-java/start-up-the-velocity-template-engine.html
 */
package emg.demos.velocity;



public class App {

	public static void main(String[] args) {
		Render render = new Render();
		render.hello();
		render.petList();
	}

}

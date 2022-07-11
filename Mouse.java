package application;

import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class Mouse implements EventHandler<MouseEvent>{
	private double x = 0.0;
	private double y = 0.0;
	
	public void Mouse() {
		
	}
	
	public void handle(MouseEvent event) {
		this.x = event.getSceneX();
		this.y = event.getSceneY();
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}	
}

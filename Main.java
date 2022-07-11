package application;
	
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Circle;


public class Main extends Application {
	
	Stage window;
	double limit;
	
	@Override
	public void start(Stage primaryStage) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter limit: ");
		this.limit = scanner.nextInt();
		if (this.limit <= 0) {
			this.limit = 900.0;
		}
		
		window = primaryStage;
		window.setTitle("Vector Demostration");
		
		Group layout = new Group();
		Scene scene = new Scene(layout, 600, 600, Color.WHITE);
		
		Vector v = new Vector(100, 100);
		Mouse mouseMoved = new Mouse();
		v.setX(mouseMoved.getX()-300);
		v.setY(mouseMoved.getY()-300);
		Line line = new Line(300,300, 300+v.getX(), 300+v.getY());
		
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
		      @Override public void handle(MouseEvent event) {
		    	  mouseMoved.handle(event);
		    	  Line line = (Line) layout.getChildren().get(0);
		    	  layout.getChildren().remove(0);
		    	  double startX = line.getStartX();
		    	  double startY = line.getStartY();
		    	  v.setX(mouseMoved.getX()-startX);
		    	  v.setY(mouseMoved.getY()-startY);
		    	  v.limit(limit);
		    	  Line newLine = new Line(startX, startY, startX+v.getX(), startY+v.getY());
		    	  newLine.setStroke(line.getStroke());
		    	  layout.getChildren().add(newLine);
		      }}
		);
		
		Mouse mouseClicked = new Mouse();
		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				mouseClicked.handle(event);
				Line line = (Line) layout.getChildren().get(0);
				line.setStartX(mouseClicked.getX());
				line.setStartY(mouseClicked.getY());
				v.setMag(0);
			}
		});
		
		scene.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override public void handle(KeyEvent event) {
				String character = event.getCharacter();
				Line line = (Line) layout.getChildren().get(0);
				
				if (character.equals("b")){
					line.setStroke(Color.BLUE);
				}else if (character.equals("r")) {
					line.setStroke(Color.RED);
				}else if (character.equals("g")) {
					line.setStroke(Color.GREEN);
				}else if (character.equals("p")) {
					line.setStroke(Color.PURPLE);
				}
				
				layout.getChildren().remove(0);
				layout.getChildren().add(line);
			}
		});
		
		layout.getChildren().add(line);
		window.setScene(scene);
		window.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

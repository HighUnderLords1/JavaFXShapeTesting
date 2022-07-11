package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ShapeTesting extends Application{

	Stage window;
	
	@Override
	public void start(Stage stage){
		window = stage;
		window.setTitle("Shape Testing");
		Group layout = new Group();
		Scene scene = new Scene(layout, 500, 500);
		
		Rectangle rec = new Rectangle();
		rec.setX(0);
		rec.setY(0);
		rec.setFill(Color.BLUE);
		rec.setWidth(50);
		rec.setHeight(50);
		rec.setOnMouseClicked(e -> {rec.setFill(Color.PURPLE);});
		rec.setOnMouseReleased(e -> {rec.setFill(Color.BLUE);});
		
		Circle circ = new Circle();
		circ.setCenterX(250);
		circ.setCenterY(250);
		circ.setRadius(100);
		circ.setFill(Color.RED);
		circ.setOnMouseEntered(e ->{
			circ.setFill(Color.ORANGERED);
		});
		circ.setOnMouseExited(e -> {circ.setFill(Color.RED);});
		circ.setOnMouseClicked(e ->{circ.setFill(Color.GREEN);});
		//circ.setOnMouseReleased(e -> {circ.setFill(Color.RED);});
		
		Polygon poly = new Polygon(100, 75, 200, 175, 100, 175, 100, 75);
		poly.setFill(Color.GREEN);
		
		layout.getChildren().addAll(rec, circ, poly);
		
		window.setScene(scene);
		window.show();
		
	}
	
}

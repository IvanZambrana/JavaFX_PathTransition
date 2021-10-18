package pkg4.pkg3.pkg6pathtransition;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Iván Zambrana Naranjo
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Setting the tittle of the stage
        primaryStage.setTitle("PathTransition in Animation");
        
        //Create circle and rectangle
        Circle circle = new Circle(125, 100, 50);
        circle.setFill(javafx.scene.paint.Color.TRANSPARENT);
        circle.setStroke(Color.web("#0A0A0A"));
        Rectangle rectangle = new Rectangle(20, 50);
        rectangle.setFill(javafx.scene.paint.Color.ORANGE);
        
        //Create a path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(circle);
        pt.setNode(rectangle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(false);
        
        //Start animation
        pt.play();
        
        //MouseEvent
        circle.setOnMousePressed(e->pt.pause());
        circle.setOnMouseReleased(e->pt.play());
        
        //Pane
        Pane root = new Pane();
        
        //Add circle and tringle
        root.getChildren().add(circle);  
        root.getChildren().add(rectangle);
        
        
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

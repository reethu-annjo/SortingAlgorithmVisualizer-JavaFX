/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingvisualizer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Reethu Ann Johnson
 */
public class MainClass extends Application {
    
    @Override
    public void start(Stage Window) {
        
        AnimationControlView VisualizerLayout = new AnimationControlView();
        VisualizerLayout.setStyle("-fx-background-color: #0C4460");
        
        Scene scene = new Scene(VisualizerLayout, VisualizerLayout.WINDOW_WIDTH, VisualizerLayout.WINDOW_HEIGHT);
        
        Window.setTitle("Sorting algorithm visualizer");
        Window.setScene(scene);
        Window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

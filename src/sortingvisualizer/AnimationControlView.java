/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingvisualizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.animation.SequentialTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import nodegenerator.rectNode;
import nodegenerator.RandomNodeGenerator;
import sortingalgorithms.BubbleSort;
import sortingalgorithms.QuickSort;
import sortingalgorithms.SortHandler;

/**
 *
 * @author Reethu Ann Johnson
 */
public class AnimationControlView extends BorderPane{
    public static final int WINDOW_HEIGHT=600;
    public static final int WINDOW_WIDTH=600;
    public static final int BOTTOM_ROW_HEIGHT=100;
    public static final int X_SPACE=10;
    
    public static int NO_OF_NODES = 20;
    
    private static SortHandler sortHandler;
    
    private rectNode[] nodes;
    
    private HBox buttonPanel;
    private Pane displaySort;
    
    private ChoiceBox<SortHandler> selectSortChoice;
    private Button sortButton;
    private final Button shuffleButton;
    private Label speedLabel;
    private Slider speedSlider;
   
    public AnimationControlView(){
        displaySort = new Pane();
        this.setCenter(displaySort);
        
        buttonPanel = new HBox();
        this.setTop(buttonPanel);
        
        this.nodes = RandomNodeGenerator.generateNode(NO_OF_NODES);
        
        displaySort.getChildren().addAll(Arrays.asList(nodes));
        
        this.sortButton = new Button("Sort");
        this.shuffleButton = new Button("Shuffle");
        this.selectSortChoice = new ChoiceBox<>();
        this.speedSlider = new Slider(1,10,1);
        this.speedLabel = new Label("Speed");
        
        speedLabel.setTextFill(Color.WHITE); 
        
        speedSlider.setShowTickMarks(true);
        speedSlider.setMajorTickUnit(4);
        speedSlider.setBlockIncrement(1);
        
        this.buttonPanel.getChildren().add(shuffleButton);
        this.buttonPanel.getChildren().add(selectSortChoice);
        this.buttonPanel.getChildren().add(sortButton);
        this.buttonPanel.getChildren().add(speedLabel);
        this.buttonPanel.getChildren().add(speedSlider);
        
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.getChildren().forEach((b) -> {
            buttonPanel.setMargin(b,new Insets(5,5,20,5));
        });
        
        List<SortHandler> sortList = new ArrayList();
        sortList.add(new QuickSort());
        sortList.add(new BubbleSort());
        
        sortButton.setOnAction(e -> {
            shuffleButton.setDisable(true);
            sortButton.setDisable(true);
            
            sortHandler = selectSortChoice.getSelectionModel().getSelectedItem();
            
            SequentialTransition sq = new SequentialTransition();
            
            sq.getChildren().addAll(sortHandler.startSort(nodes));
            
            speedSlider.valueProperty().addListener( 
             new ChangeListener<Number>() { 
  
            public void changed(ObservableValue <? extends Number >  
                      observable, Number oldValue, Number newValue) 
            { 
  
                sq.setRate((double)newValue); 
            } 
        }); 
            
            sq.play();
            
            sq.setOnFinished(onFinished -> {
                shuffleButton.setDisable(false);
                speedSlider.setValue(1);
            });
        });
        
        shuffleButton.setOnAction((ActionEvent onClick) -> {
            sortButton.setDisable(false);
            displaySort.getChildren().clear();
            this.nodes = RandomNodeGenerator.generateNode(NO_OF_NODES);
            displaySort.getChildren().addAll(Arrays.asList(nodes));
        });
        
        selectSortChoice.setItems(FXCollections.observableArrayList(sortList));
        selectSortChoice.getSelectionModel().select(5);
        selectSortChoice.setValue(new QuickSort());
                
        selectSortChoice.setConverter(new StringConverter<SortHandler>() {
      @Override
      public String toString(SortHandler abstractSort) {
        if(abstractSort == null) {
          return "";
        } else {
          return abstractSort.getClass().getSimpleName();
        }
      }

      @Override
      public SortHandler fromString(String s) {
        return null;
      }
    });

  }
    
}

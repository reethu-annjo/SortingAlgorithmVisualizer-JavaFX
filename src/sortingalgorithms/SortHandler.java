/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import nodegenerator.rectNode;
import sortingvisualizer.AnimationControlView;

/**
 *
 * @author Reethu Ann Johnson
 */
public abstract class SortHandler {
    final Color SORTED_COLOR = Color.WHITE;
    final Color SELECTED_COLOR = Color.CRIMSON;
    final Color ORIGINAL_COLOR = Color.BLACK;
    
    static int move;
    static {
        move = AnimationControlView.WINDOW_WIDTH/AnimationControlView.NO_OF_NODES;
    }
    
    public ParallelTransition colorNode(rectNode[] nodeArray, Color color, int...n){
        ParallelTransition fillNode = new ParallelTransition();
        
        for(int i=0;i<n.length;i++){
            FillTransition fill = new FillTransition();
            fill.setShape(nodeArray[n[i]]);
            fill.setToValue(color);
            fill.setDuration(Duration.millis(1000));
            fillNode.getChildren().add(fill);
        }
        
        return fillNode;
    }
    
    public ParallelTransition colorNode(List<rectNode> nodeList, Color color){
        ParallelTransition fillNode = new ParallelTransition();
        
        for(rectNode node : nodeList){
            FillTransition fill = new FillTransition();
            fill.setShape(node);
            fill.setToValue(color);
            fill.setDuration(Duration.millis(1000));
            fillNode.getChildren().add(fill);
        }
        
        return fillNode;
    }
    
    public ParallelTransition swapNode(rectNode[] nodeArray, int i, int j){
        ParallelTransition swapNode = new ParallelTransition();
        
        int moveRate = j-i;
        
        swapNode.getChildren().addAll(nodeArray[i].moveX(moveRate * move), nodeArray[j].moveX(-move * moveRate));
        
        rectNode temp = nodeArray[i];
        nodeArray[i] = nodeArray[j];
        nodeArray[j] = temp;
        
        return swapNode;
    }
    
    public abstract ArrayList<Transition> startSort(rectNode[] arr);
}

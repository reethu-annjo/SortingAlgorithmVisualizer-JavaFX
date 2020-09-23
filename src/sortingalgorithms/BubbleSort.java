/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.animation.Transition;
import nodegenerator.rectNode;

/**
 *
 * @author Reethu Ann Johnson
 */
public class BubbleSort extends SortHandler{
    
    private ArrayList<Transition> transitions;
    
    public BubbleSort(){
        this.transitions = new ArrayList<>();
    }
    
    private void bubbleSort(rectNode[] nodes){
        int len = nodes.length;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-i-1;j++){
                if(nodes[j].getValue() > nodes[j+1].getValue()){
                    transitions.add(colorNode(nodes, SELECTED_COLOR, j));
                    transitions.add(swapNode(nodes,j,j+1));
                    transitions.add(colorNode(nodes, ORIGINAL_COLOR, j+1));
                }
            }
        }
    }
    
    @Override
    public ArrayList<Transition> startSort(rectNode[] arr) {
       bubbleSort(arr);
       transitions.add(colorNode(Arrays.asList(arr),SORTED_COLOR));
       
       return transitions;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import nodegenerator.rectNode;

/**
 *
 * @author Reethu Ann Johnson
 */
public class QuickSort extends SortHandler{
    
   private static final Color PIVOT_COLOR = Color.DARKGRAY; 
   private ArrayList<Transition> transitions;
   
   public QuickSort() {
    this.transitions = new ArrayList<>();
  }
   
   private void quickSort(rectNode[] nodes, int low, int high){
       if(low<high){
           int pivot = partition(nodes,low, high);
           quickSort(nodes,low,pivot-1);
           quickSort(nodes,pivot+1,high);
       }
   }
   
   private int partition(rectNode[] nodes, int low, int high){
       int i=low;
       
       transitions.add(colorNode(nodes,PIVOT_COLOR,high));
       
       for(int j=low;j<high;j++){
          transitions.add(colorNode(nodes, SELECTED_COLOR, j));
          if(nodes[j].getValue() <= nodes[high].getValue()){
              transitions.add(swapNode(nodes,i,j));
              transitions.add(colorNode(nodes,ORIGINAL_COLOR,i));
              i++;
          } else {
              transitions.add(colorNode(nodes,ORIGINAL_COLOR,j));
          }
       }
       transitions.add(swapNode(nodes,i,high));
       transitions.add(colorNode(nodes,SORTED_COLOR,i));
       
       return i;
   }

    @Override
    public ArrayList<Transition> startSort(rectNode[] nodeArray) {
        quickSort(nodeArray, 0, nodeArray.length - 1);
        transitions.add(colorNode(Arrays.asList(nodeArray),SORTED_COLOR));
        
        return transitions;
    }
   
}

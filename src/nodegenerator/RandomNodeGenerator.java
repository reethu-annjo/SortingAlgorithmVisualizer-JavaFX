    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodegenerator;

import java.util.Random;
import sortingvisualizer.AnimationControlView;
import javafx.scene.paint.Color;

/**
 *
 * @author Reethu Ann Johnson
 */
public class RandomNodeGenerator {
    
    public RandomNodeGenerator () {}
    
    public static rectNode[] generateNode(int num){
        rectNode[] nodeArray = new rectNode[num];
        Random randomNum = new Random();
        for(int i=0;i<nodeArray.length;i++){
            nodeArray[i] = new rectNode(randomNum.nextInt(nodeArray.length)+1);
            nodeArray[i].setX(i*(AnimationControlView.WINDOW_WIDTH/nodeArray.length));
            nodeArray[i].setFill(Color.BLACK);
            setNodeDimension(nodeArray[i],nodeArray.length);
        }
        return nodeArray;
    }
    
    public static void setNodeDimension(rectNode node, int len){
        node.setWidth(AnimationControlView.WINDOW_WIDTH/len - AnimationControlView.X_SPACE);
        node.setHeight(((AnimationControlView.WINDOW_HEIGHT - AnimationControlView.BOTTOM_ROW_HEIGHT)/len)*node.getValue());
    }
}

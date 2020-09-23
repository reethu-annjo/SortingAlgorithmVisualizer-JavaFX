/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodegenerator;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Reethu Ann Johnson
 */
public class rectNode extends Rectangle{
    private int value;
    
    public rectNode (int n) {
        this.value = n;
    }
    
    public int getValue() {
    return this.value;
    }
    
    public TranslateTransition moveX(int x){
        TranslateTransition Xmove = new TranslateTransition();
        Xmove.setNode(this);
        Xmove.setDuration(Duration.millis(1000));
        Xmove.setByX(x);
        return Xmove;
    }
}

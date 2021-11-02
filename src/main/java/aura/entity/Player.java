package aura.entity;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;

public class Player {
    private int moveSpeed;
    private boolean isColliding;
    private int stamina;
    private boolean isClimbing;
    private boolean isWalking;
    private boolean isRunning;
    private Class<? extends EntityCollidable> collidingWith;
    private float x, y;
    private int blueberries;
    public void onUpdate(){
        if(isClimbing){
            y += moveSpeed;
        }
        if(isWalking && !isRunning){
            x += moveSpeed;
        }else if(isRunning && !isWalking){
            x += moveSpeed*2;
        }
    }
    public void onRender(){

    }
    public void initKeypress(){
        Input input = FXGL.getInput();

        input.addAction(new UserAction("Forward"){
            @Override
            protected void onActionBegin() {
                isWalking = true;
            }

            @Override
            protected void onActionEnd() {
                isWalking = false;
            }
        }, KeyCode.RIGHT);
    }
    public void initMouseclick(){

    }
}

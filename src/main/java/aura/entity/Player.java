package aura.entity;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;

public class Player {
    private int moveSpeed;
    private boolean isColliding;
    private int stamina;
    private float motionX;
    private float motionY;
    private Class<? extends EntityCollidable> collidingWith;
    private float x, y;
    private int blueberries;
    public void onUpdate(){
        x += motionX;
        y += motionY;
    }
    public void onRender(){

    }
    public void initKeypress(){
        Input input = FXGL.getInput();

        input.addAction(new UserAction("Forward"){
            @Override
            protected void onActionBegin() {
                motionX = moveSpeed;
            }

            @Override
            protected void onActionEnd() {
                motionX = 0;
            }
        }, KeyCode.RIGHT);
        input.addAction(new UserAction("Backward"){
            @Override
            protected void onActionBegin() {
                motionY = -moveSpeed;
            }

            @Override
            protected void onActionEnd() {
                motionY = 0;
            }
        }, KeyCode.LEFT);
    }
    public void initMouseclick(){

    }
}

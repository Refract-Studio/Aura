package aura.entity;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;

public class Player implements Entity {
    // speed of movement
    private int moveSpeed;
    // is colliding
    private boolean isColliding;
    // stamina for climbing
    private int stamina;
    // motion{x, y}, @author SethTheDev
    public float motionX;
    public float motionY;
    // entity that it is colliding with
    private Entity collidingWith;
    // x, y position
    private float x, y;
    // blueberries
    private int blueberries;
    // strawberries
    private int strawberries;

    // runs every tick
    @Override
    public void onUpdate() {
        x += motionX;
        y += motionY;
    }

    public void onRender() {

    }

    // initialises input
    public void initKeypress() {
        // get input
        Input input = FXGL.getInput();

        // adds forward action
        input.addAction(new UserAction("Forward") {
            // when action begins
            @Override
            protected void onActionBegin() {
                motionX = moveSpeed;
            }

            // when action ends
            @Override
            protected void onActionEnd() {
                motionX = 0;
            }
        }, KeyCode.RIGHT); // uses keycode right

        // adds backward action
        input.addAction(new UserAction("Backward") {
            // when action begins
            @Override
            protected void onActionBegin() {
                motionY = -moveSpeed;
            }

            // when action ends
            @Override
            protected void onActionEnd() {
                motionY = 0;
            }
        }, KeyCode.LEFT); // uses keycode left
    }

    // todo @seththedev what is this?
    public void initMouseClick() {
        //This code is where we register mouse click's!
    }
}

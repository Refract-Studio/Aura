package aura.entity;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.util.ArrayList;

public class Player extends com.almasb.fxgl.entity.Entity implements Entity {
    // speed of movement
    private int moveSpeed;
    // is colliding
    private boolean isColliding;
    // stamina for climbing
    private int stamina;
    // motion{x, y}, @author SethTheDev
    //public float motionX;
    //public float motionY;
    // entity that it is colliding with
    private ArrayList<Entity> collidingWith; //We need a list of entities if multiple entities are collided
    // x, y position
    private float x, y;
    // blueberries
    private int blueberries;
    // strawberries
    private int strawberries;

    // runs every tick

    public Player(){
        this.moveSpeed = 5;
        this.isColliding = false;
        this.stamina = 9;
        this.collidingWith = new ArrayList<Entity>();
        this.x = 1920/2;
        this.y = 1080/2;
        this.blueberries = 0;
        this.strawberries = 0;
    }

    @Override
    public void onUpdate() {
    }

    // initialises input
    public void initKeypress() {
        // get input
        Input input = FXGL.getInput();

        input.addAction(new UserAction("Forward") {
            @Override
            protected void onAction() {
                translateX(moveSpeed);
                System.out.println(moveSpeed);
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Backward") {
            @Override
            protected void onActionBegin() {
                translateX(-moveSpeed);
                System.out.println(-moveSpeed);
            }
        }, KeyCode.D);
    }

    public void initMouseClick() {
        Input input = FXGL.getInput();

        input.addAction(new UserAction("Click") {
            @Override
            protected void onActionEnd() {
                System.out.println("MOUSE CLICK");
            }
        }, MouseButton.PRIMARY);
    }
}

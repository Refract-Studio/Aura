package aura.entity;

import aura.AuraApp;
import aura.level.LevelClass;
import aura.level.LevelLoader;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Rectangle;
import static com.almasb.fxgl.dsl.FXGLForKtKt.*;
import java.util.ArrayList;

public class Player extends com.almasb.fxgl.entity.Entity implements aura.entity.Entity {
    // speed of movement
    private int moveSpeed;
    // is colliding
    private boolean isColliding;
    // is in air or can go down
    private boolean gravitationalPossibility;
    // is climbing
    private boolean isClimbing;
    // stamina for climbing
    private int stamina;
    // motion{x, y}, @author SethTheDev
    //public float motionX;
    //public float motionY;
    // entity that it is colliding with
    private ArrayList<com.almasb.fxgl.entity.Entity> collidingWith; // We need a list of entities if multiple entities are collided
    // x, y position
    public static float x, y;
    // blueberries
    private int blueberries;
    // strawberries
    private int strawberries;
    // controls physics
    private Runnable physics;
    // seconds in bubble
    public int ticksInBubble;



    public Player() {
        this.moveSpeed = 5;
        this.isColliding = false;
        this.stamina = 9;
        this.collidingWith = new ArrayList<com.almasb.fxgl.entity.Entity>();
        this.x = 1920/2;
        this.y = 1080/2;
        this.gravitationalPossibility = false;
        this.blueberries = 0;
        this.strawberries = 0;
        this.isClimbing = false;
    }

    @Override
    public void onUpdate() {
        AuraApp.setPlayerX((int) x);
        AuraApp.setPlayerY((int) y);
        if (gravitationalPossibility && !isClimbing) {
            AuraApp.setPlayerX((int) AuraApp.getPlayerX() - 1);
        }
        if (isClimbing) {
            stamina--;
        }
        if (stamina < 15000000) {
            isClimbing = false;
            gravitationalPossibility = true;
        }
        if (isColliding(AuraApp.getLevelLoader().newCloudR(null)) || isColliding(AuraApp.getLevelLoader().newCloudL(null)) || isColliding(AuraApp.getLevelLoader().newCloudU(null)) || isColliding(AuraApp.getLevelLoader().newCloudD(null))) {
            ticksInBubble++;
        }
        entityBuilder().at(x, y).viewWithBBox(new Rectangle(20, 20)).buildAndAttach();
    }

    public void addStrawberry() {
        strawberries++;
    }

    public void addBlueberry() {
        blueberries++;
    }

    public void setBlueberries(int blueberries) {
        this.blueberries = blueberries;
    }

    public void setStrawberries(int strawberries) {
        this.strawberries = strawberries;
    }

    // initialises input
    public void initKeypress() {
        // get input
        Input input = FXGL.getInput();

        input.addAction(new UserAction("Forward") {
            @Override
            protected void onAction() {
                x += moveSpeed;
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Backward") {
            @Override
            protected void onAction() {
                x -= moveSpeed;
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Up") {
            @Override
            protected void onAction() {
                y -= moveSpeed;
            }
        }, KeyCode.W);

        input.addAction(new UserAction("Down") {
            @Override
            protected void onAction() {
                y += moveSpeed;
            }
        }, KeyCode.S);

        input.addAction(new UserAction("Click") {
            @Override
            protected void onAction() {
                x = (float) input.getMouseXUI();
                y = (float) input.getMouseYUI();
            }
        }, MouseButton.PRIMARY);
    }

    public void initPhysics() {

    }
}

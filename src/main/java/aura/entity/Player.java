package aura.entity;

import aura.AuraApp;
import aura.api.Entity;
import aura.api.MoveDirection;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Rectangle;
import org.jetbrains.annotations.Nullable;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;
import java.util.ArrayList;

public class Player extends com.almasb.fxgl.entity.Entity implements Entity {
    // speed of movement
    public static  int moveSpeed;
    // is colliding
    public static boolean isColliding;
    // is in air or can go down
    public static  boolean gravitationalPossibility;
    // is climbing
    public static  boolean isClimbing;
    // stamina for climbing
    public static  int stamina;
    // motion{x, y}, @author SethTheDev
    public static float motionX;
    public static float motionY;
    public static  boolean motionNeeded;
    public static  boolean idle;
    public static MoveDirection facing;
    public static MoveDirection moving;
    // entity that it is colliding with
    public static ArrayList<com.almasb.fxgl.entity.Entity> collidingWith; // We need a list of entities if multiple entities are collided
    // x, y position
    public static float x, y;
    // blueberries
    public static  int blueberries;
    // strawberries
    public static  int strawberries;
    // controls physics
    public static  Runnable physics;
    // seconds in bubble
    public static  int ticksInBubble;



    public Player() {
        moveSpeed = 5;
        isColliding = false;
        stamina = 9;
        collidingWith = new ArrayList<com.almasb.fxgl.entity.Entity>();
        x = 1920/2;
        y = 1080/2;
        gravitationalPossibility = false;
        blueberries = 0;
        strawberries = 0;
        this.isClimbing = false;
        this.idle = false;
        this.motionX = 0;
        this.motionY = 0;
    }

    @Override
    public void onUpdate() {
        y += motionY;
        x += motionX;
        if (gravitationalPossibility && !isClimbing) {
            y--;
        }
        if (isClimbing) {
            stamina--;
        }
        if (stamina < 15000000) {
            isClimbing = false;
            gravitationalPossibility = true;
        }
        SpawnData data = new SpawnData();
        if (isColliding(AuraApp.getLevelLoader().newBubble(data))) {
            ticksInBubble++;
        }
    }

    public static  void addStrawberry() {
        strawberries++;
    }

    public static  void addBlueberry() {
        blueberries++;
    }

    public static  void setBlueberries(int blueberries) {
        Player.blueberries = blueberries;
    }

    public static  void setStrawberries(int strawberries) {
        Player.strawberries = strawberries;
    }

    // initialises input
    public static  void initKeypress() {
        // get input
        Input input = FXGL.getInput();

        input.addAction(new UserAction("Forward") {
            @Override
            protected void onAction() {
                motionX += moveSpeed;
                moving = MoveDirection.Right;
                isClimbing = false;
            }
        }, KeyCode.RIGHT);

        input.addAction(new UserAction("Backward") {
            @Override
            protected void onAction() {
                motionX -= moveSpeed;
                moving = MoveDirection.Left;
                isClimbing = false;
            }
        }, KeyCode.LEFT);

        input.addAction(new UserAction("Down") {
            @Override
            protected void onAction() {
                motionY += moveSpeed;
                moving = MoveDirection.Down;
                isClimbing = false;
            }
        }, KeyCode.DOWN);


        input.addAction(new UserAction("Dash") {
            @Override
            protected void onAction() {
                motionX += moveSpeed * 2.0;
                isClimbing = false;
            }
        }, KeyCode.X);

        input.addAction(new UserAction("Jump") {
            @Override
            protected void onAction() {
                motionY += 20;
            }
        }, KeyCode.C);

        input.addAction(new UserAction("Climb") {
            @Override
            protected void onAction() {
                super.onAction();
                isClimbing = true;
            }
        }, KeyCode.Z);

        if (isClimbing) {
            input.addAction(new UserAction("Up") {
                @Override
                protected void onAction() {
                    motionY += 2;
                }
            }, KeyCode.UP);
        }
    }
}

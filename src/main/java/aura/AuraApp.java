package aura;

import aura.entity.Entity;
import aura.entity.Player;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class AuraApp extends GameApplication {
    //test

    // main class for game, handles app and GUI

    // things todo:
    // LevelUtils.loadLevel(player.currentLevel);
    // make UI
    ArrayList<Entity> entities = new ArrayList<Entity>();
    Player player = new Player();
    com.almasb.fxgl.entity.Entity player1 = player;
    static int x = 1920/2;
    static int y = 1080/2;


    protected void initEntities() {
        entities.add(player);
    }

    public AuraApp() {
        initEntities();
        //executor.scheduleAtFixedRate(hookRunnable, 0, 20, TimeUnit.MILLISECONDS); ONUPDATE is being used!
    }

    @Override
    protected void onUpdate(double tpf) {
        hookRunnable.run(); //Cannot execute it as a thread to prevent concurrent modification!
    }

    public static int getPlayerX() {
        return x;
    }

    public static void setPlayerX(int toChange) {
        x = toChange;
    }

    public int getPlayerY() {
        return y;
    }

    public static void setPlayerY(int toChange) {
        y = toChange;
    }
    @Override
    protected void initSettings(GameSettings settings) {
        // launches GUI for game and adds width, height and title
        settings.setWidth(1920);
        settings.setHeight(1080);
        settings.setTitle("Aura");
        settings.setVersion("");
    }

    @Override
    protected void initUI() {
        com.almasb.fxgl.entity.Entity title = FXGL.entityBuilder().at(650, 260).view("comp-ts.png").buildAndAttach();
        com.almasb.fxgl.entity.Entity play = FXGL.entityBuilder().at(650, 200).view("comp-play.png").buildAndAttach();
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("name", "Aura");
    }

    @Override
    protected void initInput() {
        player.initKeypress();
        // boom stuff tm
    }

    @Override
    protected void initGame() {

    }

    Runnable hookRunnable = () -> {
        for (Entity e : entities) {
            e.onUpdate();
        }
    };


    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    public static void main(String[] args) {
        launch(args);
    }
}
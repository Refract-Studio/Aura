package aura;

import aura.entity.Entity;
import aura.entity.Player;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class AuraApp extends GameApplication {
    // main class for game, handles app and GUI

    // things todo:
    // LevelUtils.loadLevel(player.currentLevel);
    // make UI
    ArrayList<Entity> entities = new ArrayList<Entity>();
    Player player = new Player();
    com.almasb.fxgl.entity.Entity player1 = player;

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
        Text text = new Text();
        text.setTranslateX(960);
        text.setTranslateY(580);
        text.textProperty().setValue("Aura");

        getGameScene().addUINode(text);
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("name", "Aura");
    }

    @Override
    protected void initInput() {
        player.initKeypress();
        player.initMouseClick();
    }

    @Override
    protected void initGame() {
        player1 = spawnPlayer(getAppWidth()/2, getAppHeight()/2);
    }

    Runnable hookRunnable = () -> {
        for (Entity e : entities) {
            e.onUpdate();
        }
    };

    public com.almasb.fxgl.entity.Entity spawnPlayer(double posX, double posY){
        return entityBuilder().at(posX, posY).viewWithBBox(new Rectangle(20, 20)).buildAndAttach();
    }

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    public static void main(String[] args) {
        launch(args);
    }
}
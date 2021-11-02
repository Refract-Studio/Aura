package aura;

import aura.entity.Entity;
import aura.entity.Player;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AuraApp extends GameApplication {
    // main class for game, handles app and GUI

    // things todo:
    // LevelUtils.loadLevel(player.currentLevel);
    // make UI
    ArrayList<Entity> entities = new ArrayList<Entity>();
    Player player = new Player();

    protected void initEntities() {
        entities.add(player);
    }

    public AuraApp() {
        initEntities();
        executor.scheduleAtFixedRate(hookRunnable, 0, 20, TimeUnit.MILLISECONDS);
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
    protected void initInput() {
        player.initKeypress();
        player.initMouseClick();
    }

    Runnable hookRunnable = new Runnable() {
        @Override
        public void run() {
            for (Entity e : entities) {
                e.onUpdate();
            }
        }
    };

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);


    public static void main(String[] args) {
        launch(args);
    }
}
package aura;

import aura.entity.Entity;
import aura.entity.Player;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import javafx.beans.property.StringProperty;
import javafx.scene.text.Text;
import java.util.Map;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;

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
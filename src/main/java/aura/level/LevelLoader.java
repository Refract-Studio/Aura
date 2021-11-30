package aura.level;

import aura.AuraApp;
import aura.entity.Player;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;

public class LevelLoader implements LevelClass, EntityFactory {

    public String name;

    @Override
    public void work(TSXLevel lvl) {
        // todo write code to load tsx level
    }

    @Spawns("CloudLeft")
    public Entity newCloudL(SpawnData data) {
        Entity cloud = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("entity-cloud.png").getNode()).buildAndAttach();
        if (cloud.isColliding(AuraApp.player)) {
            Player.x -= 50;
            if (AuraApp.player.ticksInBubble > 10000000) {
                Entity erase = FXGL.entityBuilder().at(data.getX(), data.getY()).buildAndAttach();
                // todo check if actually erases
            }
        }
        return cloud;
    }

    @Spawns("CloudRight")
    public Entity newCloudR(SpawnData data) {
        Entity cloud = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("entity-cloud.png").getNode()).buildAndAttach();
        if (cloud.isColliding(AuraApp.player)) {
            Player.x += 50;
        }
        return cloud;
    }

    @Spawns("CloudUp")
    public Entity newCloudU(SpawnData data) {
        Entity cloud = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("entity-cloud.png").getNode()).buildAndAttach();
        if (cloud.isColliding(AuraApp.player)) {
            Player.y += 50;
        }
        return cloud;
    }

    @Spawns("CloudDown")
    public Entity newCloudD(SpawnData data) {
        Entity cloud = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("entity-cloud.png").getNode()).buildAndAttach();
        if (cloud.isColliding(AuraApp.player)) {
            Player.y -= 50;
        }
        return cloud;
    }


    @Spawns("Bubble")
    public Entity newBubble(SpawnData data) {
        Entity bubble = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("entity-bubble.png").getNode()).buildAndAttach();
        if (bubble.isColliding(AuraApp.player)) {
            AuraApp.setPlayerX((int) (bubble.getX() / 2));
            if (AuraApp.player.ticksInBubble > 10000000) {
                Entity erase = FXGL.entityBuilder().at(data.getX(), data.getY()).buildAndAttach();
                // todo check if actually erases
            }
        }
        return bubble;
    }
}
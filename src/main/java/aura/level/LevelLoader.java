package aura.level;

import aura.AuraApp;
import aura.entity.CollisionReflector;
import aura.entity.Player;
import com.almasb.fxgl.core.reflect.ReflectionUtils;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;

import java.lang.reflect.Method;

public class LevelLoader implements LevelClass, EntityFactory {

    public String name;
    CollisionReflector reflector;

    @Override
    public void work(TSXLevel lvl) {
        // todo write code to load tsx level
    }

    @Spawns("CloudLeft")
    public Entity newCloudL(SpawnData data) {
        Entity cloud = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("entity-cloud.png").getNode()).buildAndAttach();
        if (cloud.isColliding(AuraApp.player)) {
            Player.motionX -= 50;
            if (AuraApp.player.ticksInBubble > 10000000) {
                Entity erase = FXGL.entityBuilder().at(data.getX(), data.getY()).buildAndAttach();
                AuraApp.player.isColliding = true;
                AuraApp.player.collidingWith.add(cloud);
                // todo check if actually erases
            }
        }
        return cloud;
    }

    @Spawns("CloudRight")
    public Entity newCloudR(SpawnData data) {
        Entity cloud = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("entity-cloud.png").getNode()).buildAndAttach();
        if (cloud.isColliding(AuraApp.player)) {
            Player.motionX += 50;
            AuraApp.player.isColliding = true;
            AuraApp.player.collidingWith.add(cloud);
        }
        return cloud;
    }

    @Spawns("CloudUp")
    public Entity newCloudU(SpawnData data) {
        Entity cloud = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("entity-cloud.png").getNode()).buildAndAttach();
        if (cloud.isColliding(AuraApp.player)) {
            Player.motionY += 50;
            AuraApp.player.isColliding = true;
            AuraApp.player.collidingWith.add(cloud);
        }
        return cloud;
    }

    @Spawns("CloudDown")
    public Entity newCloudD(SpawnData data) {
        Entity cloud = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("entity-cloud.png").getNode()).buildAndAttach();
        if (cloud.isColliding(AuraApp.player)) {
            Player.motionY -= 50;
            AuraApp.player.isColliding = true;
            AuraApp.player.collidingWith.add(cloud);
        }
        // todo add collision listener for clouds and bubbles
        return cloud;
    }


    @Spawns("Bubble")
    public Entity newBubble(SpawnData data) {
            Entity bubble = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("entity-bubble.png").getNode()).buildAndAttach();
            // how is this triggering onUpdate?
            // i think it might be because of the usage in Player (80), and the X and Y being null (as the exception is a null pointer exception). this can go ahead but I don't know if it will cause infra changes, watch out!
            // breaking news: it breaks
            // maddy's java skills go brrr
            if (bubble.isColliding(AuraApp.player)) {
                AuraApp.setPlayerX((int) (bubble.getX() / 2));
                AuraApp.player.isColliding = true;
                AuraApp.player.collidingWith.add(bubble);
                if (AuraApp.player.ticksInBubble > 10000000) {
                    Entity erase = FXGL.entityBuilder().at(data.getX(), data.getY()).buildAndAttach();
                    // todo check if actually erases
                }
            }
            return bubble;
    }

    @Spawns("Grass1")
    public Entity newGrass1(SpawnData data) {
        Entity grass = FXGL.entityBuilder().at(data.getX(), data.getY()).buildAndAttach();
        if (AuraApp.player.isColliding(grass)) {
            AuraApp.player.isColliding = true;
            AuraApp.player.collidingWith.add(grass);
        }
            reflector.registerOngoingCollisionHandler(grass, AuraApp.player, getMethod("newGrass1"));
        return grass;
    }

    @Spawns("Grass2")
    public Entity newGrass2(SpawnData data) {
        Entity grass = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("Grass2.png")).buildAndAttach();
        if (AuraApp.player.isColliding(grass)) {
            AuraApp.player.isColliding = true;
            AuraApp.player.collidingWith.add(grass);
        }
        reflector.registerOngoingCollisionHandler(grass, AuraApp.player, getMethod("newGrass2"));
        return grass;
    }

    @Spawns("Grass3")
    public Entity newGrass3(SpawnData data) {
        Entity grass = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("Grass3.png")).buildAndAttach();
        if (AuraApp.player.isColliding(grass)) {
            AuraApp.player.isColliding = true;
            AuraApp.player.collidingWith.add(grass);
        }
        reflector.registerOngoingCollisionHandler(grass, AuraApp.player, getMethod("newGrass3"));
        return grass;
    }

    @Spawns("DirtNormal")
    public Entity newDirtNormal(SpawnData data) {
        Entity dirt = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("DirtNormal.png")).buildAndAttach();
        if (AuraApp.player.isColliding(dirt)) {
            AuraApp.player.isColliding = true;
            AuraApp.player.collidingWith.add(dirt);
        }
        reflector.registerOngoingCollisionHandler(dirt, AuraApp.player, getMethod("newDirtNormal"));
        return dirt;
    }

    @Spawns("DirtSlim")
    public Entity newDirtSlim(SpawnData data) {
        Entity dirt = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("DirtSlim.png")).buildAndAttach();
        if (AuraApp.player.isColliding(dirt)) {
            AuraApp.player.isColliding = true;
            AuraApp.player.collidingWith.add(dirt);
        }
        reflector.registerOngoingCollisionHandler(dirt, AuraApp.player, getMethod("newDirtSlim"));
        return dirt;
    }

    @Spawns("Blueberry1")
    public Entity newBlueberry1(SpawnData data) throws NoSuchMethodException {
        Entity blueberry = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("entity-blueberry")).buildAndAttach();
        if (AuraApp.player.isColliding(blueberry)) {
            Player.addBlueberry();
        }
        reflector.registerOngoingCollisionHandler(blueberry, AuraApp.player, getMethod("newBlueberry"));
        return blueberry;
    }


    @Spawns("Blueberry2")
    public Entity newBlueberry2(SpawnData data)  throws NoSuchMethodException {
        Entity blueberry = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("entity-blueberry2")).buildAndAttach();
        if (AuraApp.player.isColliding(blueberry)) {
            Player.addBlueberry();
            Player.addBlueberry();
        }
        reflector.registerOngoingCollisionHandler(blueberry, AuraApp.player, getMethod("newBlueberry2"));
        return blueberry;
    }


    @Spawns("Blueberry3")
    public Entity newBlueberry3(SpawnData data)  throws NoSuchMethodException {
        Entity blueberry = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("entity-blueberry3")).buildAndAttach();
        if (AuraApp.player.isColliding(blueberry)) {
            Player.addBlueberry();
            Player.addBlueberry();
            Player.addBlueberry();
        }
        reflector.registerOngoingCollisionHandler(blueberry, AuraApp.player, getMethod("newBlueberry3"));
        return blueberry;
    }

    @Spawns("Log")
    public Entity newLog(SpawnData data) throws NoSuchMethodException {
        Entity log = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("Log.png")).buildAndAttach();
        if (AuraApp.player.isColliding(log)) {
            AuraApp.player.isColliding = true;
            AuraApp.player.collidingWith.add(log);
        }
        reflector.registerOngoingCollisionHandler(log, AuraApp.player, getMethod("newLog"));
        return log;
    }

    @Spawns("StoneBrickRoad")
    public Entity newRoad(SpawnData data) throws NoSuchMethodException {
        Entity road = FXGL.entityBuilder().at(data.getX(), data.getY()).view(FXGL.getAssetLoader().loadTexture("StoneBrickRoad.png")).buildAndAttach();
        if (AuraApp.player.isColliding(road)) {
            AuraApp.player.isColliding = true;
            AuraApp.player.collidingWith.add(road);
        }
        reflector.registerOngoingCollisionHandler(road, AuraApp.player, getMethod("newRoad"));
        return road;
    }

    public Method getMethod(String name) {
        return ReflectionUtils.getMethod(getClass(), name, SpawnData.class);
    }

    public void initCollisions() {
    }
}
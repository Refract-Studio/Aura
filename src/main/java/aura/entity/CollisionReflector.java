package aura.entity;

import com.almasb.fxgl.entity.Entity;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CollisionReflector {

    public CollisionReflector() {
        setupCollisionExecutor();
    }

    Runnable collisionExecutable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < collisionHandlers.size(); i++) {
                if (collisionHandlers.get(handlers.get(i)).get(1).isColliding(collisionHandlers.get(handlers.get(i)).get(2))) {
                    try {
                        handlers.get(i).invoke(null, null);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    ArrayList<Method> handlers = new ArrayList<Method>();
    HashMap<Method, ArrayList<Entity>> collisionHandlers = new HashMap<Method, ArrayList<Entity>>();

    public void registerOngoingCollisionHandler(Entity e, Entity toCheck, Method method) {
        ArrayList<Entity> entities = new ArrayList<Entity>();
        entities.add(e);
        entities.add(toCheck);

        handlers.add(method);
        collisionHandlers.put(method, entities);
    }

    public void setupCollisionExecutor() {
        ScheduledExecutorService threadExec = Executors.newScheduledThreadPool(1);
        threadExec.scheduleAtFixedRate(collisionExecutable, 0, 2, TimeUnit.MILLISECONDS);
    }
}

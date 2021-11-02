package aura.entity.game;

import aura.ID;
import aura.entity.EntityCollidable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class EntityCloud extends EntityCollidable {
    // moves when jumped on
    // direction specified in constructor
    // todo sprite to be drawn
    int x, y;
    ID id = new ID("cloud", 1);
    MoveDirection md;
    BufferedImage sprite = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/cloud.svg")));
    Class cloud;

    public EntityCloud(int x, int y, MoveDirection md) throws IOException {
        this.x = x;
        this.y = y;
        this.md = md;
        this.draw();
    }

    private void draw() {
        // todo draws sprite at position x by y
    }

    // TODO https://github.com/AlmasB/FXGL/wiki/Adding-Collisions#tutorial-brief tutorial for collisions
}

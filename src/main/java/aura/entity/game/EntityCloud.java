package aura.entity.game;

import aura.ID;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class EntityCloud {
    // moves when jumped on
    // direction specified in constructor
    // todo sprite to be drawn
    // x, y
    int x, y;
    // move direction
    MoveDirection md;
    // sprite
    Image sprite = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/textures/entity-cloud.png")));

    public EntityCloud(int x, int y, MoveDirection md) throws IOException {
        this.x = x;
        this.y = y;
        this.md = md;
        this.draw();
    }

    private void draw() {
        // todo draws sprite at position x by y, implement method
    }

    // TODO https://github.com/AlmasB/FXGL/wiki/Adding-Collisions#tutorial-brief tutorial for collisions
}

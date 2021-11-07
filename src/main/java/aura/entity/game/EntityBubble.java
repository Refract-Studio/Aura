package aura.entity.game;

import com.almasb.fxgl.entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class EntityBubble {
    // sprite
    Image sprite = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/assets/textures/entity-bubble.png")));
    // direction to move
    MoveDirection intentDirection;

    public EntityBubble(MoveDirection intentDirection) throws IOException {
        this.intentDirection = intentDirection;
    }

    // to draw
    public void draw(int x, int y) {

    }
}
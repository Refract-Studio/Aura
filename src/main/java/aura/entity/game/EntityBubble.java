package aura.entity.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class EntityBubble {
    Image sprite = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/assets/textures/entity-bubble.png")));
    MoveDirection intentDirection;

    public EntityBubble(MoveDirection intentDirection) throws IOException {
        this.intentDirection = intentDirection;
    }

    public void draw() {

    }
}
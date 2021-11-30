package aura.entity.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class EntityBerry {
    // sprites
    Image blueSprite = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/assets/textures/entity-blueberry.png")));
    Image redSprite = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/assets/textures/entity-strawberry.png")));

    // sprite to draw
    Image spriteToUse;

    // type of berry
    BerryType berryType;

    public EntityBerry(BerryType berryType) throws IOException {
        this.berryType = berryType;
        checkBerryType();
    }

    // checks berry type and changes sprite to use
    public void checkBerryType() {
        if (berryType == BerryType.Blue) {
            spriteToUse = blueSprite;
        } else if (berryType == BerryType.Red) {
            spriteToUse = redSprite;
        }
    }
}

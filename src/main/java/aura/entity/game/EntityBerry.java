package aura.entity.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class EntityBerry {
    Image blueSprite = ImageIO.read(getClass().getResource("/resources/assets/textures/entity-blueberry.png"));
    Image redSprite = ImageIO.read(getClass().getResource("/resources/assets/textures/entity-strawberry.png"));
    Image spriteToUse;
    BerryType berryType;

    public EntityBerry(BerryType berryType) throws IOException {
        this.berryType = berryType;
        checkBerryType();
    }

    public void checkBerryType() {
        if (berryType == BerryType.BLUE) {
            spriteToUse = blueSprite;
        } else if (berryType == BerryType.RED) {
            spriteToUse = redSprite;
        }
    }

    public void draw() {
        // todo implement method
    }
}

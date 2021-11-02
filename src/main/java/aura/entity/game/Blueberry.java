package aura.entity.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Blueberry {
    Image sprite = ImageIO.read(getClass().getResource("/resources/blueberry.svg"));

    public Blueberry() throws IOException {

    }

    public void draw() {
        // todo implement methodo
    }
}

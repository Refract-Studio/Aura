package aura.ui;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.dsl.FXGL;

public class UIUtils {
   public static void drawUIComponent(int x, int y, UIDrawable u) {
     String name = u.toString() + ".png";
     Entity e = FXGL.entityBuilder().at(x, y).view(name).buildAndAttach();
   }
}
